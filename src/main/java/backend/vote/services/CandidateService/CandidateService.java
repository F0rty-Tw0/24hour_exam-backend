package backend.vote.services.CandidateService;

import backend.vote.entities.Candidate;
import java.util.List;

public interface CandidateService {
  public List<Candidate> findAllCandidates();

  public List<Candidate> findCandidatesByNameContaining(String name);

  public List<Candidate> findCandidatesByPartyNameContaining(Long name);

  public Candidate findCandidateById(Long id);

  public Candidate findCandidateByPartyId(Long id);

  public void addCandidate(Candidate candidate);

  public void updateCandidateById(Long id, Candidate candidate);

  public void deleteCandidateById(Long id);
}
