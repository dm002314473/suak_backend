package infsus.suak.backend.services;

import infsus.suak.backend.dtos.AutobusnaLinijaDTO;
import infsus.suak.backend.mappers.AutobusnaLinijaMapper;
import infsus.suak.backend.models.AutobusnaLinija;
import infsus.suak.backend.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AutobusnaLinijaServiceTest {

    private AutobusnaLinijaRepository repository;
    private PutnikRepository putnikRepository;
    private PeronRepository peronRepository;
    private AutobusRepository autobusRepository;
    private OdredisteRepository odredisteRepository;

    private AutobusnaLinijaService service;

    @BeforeEach
    public void setUp() {
        repository = mock(AutobusnaLinijaRepository.class);
        putnikRepository = mock(PutnikRepository.class);
        peronRepository = mock(PeronRepository.class);
        autobusRepository = mock(AutobusRepository.class);
        odredisteRepository = mock(OdredisteRepository.class);

        service = new AutobusnaLinijaService(repository, putnikRepository, peronRepository, autobusRepository, odredisteRepository);
    }

    @Test
    public void testGetLinijaFound() {
        AutobusnaLinija linija = new AutobusnaLinija();
        linija.setAutobusnaLinijaId(1);
        linija.setCijena(new java.math.BigDecimal("100.00"));

        when(repository.findById(1)).thenReturn(Optional.of(linija));

        ResponseEntity<AutobusnaLinijaDTO> response = service.getLinija(1);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getAutobusnaLinijaId());
    }

    @Test
    public void testGetLinijaNotFound() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<AutobusnaLinijaDTO> response = service.getLinija(1);

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
