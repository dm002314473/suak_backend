package infsus.suak.backend.services;

import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.mappers.PutnikMapper;
import infsus.suak.backend.models.Putnik;
import infsus.suak.backend.repositories.KorisnikRepository;
import infsus.suak.backend.repositories.PutnikRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PutnikService {

    private final PutnikRepository putnikRepository;
    private final KorisnikRepository korisnikRepository;

    public PutnikService(PutnikRepository putnikRepository, KorisnikRepository korisnikRepository) {
        this.putnikRepository = putnikRepository;
        this.korisnikRepository = korisnikRepository;
    }

    public ResponseEntity<List<PutnikDTO>> getSvePutnike() {
        List<Putnik> sviPutnici = putnikRepository.findAll();
        List<PutnikDTO> dtoList = sviPutnici.stream()
                .map(PutnikMapper::toDto)
                .toList();

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    public ResponseEntity<PutnikDTO> getPutnik(Integer id) {
        Optional<Putnik> putnikOptional = putnikRepository.findById(id);
        if (putnikOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Putnik putnik = putnikOptional.get();
        PutnikDTO dto = PutnikMapper.toDto(putnik);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
