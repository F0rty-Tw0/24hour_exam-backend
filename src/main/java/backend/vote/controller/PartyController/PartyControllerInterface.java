package backend.vote.controller.PartyController;

import backend.vote.entities.Party;
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
  tags = "Parties",
  description = "- A secured endpoint for <b>Parties</b> requires a role of <b>ADMIN</b> to operate!"
)
@RequestMapping("/api/parties")
public interface PartyControllerInterface {
  @ApiOperation(
    value = " - Returns all of the Parties",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Parties</b>."
  )
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  @GetMapping
  public List<Party> findAllParties();

  @ApiOperation(
    value = " - Returns the Party by the id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Party to retrieve a <b>Party</b> Object."
  )
  @GetMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public Party findPartyById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Party by the name",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>name</b> of a Party to retrieve a list <b>Parties</b>."
  )
  @GetMapping("/name/{name}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Party> findPartyByNameContaining(@PathVariable String name);

  @ApiOperation(
    value = " - Returns the Party by the abbreviation",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>abbreviation</b> of a Party to retrieve a <b>Party</b> Object."
  )
  @GetMapping("/abr/{abr}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public Party findPartyByAbbreviation(@PathVariable String abbreviation);

  @ApiOperation(
    value = " - Adds the Party to the database",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Party Object</b> in the body in order to create a new <b>Party</b>."
  )
  @PostMapping
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  @ResponseStatus(HttpStatus.CREATED)
  public void addParty(
    @RequestBody Party party //FIXME: THIS SHOULD BE A DTO!
  );

  @ApiOperation(
    value = " - Updates the Party based on the id and details we enter",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Party and the Party Object in the body in order to update an existing <b>Party</b>."
  )
  @PutMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void updatePartyById(
    @PathVariable Long id,
    @RequestBody Party party //FIXME: THIS SHOULD BE A DTO!
  );

  @ApiOperation(
    value = " - Deletes the Party based on the id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Party to delete an existing <b>Party</b>."
  )
  @DeleteMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void deletePartyById(@PathVariable Long id);
}
