package infsus.suak.backend.repositories;

import infsus.suak.backend.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
    Optional<Korisnik> findByEmail(String email);
}
