package backend.vote.controller.MunicipalityController;

import backend.vote.entities.Municipality;
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
  tags = "Municipalities",
  description = "- A secured endpoint for <b>Municipalities</b> requires a role of <b>ADMIN</b> to operate!"
)
@RequestMapping("/api/municipalities")
public interface MunicipalityControllerInterface {
  @ApiOperation(
    value = " - Returns all the Municipalities",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Municipalities</b>."
  )
  @GetMapping
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Municipality> findAllMunicipalities();

  @ApiOperation(
    value = " - Returns the Municipalities by the Name",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>name</b> of a Municipality to retrieve a list <b>Municipalities</b>."
  )
  @GetMapping("/name/{name}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public List<Municipality> findMunicipalitiesByNameContaining(
    @PathVariable String name
  );

  @ApiOperation(
    value = " - Returns the Municipality by the Id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Municipality to retrieve a <b>Municipality</b> Object."
  )
  @GetMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public Municipality findMunicipalityById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Municipality by the code",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>code</b> of a Municipality to retrieve a <b>Municipality</b> Object."
  )
  @GetMapping("/code/{code}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public Municipality findMunicipalityByCode(@PathVariable Long code);

  @ApiOperation(
    value = " - Adds the User to the database",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>User Object</b> in the body in order to create a new <b>User</b>."
  )
  @PostMapping
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  @ResponseStatus(HttpStatus.CREATED)
  public void addMunicipality(
    @RequestBody Municipality municipality //FIXME: THIS SHOULD BE A DTO!
  );

  @ApiOperation(
    value = " - Updates the Municipality based on the id and details we enter",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Municipality and the Municipality Object in the body in order to update an existing <b>Municipality</b>."
  )
  @PutMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void updateMunicipalityById(
    @PathVariable Long id,
    @RequestBody Municipality municipality //FIXME: THIS SHOULD BE A DTO!
  );

  @ApiOperation(
    value = " - Deletes the Municipality based on the id",
    // authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Municipality in order to delete the existing <b>Municipality</b>."
  )
  @DeleteMapping("/{id}")
  // @PreAuthorize(
  //   "hasRole('ADMIN') or hasRole('CANDIDATE')"
  // )
  public void deleteMunicipalityById(@PathVariable Long id);
}
