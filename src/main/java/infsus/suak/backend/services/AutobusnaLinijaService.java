package infsus.suak.backend.services;

import infsus.suak.backend.dtos.AutobusnaLinijaDTO;
import infsus.suak.backend.dtos.NovaAutobusnaLinijaDTO;
import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.mappers.AutobusnaLinijaMapper;
import infsus.suak.backend.mappers.PutnikMapper;
import infsus.suak.backend.models.*;
import infsus.suak.backend.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutobusnaLinijaService {

    private final AutobusnaLinijaRepository repository;
    private final PutnikRepository putnikRepository;
    private final PeronRepository peronRepository;
    private final AutobusRepository autobusRepository;
    private final OdredisteRepository odredisteRepository;

    public AutobusnaLinijaService(AutobusnaLinijaRepository repository, PutnikRepository putnikRepository, PeronRepository peronRepository, AutobusRepository autobusRepository, OdredisteRepository odredisteRepository) {
        this.repository = repository;
        this.putnikRepository = putnikRepository;
        this.peronRepository = peronRepository;
        this.autobusRepository = autobusRepository;
        this.odredisteRepository = odredisteRepository;
    }

    public ResponseEntity<List<AutobusnaLinijaDTO>> getSveLinije() {
        List<AutobusnaLinija> sveLinije = repository.findAll();

        List<AutobusnaLinijaDTO> dtoList = sveLinije.stream()
                .map(AutobusnaLinijaMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    public ResponseEntity<AutobusnaLinijaDTO> getLinija(Integer id) {
        Optional<AutobusnaLinija> linija = repository.findById(id);

        if (linija.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AutobusnaLinijaDTO dto = AutobusnaLinijaMapper.toDto(linija.get());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<AutobusnaLinijaDTO> createLinija(NovaAutobusnaLinijaDTO dto) {
        AutobusnaLinija linija = new AutobusnaLinija();

        linija.setVrijemeDolaska(LocalTime.parse(dto.getVrijemeDolaska()));
        linija.setVrijemePolaska(LocalTime.parse(dto.getVrijemePolaska()));
        linija.setCijena(BigDecimal.valueOf(dto.getCijena()));

        Optional<Autobus> autobusOpt = autobusRepository.findById(dto.getAutobusId());
        Optional<Peron> peronOpt = peronRepository.findById(dto.getPeronId());
        Optional<Odrediste> odredisteOpt = odredisteRepository.findById(dto.getOdredisteId());

        if (autobusOpt.isEmpty() || peronOpt.isEmpty() || odredisteOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Autobus autobus = autobusOpt.get();
        Peron peron = peronOpt.get();

        if (autobus.getVisina() != null && peron.getVisina() != null) {
            if (autobus.getVisina().compareTo(peron.getVisina()) > 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        linija.setAutobus(autobus);
        linija.setPeron(peron);
        linija.setOdrediste(odredisteOpt.get());

        AutobusnaLinija saved = repository.save(linija);
        AutobusnaLinijaDTO responseDto = AutobusnaLinijaMapper.toDto(saved);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    public ResponseEntity<AutobusnaLinijaDTO> updateLinija(Integer id, AutobusnaLinijaDTO dto) {
        Optional<AutobusnaLinija> optionalLinija = repository.findById(id);

        if (optionalLinija.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AutobusnaLinija entity = optionalLinija.get();

        entity.setVrijemeDolaska(LocalTime.parse(dto.getVrijemeDolaska()));
        entity.setVrijemePolaska(LocalTime.parse(dto.getVrijemePolaska()));
        entity.setCijena(BigDecimal.valueOf(dto.getCijena()));

        Optional<Autobus> autobusOpt = autobusRepository.findById(dto.getAutobusId());
        Optional<Peron> peronOpt = peronRepository.findById(dto.getPeronId());
        Optional<Odrediste> odredisteOpt = odredisteRepository.findById(dto.getOdredisteId());

        if (autobusOpt.isEmpty() || peronOpt.isEmpty() || odredisteOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Autobus autobus = autobusOpt.get();
        Peron peron = peronOpt.get();
        Odrediste odrediste = odredisteOpt.get();

        if (autobus.getVisina() != null && peron.getVisina() != null) {
            if (autobus.getVisina().compareTo(peron.getVisina()) > 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        entity.setAutobus(autobus);
        entity.setPeron(peron);
        entity.setOdrediste(odrediste);

        AutobusnaLinija updated = repository.save(entity);
        AutobusnaLinijaDTO responseDto = AutobusnaLinijaMapper.toDto(updated);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteLinija(Integer id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<PutnikDTO> dodajPutnika(Integer id, PutnikDTO putnik) {
        Optional<AutobusnaLinija> linijaOptional = repository.findById(id);
        if (linijaOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AutobusnaLinija linija = linijaOptional.get();

        Optional<Putnik> putnikOptional = putnikRepository.findById(putnik.getPutnikId());
        if (putnikOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Putnik noviPutnik = putnikOptional.get();

        if (linija.getPutnici().contains(noviPutnik)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 Conflict
        }

        int brojPutnika = linija.getPutnici().size();
        int kapacitet = linija.getAutobus().getBrojSjedala();
        if (brojPutnika >= kapacitet) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        linija.getPutnici().add(noviPutnik);
        repository.save(linija);

        PutnikDTO responseDto = PutnikMapper.toDto(noviPutnik);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
