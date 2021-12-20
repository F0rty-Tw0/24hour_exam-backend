package backend.vote.repositories;

import backend.vote.entities.Municipality;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository
  extends JpaRepository<Municipality, Long> {
  public Optional<Municipality> findById(Long id);

  public Optional<Municipality> findByCode(Long code);

  public List<Municipality> findByNameContaining(String name);
}
