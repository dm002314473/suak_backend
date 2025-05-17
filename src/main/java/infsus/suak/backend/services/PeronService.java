package infsus.suak.backend.services;

import infsus.suak.backend.models.Peron;
import infsus.suak.backend.repositories.PeronRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeronService {

    private final PeronRepository peronRepository;

    public PeronService(PeronRepository peronRepository) {
        this.peronRepository = peronRepository;
    }

    public ResponseEntity<List<Peron>> getSvePerone() {
        return new ResponseEntity<>(peronRepository.findAll(), HttpStatus.OK);
    }
}
