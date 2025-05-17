package infsus.suak.backend.repositories;

import infsus.suak.backend.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
}
