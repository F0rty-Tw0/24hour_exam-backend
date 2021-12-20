package backend.vote.controller.CandidateController;

import backend.vote.entities.Candidate;
import backend.vote.services.CandidateService.CandidateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController implements CandidateControllerInterface {

  @Autowired
  private CandidateService candidateService;

  @Override
  public List<Candidate> findAllCandidates() {
    return candidateService.findAllCandidates();
  }

  @Override
  public List<Candidate> findCandidatesByNameContaining(String name) {
    return candidateService.findCandidatesByNameContaining(name);
  }

  @Override
  public List<Candidate> findCandidatesByPartyNameContaining(String name) {
    return candidateService.findCandidatesByPartyNameContaining(name);
  }

  @Override
  public Candidate findCandidateById(Long id) {
    return candidateService.findCandidateById(id);
  }

  @Override
  public Candidate findCandidateByPartyId(Long id) {
    return candidateService.findCandidateByPartyId(id);
  }

  @Override
  public void addCandidate(Candidate candidate) {
    candidateService.addCandidate(candidate);
  }

  @Override
  public void updateCandidateById(Long id, Candidate candidate) {
    candidateService.updateCandidateById(id, candidate);
  }

  @Override
  public void deleteCandidateById(Long id) {
    candidateService.deleteCandidateById(id);
  }
}
