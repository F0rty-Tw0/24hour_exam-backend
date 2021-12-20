package backend.vote.repositories;

import backend.vote.entities.Candidate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
  public Optional<Candidate> findById(Long id);

  public List<Candidate> findByPartyId(Long id);

  public List<Candidate> findByNameContaining(String name);

  public List<Candidate> findByPartyNameContaining(String name);
}
