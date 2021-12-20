package backend.vote.controller.CandidateController;

import backend.vote.entities.Candidate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(
  tags = "Candidates",
  description = "- A secured endpoint for <b>Candidates</b> requires a role of <b>ADMIN</b> to operate!"
)
@RequestMapping("/api/candidates")
public interface CandidateControllerInterface {
  @ApiOperation(
    value = " - Returns all the Candidates",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Candidates</b>."
  )
  @GetMapping
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Candidate> findAllCandidates();

  @ApiOperation(
    value = " - Returns the Candidates by the Name",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>name</b> of a Candidate to retrieve a list <b>Candidates</b>."
  )
  @GetMapping("/name/{name}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Candidate> findCandidatesByNameContaining(
    @PathVariable String name
  );

  @ApiOperation(
    value = " - Returns the Candidate by the Party name",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>name</b> of a Party to retrieve a list of <b>Candidates</b>."
  )
  @GetMapping("/party/{name}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Candidate> findCandidatesByPartyNameContaining(
    @PathVariable String name
  );

  @ApiOperation(
    value = " - Returns the Candidate by the id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Candidate to retrieve a <b>Candidate</b> Object."
  )
  @GetMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public Candidate findCandidateById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Candidate by the Party id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Party to retrieve a <b>Candidate</b> Object."
  )
  @GetMapping("/party/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public Candidate findCandidateByPartyId(@PathVariable Long id);

  @ApiOperation(
    value = " - Adds a Candidate to the database",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Candidate Object</b> in the body in order to create a new <b>Candidate</b>."
  )
  @PostMapping
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  @ResponseStatus(HttpStatus.CREATED)
  public void addCandidate(
    @RequestBody Candidate candidate //FIXME: THIS SHOULD BE A DTO!
  );

  @ApiOperation(
    value = " - Updates a Candidate based on the id and details we enter",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Candidate and the Candidate Object in the body in order to update an existing <b>Candidate</b>."
  )
  @PutMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void updateCandidateById(
    @PathVariable Long id,
    @RequestBody Candidate candidate //FIXME: THIS SHOULD BE A DTO!
  );

  @ApiOperation(
    value = " - Deletes a Candidate based on the id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Candidate to delete an existing <b>Candidate</b>."
  )
  @DeleteMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void deleteCandidateById(Long id);
}
