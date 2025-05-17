package infsus.suak.backend.controllers;

import infsus.suak.backend.models.Odrediste;
import infsus.suak.backend.services.OdredisteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/odredista")
@CrossOrigin
public class OdredisteController {

    private final OdredisteService odredisteService;

    public OdredisteController(OdredisteService odredisteService) {
        this.odredisteService = odredisteService;
    }

    @GetMapping
    public ResponseEntity<List<Odrediste>> getSvaOdredista() {
        return odredisteService.getSvaOdredista();
    }
}
