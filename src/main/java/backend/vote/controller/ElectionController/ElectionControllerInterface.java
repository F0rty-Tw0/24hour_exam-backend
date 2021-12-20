package backend.vote.controller.ElectionController;

import backend.vote.entities.Election;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(
  tags = "Elections",
  description = "- A secured endpoint for <b>Elections</b> requires a role of <b>ADMIN</b> to operate!"
)
@RequestMapping("/api/elections")
public interface ElectionControllerInterface {
  @ApiOperation(
    value = " - Returns all the Elections",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Elections</b>."
  )
  @GetMapping
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Election> findAllElections();

  @ApiOperation(
    value = " - Returns the Elections by the Candidate Name",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>name</b> of a Candidate to retrieve a list <b>Elections</b>."
  )
  @GetMapping("/candidate/{name}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Election> findElectionByCandidateNameContaining(
    @PathVariable String name
  );

  @ApiOperation(
    value = " - Returns the Elections by the date",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>date</b> of an Elections to retrieve an <b>Election</b> Object."
  )
  @GetMapping("/date/{date}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Election> findElectionByDate(
    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
  );

  @ApiOperation(
    value = " - Returns the Elections by the id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Elections to retrieve an <b>Election</b> Object."
  )
  @GetMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public Election findElectionById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Elections by the Candidate id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Candidate to retrieve an <b>Election</b> Object."
  )
  @GetMapping("/candidate/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public Election findElectionByCandidateId(@PathVariable Long id);

  @ApiOperation(
    value = " - Increments the Vote Count by the Candidate id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Candidate to increment the <b>Vote Count</b>."
  )
  @GetMapping("/increment/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void incrementVoteCountOfCandidateId(@PathVariable Long id);

  @ApiOperation(
    value = " - Adds an Election to the database",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Election Object</b> in the body in order to create a new <b>Election</b>."
  )
  @PostMapping
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  @ResponseStatus(HttpStatus.CREATED)
  public void addElection(
    Election election //FIXME: THIS SHOULD BE A DTO!
  );

  @ApiOperation(
    value = " - Updates an Election by the id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Elections to update an <b>Election</b> Object."
  )
  @PutMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void updateElectionById(
    @PathVariable Long id,
    Election election //FIXME: THIS SHOULD BE A DTO!
  );

  @ApiOperation(
    value = " - Deletes an Election by the id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Elections to delete an <b>Election</b> Object."
  )
  @DeleteMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void deleteElectionById(@PathVariable Long id);
}
