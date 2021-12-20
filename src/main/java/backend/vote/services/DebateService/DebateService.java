package backend.vote.services.DebateService;

import backend.vote.entities.Debate;
import java.time.LocalDate;
import java.util.List;

public interface DebateService {
  public List<Debate> findAllDebates();

  public List<Debate> findDebateByCandidateNameContaining(String name);

  public Debate findDebateByDate(LocalDate date);

  public Debate findDebateById(Long id);

  public Debate findDebateByCandidateId(Long id);

  public void incrementVoteCountByCandidateId(Long id);

  public void addDebate(Debate debate);

  public void updateDebateById(Long id, Debate debate);

  public void deleteDebateById(Long id);
}
