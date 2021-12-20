package backend.vote.services.ElectionService;


import backend.vote.entities.Election;
import java.time.LocalDate;
import java.util.List;

public interface ElectionService {
  public List<Election> findAllElections();

  public List<Election> findElectionByCandidateNameContaining(String name);

  public Election findElectionByDate(LocalDate date);

  public Election findElectionById(Long id);

  public Election findElectionByCandidateId(Long id);

  public void incrementVoteCountByCandidateId(Long id);

  public void addElection(Election election);

  public void updateElectionById(Long id, Election election);

  public void deleteElectionById(Long id);
}
