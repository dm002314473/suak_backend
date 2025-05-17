package infsus.suak.backend.services;

import infsus.suak.backend.models.Odrediste;
import infsus.suak.backend.repositories.OdredisteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdredisteService {

    private final OdredisteRepository odredisteRepository;

    public OdredisteService(OdredisteRepository odredisteRepository) {
        this.odredisteRepository = odredisteRepository;
    }

    public ResponseEntity<List<Odrediste>> getSvaOdredista() {
        return new ResponseEntity<>(odredisteRepository.findAll(), HttpStatus.OK);
    }
}
