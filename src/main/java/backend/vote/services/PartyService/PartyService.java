package backend.vote.services.PartyService;

import backend.vote.entities.Party;
import java.util.List;

public interface PartyService {
  public List<Party> findAllParties();

  public List<Party> findPartyByNameContaining(String name);

  public Party findPartyById(Long id);

  public void addParty(Party party);

  public void updatePartyById(Long id, Party party);

  public void deletePartyById(Long id);
}
