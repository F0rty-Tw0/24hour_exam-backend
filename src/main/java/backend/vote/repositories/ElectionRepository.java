package backend.vote.repositories;

import backend.vote.entities.Election;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {
  public Optional<Election> findById(Long id);

  public List<Election> findByDate(LocalDate date);

  public Optional<Election> findByCandidateId(Long id);

  public List<Election> findByCandidateNameContaining(String name);
}
