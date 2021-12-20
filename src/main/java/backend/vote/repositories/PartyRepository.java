package backend.vote.repositories;

import backend.vote.entities.Party;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
  public Optional<Party> findById(Long id);

  public List<Party> findByNameContaining(String name);
}
