package backend.vote.configurations;

import backend.vote.entities.Candidate;
import backend.vote.entities.Election;
import backend.vote.entities.Municipality;
import backend.vote.entities.Party;
import backend.vote.services.CandidateService.CandidateService;
import backend.vote.services.ElectionService.ElectionService;
import backend.vote.services.MunicipalityService.MunicipalityService;
import backend.vote.services.PartyService.PartyService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DatabaseConfig implements CommandLineRunner {

  @Autowired
  private CandidateService candidateService;

  @Autowired
  private MunicipalityService municipalityService;

  @Autowired
  private ElectionService electionService;

  @Autowired
  private PartyService partyService;

  private void createDanishMunicipalities() {
    if (municipalityService.findAllMunicipalities().isEmpty()) {
      municipalityService.addMunicipality(new Municipality(101, "København"));
      municipalityService.addMunicipality(
        new Municipality(147, "Frederiksberg")
      );
      municipalityService.addMunicipality(new Municipality(151, "Ballerup"));
      municipalityService.addMunicipality(new Municipality(153, "Brøndby"));
      municipalityService.addMunicipality(new Municipality(219, "Helsingør"));
    }
  }

  private void createParties() {
    if (partyService.findAllParties().isEmpty()) {
      partyService.addParty(
        new Party("Socialdemokratiet", "A", "Stauning eller Kaos")
      );
      partyService.addParty(
        new Party("Radikale Venstre", "B", "Vi lytter før vi beslutter")
      );
      partyService.addParty(
        new Party("Det Konservative Folkeparti", "C", "For dig og for Danmark")
      );
    }
  }

  private void createCandidates() {
    if (candidateService.findAllCandidates().isEmpty()) {
      candidateService.addCandidate(
        new Candidate(
          "Sophie Hæstorp Andersen",
          partyService.findPartyByAbbreviation("A")
        )
      );
      candidateService.addCandidate(
        new Candidate("Lars Weiss", partyService.findPartyByAbbreviation("A"))
      );
      candidateService.addCandidate(
        new Candidate(
          "Laura Rosenvinge",
          partyService.findPartyByAbbreviation("A")
        )
      );
      candidateService.addCandidate(
        new Candidate("Mia Nyegaard", partyService.findPartyByAbbreviation("B"))
      );
      candidateService.addCandidate(
        new Candidate(
          "Christopher Røhl",
          partyService.findPartyByAbbreviation("B")
        )
      );
      candidateService.addCandidate(
        new Candidate(
          "Mette Annelie Rasmussen",
          partyService.findPartyByAbbreviation("B")
        )
      );
      candidateService.addCandidate(
        new Candidate(
          "Jakob Næsager",
          partyService.findPartyByAbbreviation("C")
        )
      );
      candidateService.addCandidate(
        new Candidate(
          "Helle Bonnesen",
          partyService.findPartyByAbbreviation("C")
        )
      );
      candidateService.addCandidate(
        new Candidate(
          "Line Ervolder",
          partyService.findPartyByAbbreviation("C")
        )
      );
    }
  }

  private void createElections() {
    if (electionService.findAllElections().isEmpty()) {
      List<Candidate> candidates = candidateService.findAllCandidates();
      for (Candidate candidate : candidates) {
        electionService.addElection(
          new Election(candidate, LocalDate.of(2021, 1, 1))
        );
      }
    }
  }


  //TODO: ADD MUNICIPALITY TO PARTY
  @Override
  public void run(String... args) throws Exception {
    createDanishMunicipalities();
    createParties();
    createCandidates();
    createElections();
  }
}
