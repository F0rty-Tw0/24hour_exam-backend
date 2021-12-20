package backend.vote.repositories;

import backend.vote.entities.Debate;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebateRepository extends JpaRepository<Debate, Long> {
  public Optional<Debate> findById(Long id);

  public Optional<Debate> findByDate(LocalDate date);

  public Optional<Debate> findByCandidateId(Long id);

  public List<Debate> findByCandidateNameContaining(String name);
}
