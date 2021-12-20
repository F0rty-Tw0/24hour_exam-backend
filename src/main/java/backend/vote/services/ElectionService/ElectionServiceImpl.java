package backend.vote.services.ElectionService;

import backend.vote.entities.Election;
import backend.vote.repositories.ElectionRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionServiceImpl implements ElectionService {

  @Autowired
  private ElectionRepository electionRepository;

  String notFoundMessage = "Invalid election id: ";

  @Override
  public List<Election> findAllElections() {
    return electionRepository.findAll();
  }

  @Override
  public List<Election> findElectionByCandidateNameContaining(String name) {
    return electionRepository.findByCandidateNameContaining(name);
  }

  @Override
  public Election findElectionByDate(LocalDate date) {
    return electionRepository
      .findByDate(date)
      .orElseThrow(() -> new IllegalArgumentException("election not found"));
  }

  @Override
  public Election findElectionById(Long id) {
    return electionRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
  }

  @Override
  public Election findElectionByCandidateId(Long id) {
    return electionRepository
      .findByCandidateId(id)
      .orElseThrow(
        () -> new IllegalArgumentException("Invalid candidate id: " + id)
      );
  }

  @Override
  public void incrementVoteCountByCandidateId(Long id) {
    Election election = electionRepository
      .findByCandidateId(id)
      .orElseThrow(
        () -> new IllegalArgumentException("Invalid candidate id: " + id)
      );
    election.setVotes(election.getVotes() + 1);
    electionRepository.save(election);
  }

  @Override
  public void addElection(Election election) {
    electionRepository.save(election);
  }

  @Override
  public void updateElectionById(Long id, Election election) {
    Election electionToUpdate = electionRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    electionToUpdate.setCandidate(election.getCandidate());
    electionToUpdate.setDate(election.getDate());
    electionRepository.save(electionToUpdate);
  }

  @Override
  public void deleteElectionById(Long id) {
    Election electionToDelete = electionRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    electionRepository.delete(electionToDelete);
  }
}
