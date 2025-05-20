package infsus.suak.backend.services;

import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.models.Putnik;
import infsus.suak.backend.repositories.KorisnikRepository;
import infsus.suak.backend.repositories.PutnikRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)  // ✅ SAMO ovo je potrebno
class PutnikServiceTest {

    @Mock
    private PutnikRepository putnikRepository;

    @Mock
    private KorisnikRepository korisnikRepository;

    @InjectMocks
    private PutnikService putnikService;

    @Test
    void testGetSvePutnike() {
        Putnik putnik = new Putnik();
        putnik.setPutnikId(1);
        putnik.setLoyaltyBodovi(100);

        when(putnikRepository.findAll()).thenReturn(List.of(putnik));

        ResponseEntity<List<PutnikDTO>> response = putnikService.getSvePutnike();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(100, response.getBody().get(0).getLoyaltyBodovi());
    }

    @Test
    void testGetPutnik_whenExists() {
        Putnik putnik = new Putnik();
        putnik.setPutnikId(1);
        putnik.setLoyaltyBodovi(150);

        when(putnikRepository.findById(1)).thenReturn(Optional.of(putnik));

        ResponseEntity<PutnikDTO> response = putnikService.getPutnik(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(150, response.getBody().getLoyaltyBodovi());
    }

    @Test
    void testGetPutnik_whenNotFound() {
        when(putnikRepository.findById(999)).thenReturn(Optional.empty());

        ResponseEntity<PutnikDTO> response = putnikService.getPutnik(999);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
