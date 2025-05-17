package infsus.suak.backend.services;

import infsus.suak.backend.models.Autobus;
import infsus.suak.backend.repositories.AutobusRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutobusService {

    private final AutobusRepository autobusRepository;

    public AutobusService(AutobusRepository autobusRepository) {
        this.autobusRepository = autobusRepository;
    }

    public ResponseEntity<List<Autobus>> getSveAutobuse() {
        return new ResponseEntity<>(autobusRepository.findAll(), HttpStatus.OK);
    }
}
