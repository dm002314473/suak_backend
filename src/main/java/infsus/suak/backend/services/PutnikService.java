package infsus.suak.backend.services;

import infsus.suak.backend.dtos.AutobusnaLinijaDTO;
import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.mappers.AutobusnaLinijaMapper;
import infsus.suak.backend.mappers.PutnikMapper;
import infsus.suak.backend.models.Putnik;
import infsus.suak.backend.repositories.PutnikRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PutnikService {

    private final PutnikRepository putnikRepository;

    public PutnikService(PutnikRepository putnikRepository) {
        this.putnikRepository = putnikRepository;
    }

    public ResponseEntity<List<PutnikDTO>> getSvePutnike() {
        List<Putnik> sviPutnici = putnikRepository.findAll();
        List<PutnikDTO> dtoList = sviPutnici.stream()
                .map(PutnikMapper::toDto)
                .toList();

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
