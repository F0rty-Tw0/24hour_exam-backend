package backend.vote.controller.PartyController;

import backend.vote.entities.Party;
import backend.vote.services.PartyService.PartyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyController implements PartyControllerInterface {

  @Autowired
  private PartyService partyService;

  @Override
  public List<Party> findAllParties() {
    return partyService.findAllParties();
  }

  @Override
  public Party findPartyById(Long id) {
    return partyService.findPartyById(id);
  }

  @Override
  public List<Party> findPartyByNameContaining(String name) {
    return partyService.findPartyByNameContaining(name);
  }

  @Override
  public Party findPartyByAbbreviation(String abbreviation) {
    return partyService.findPartyByAbbreviation(abbreviation);
  }

  @Override
  public void addParty(Party party) {
    partyService.addParty(party);
  }

  @Override
  public void updatePartyById(Long id, Party party) {
    partyService.updatePartyById(id, party);
  }

  @Override
  public void deletePartyById(Long id) {
    partyService.deletePartyById(id);
  }
}
