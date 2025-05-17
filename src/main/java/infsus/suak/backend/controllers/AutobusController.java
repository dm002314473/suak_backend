package infsus.suak.backend.controllers;

import infsus.suak.backend.models.Autobus;
import infsus.suak.backend.services.AutobusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/autobusi")
@CrossOrigin
public class AutobusController {

    private final AutobusService autobusService;

    public AutobusController(AutobusService autobusService) {
        this.autobusService = autobusService;
    }

    @GetMapping
    public ResponseEntity<List<Autobus>> getSveAutobuse() {
        return autobusService.getSveAutobuse();
    }
}
