package infsus.suak.backend.repositories;

import infsus.suak.backend.models.Putnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PutnikRepository extends JpaRepository<Putnik, Integer> {
}
