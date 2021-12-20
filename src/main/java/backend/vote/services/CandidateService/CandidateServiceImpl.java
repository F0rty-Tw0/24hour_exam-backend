package backend.vote.services.CandidateService;

import backend.vote.entities.Candidate;
import backend.vote.repositories.CandidateRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

  @Autowired
  private CandidateRepository candidateRepository;

  String notFoundMessage = "Invalid candidate id: ";

  @Override
  public List<Candidate> findAllCandidates() {
    return candidateRepository.findAll();
  }

  @Override
  public List<Candidate> findCandidatesByNameContaining(String name) {
    return candidateRepository.findByNameContaining(name);
  }

  @Override
  public List<Candidate> findCandidatesByPartyNameContaining(String name) {
    return candidateRepository.findByPartyNameContaining(name);
  }

  @Override
  public Candidate findCandidateById(Long id) {
    return candidateRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
  }

  @Override
  public List<Candidate> findCandidatesByPartyId(Long id) {
    return candidateRepository.findByPartyId(id);
  }

  @Override
  public void addCandidate(Candidate candidate) {
    candidateRepository.save(candidate);
  }

  @Override
  public void updateCandidateById(Long id, Candidate candidate) {
    Candidate candidateToUpdate = candidateRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    candidateToUpdate.setName(candidate.getName());
    candidateToUpdate.setParty(candidate.getParty());
    candidateRepository.save(candidateToUpdate);
  }

  @Override
  public void deleteCandidateById(Long id) {
    Candidate candidateToDelete = candidateRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    candidateRepository.delete(candidateToDelete);
  }
}
