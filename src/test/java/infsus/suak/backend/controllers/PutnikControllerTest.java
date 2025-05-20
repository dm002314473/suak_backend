package infsus.suak.backend.controllers;

import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.services.PutnikService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PutnikControllerTest {

    @Mock
    private PutnikService putnikService;

    @InjectMocks
    private PutnikController putnikController;

    @Test
    void testGetSvePutnike() {
        PutnikDTO dto = new PutnikDTO();
        dto.setPutnikId(1);
        dto.setLoyaltyBodovi(100);

        when(putnikService.getSvePutnike()).thenReturn(new ResponseEntity<>(List.of(dto), HttpStatus.OK));

        ResponseEntity<List<PutnikDTO>> response = putnikController.getSvePutnike();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(100, response.getBody().get(0).getLoyaltyBodovi());
    }

    @Test
    void testGetPutnik_whenExists() {
        PutnikDTO dto = new PutnikDTO();
        dto.setPutnikId(1);
        dto.setLoyaltyBodovi(150);

        when(putnikService.getPutnik(1)).thenReturn(new ResponseEntity<>(dto, HttpStatus.OK));

        ResponseEntity<PutnikDTO> response = putnikController.getPutnik(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(150, response.getBody().getLoyaltyBodovi());
    }

    @Test
    void testGetPutnik_whenNotFound() {
        when(putnikService.getPutnik(999)).thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        ResponseEntity<PutnikDTO> response = putnikController.getPutnik(999);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
