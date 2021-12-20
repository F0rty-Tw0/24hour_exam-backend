package backend.vote.services.PartyService;

import backend.vote.entities.Party;
import backend.vote.repositories.PartyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService {

  @Autowired
  private PartyRepository partyRepository;

  String notFoundMessage = "Invalid party id: ";

  @Override
  public List<Party> findAllParties() {
    return partyRepository.findAll();
  }

  @Override
  public List<Party> findPartyByNameContaining(String name) {
    return partyRepository.findByNameContaining(name);
  }

  @Override
  public Party findPartyById(Long id) {
    return partyRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
  }

  @Override
  public void addParty(Party party) {
    partyRepository.save(party);
  }

  @Override
  public void updatePartyById(Long id, Party party) {
    Party partyToUpdate = partyRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    partyToUpdate.setName(party.getName());
    partyToUpdate.setSlogan(party.getSlogan());
    partyToUpdate.setAbbreviation(party.getAbbreviation());
    partyRepository.save(partyToUpdate);
  }

  @Override
  public void deletePartyById(Long id) {
    Party partyToDelete = partyRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    partyRepository.delete(partyToDelete);
  }
}
