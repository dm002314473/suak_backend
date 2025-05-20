package infsus.suak.backend.controllers;

import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.services.PutnikService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/putnici")
@CrossOrigin
public class PutnikController {

    private final PutnikService putnikService;

    public PutnikController(PutnikService putnikService) {
        this.putnikService = putnikService;
    }

    @GetMapping
    public ResponseEntity<List<PutnikDTO>> getSvePutnike() {
        return putnikService.getSvePutnike();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PutnikDTO> getPutnik(@PathVariable Integer id) {
        return putnikService.getPutnik(id);
    }
}
