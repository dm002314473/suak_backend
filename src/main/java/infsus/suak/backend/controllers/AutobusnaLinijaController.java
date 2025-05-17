package infsus.suak.backend.controllers;

import infsus.suak.backend.dtos.AutobusnaLinijaDTO;
import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.services.AutobusnaLinijaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/linije")
@CrossOrigin
public class AutobusnaLinijaController {

    private final AutobusnaLinijaService autobusnaLinijaService;

    public AutobusnaLinijaController(AutobusnaLinijaService autobusnaLinijaService) {
        this.autobusnaLinijaService = autobusnaLinijaService;
    }

    @GetMapping
    public ResponseEntity<List<AutobusnaLinijaDTO>> getSveLinije() {
        return autobusnaLinijaService.getSveLinije();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutobusnaLinijaDTO> getLinija(@PathVariable Integer id) {
        return autobusnaLinijaService.getLinija(id);
    }

    @PostMapping
    public ResponseEntity<AutobusnaLinijaDTO> createLinija(@RequestBody AutobusnaLinijaDTO dto) {
        return autobusnaLinijaService.createLinija(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutobusnaLinijaDTO> update(@PathVariable Integer id, @RequestBody AutobusnaLinijaDTO dto) {
        return autobusnaLinijaService.updateLinija(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return autobusnaLinijaService.deleteLinija(id);
    }

    @PostMapping("/{id}/putnici")
    public ResponseEntity<PutnikDTO> dodajPutnika(@PathVariable Integer id, @RequestBody PutnikDTO putnik) {
        return autobusnaLinijaService.dodajPutnika(id, putnik);
    }
}
