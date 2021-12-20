package backend.vote.services.DebateService;

import backend.vote.entities.Debate;
import backend.vote.repositories.DebateRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebateServiceImpl implements DebateService {

  @Autowired
  private DebateRepository debateRepository;

  String notFoundMessage = "Invalid debate id: ";

  @Override
  public List<Debate> findAllDebates() {
    return debateRepository.findAll();
  }

  @Override
  public List<Debate> findDebateByCandidateNameContaining(String name) {
    return debateRepository.findByCandidateNameContaining(name);
  }

  @Override
  public Debate findDebateByDate(LocalDate date) {
    return debateRepository
      .findByDate(date)
      .orElseThrow(() -> new IllegalArgumentException("Debate not found"));
  }

  @Override
  public Debate findDebateById(Long id) {
    return debateRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
  }

  @Override
  public Debate findDebateByCandidateId(Long id) {
    return debateRepository
      .findByCandidateId(id)
      .orElseThrow(
        () -> new IllegalArgumentException("Invalid candidate id: " + id)
      );
  }

  @Override
  public void incrementVoteCountByCandidateId(Long id) {
    Debate debate = debateRepository
      .findByCandidateId(id)
      .orElseThrow(
        () -> new IllegalArgumentException("Invalid candidate id: " + id)
      );
    debate.setVotes(debate.getVotes() + 1);
    debateRepository.save(debate);
  }

  @Override
  public void addDebate(Debate debate) {
    debateRepository.save(debate);
  }

  @Override
  public void updateDebateById(Long id, Debate debate) {
    Debate debateToUpdate = debateRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    debateToUpdate.setCandidate(debate.getCandidate());
    debateToUpdate.setDate(debate.getDate());
    debateRepository.save(debateToUpdate);
  }

  @Override
  public void deleteDebateById(Long id) {
    Debate debateToDelete = debateRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    debateRepository.delete(debateToDelete);
  }
}
