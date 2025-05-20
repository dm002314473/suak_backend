package infsus.suak.backend.controllers;

import infsus.suak.backend.dtos.AutobusnaLinijaDTO;
import infsus.suak.backend.dtos.NovaAutobusnaLinijaDTO;
import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.services.AutobusnaLinijaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutobusnaLinijaControllerTest {

    @Mock
    private AutobusnaLinijaService autobusnaLinijaService;

    @InjectMocks
    private AutobusnaLinijaController autobusnaLinijaController;

    @Test
    void testGetSveLinije() {
        AutobusnaLinijaDTO dto = new AutobusnaLinijaDTO();
        dto.setAutobusnaLinijaId(1L);
        dto.setCijena(12.5);
        dto.setVrijemeDolaska("10:30");
        dto.setVrijemePolaska("9, 30");

        when(autobusnaLinijaService.getSveLinije())
                .thenReturn(new ResponseEntity<>(List.of(dto), HttpStatus.OK));

        ResponseEntity<List<AutobusnaLinijaDTO>> response = autobusnaLinijaController.getSveLinije();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(12.5, response.getBody().get(0).getCijena());
    }

    @Test
    void testGetLinija_whenExists() {
        AutobusnaLinijaDTO dto = new AutobusnaLinijaDTO();
        dto.setAutobusnaLinijaId(1L);
        dto.setCijena(15.0);
        dto.setVrijemeDolaska("11:00");
        dto.setVrijemePolaska("10:00");

        when(autobusnaLinijaService.getLinija(1))
                .thenReturn(new ResponseEntity<>(dto, HttpStatus.OK));

        ResponseEntity<AutobusnaLinijaDTO> response = autobusnaLinijaController.getLinija(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(15.0, response.getBody().getCijena());
    }

    @Test
    void testGetLinija_whenNotFound() {
        when(autobusnaLinijaService.getLinija(999))
                .thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        ResponseEntity<AutobusnaLinijaDTO> response = autobusnaLinijaController.getLinija(999);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateLinija() {
        NovaAutobusnaLinijaDTO novaDto = new NovaAutobusnaLinijaDTO();
        // postavi polja dto-a kako treba...

        AutobusnaLinijaDTO createdDto = new AutobusnaLinijaDTO();
        createdDto.setAutobusnaLinijaId(1L);
        createdDto.setCijena(20.0);

        when(autobusnaLinijaService.createLinija(novaDto))
                .thenReturn(new ResponseEntity<>(createdDto, HttpStatus.CREATED));

        ResponseEntity<AutobusnaLinijaDTO> response = autobusnaLinijaController.createLinija(novaDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1, response.getBody().getAutobusnaLinijaId());
        assertEquals(20.0, response.getBody().getCijena());
    }

    @Test
    void testUpdateLinija() {
        AutobusnaLinijaDTO updateDto = new AutobusnaLinijaDTO();
        updateDto.setAutobusnaLinijaId(1L);
        updateDto.setCijena(18.0);

        when(autobusnaLinijaService.updateLinija(1, updateDto))
                .thenReturn(new ResponseEntity<>(updateDto, HttpStatus.OK));

        ResponseEntity<AutobusnaLinijaDTO> response = autobusnaLinijaController.update(1, updateDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(18.0, response.getBody().getCijena());
    }

    @Test
    void testDeleteLinija() {
        when(autobusnaLinijaService.deleteLinija(1))
                .thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        ResponseEntity<Void> response = autobusnaLinijaController.delete(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDodajPutnika() {
        PutnikDTO putnikDTO = new PutnikDTO();
        putnikDTO.setPutnikId(1);
        putnikDTO.setLoyaltyBodovi(200);

        when(autobusnaLinijaService.dodajPutnika(1, putnikDTO))
                .thenReturn(new ResponseEntity<>(putnikDTO, HttpStatus.OK));

        ResponseEntity<PutnikDTO> response = autobusnaLinijaController.dodajPutnika(1, putnikDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getBody().getLoyaltyBodovi());
    }
}
