package infsus.suak.backend.controllers;

import infsus.suak.backend.models.Peron;
import infsus.suak.backend.services.PeronService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/peroni")
@CrossOrigin
public class PeronController {

    private final PeronService peronService;

    public PeronController(PeronService peronService) {
        this.peronService = peronService;
    }

    @GetMapping
    public ResponseEntity<List<Peron>> getSvePerone() {
        return peronService.getSvePerone();
    }
}
