package backend.vote.controller.ElectionController;

import backend.vote.entities.Election;
import backend.vote.services.ElectionService.ElectionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElectionController implements ElectionControllerInterface {

  @Autowired
  private ElectionService electionService;

  @Override
  public List<Election> findAllElections() {
    return electionService.findAllElections();
  }

  @Override
  public List<Election> findElectionByCandidateNameContaining(String name) {
    return electionService.findElectionByCandidateNameContaining(name);
  }

  @Override
  public Election findElectionByDate(LocalDate date) {
    return electionService.findElectionByDate(date);
  }

  @Override
  public Election findElectionById(Long id) {
    return electionService.findElectionById(id);
  }

  @Override
  public Election findElectionByCandidateId(Long id) {
    return electionService.findElectionByCandidateId(id);
  }

  @Override
  public void incrementVoteCountOfCandidateId(Long id) {
    electionService.incrementVoteCountOfCandidateId(id);
  }

  @Override
  public void addElection(Election election) {
    electionService.addElection(election);
  }

  @Override
  public void updateElectionById(Long id, Election election) {
    electionService.updateElectionById(id, election);
  }

  @Override
  public void deleteElectionById(Long id) {
    electionService.deleteElectionById(id);
  }
}
