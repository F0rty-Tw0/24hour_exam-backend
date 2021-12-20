package backend.vote.controller.MunicipalityController;

import backend.vote.entities.Municipality;
import backend.vote.services.MunicipalityService.MunicipalityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MunicipalityController implements MunicipalityControllerInterface {

  @Autowired
  private MunicipalityService municipalityService;

  @Override
  public List<Municipality> findAllMunicipalities() {
    return municipalityService.findAllMunicipalities();
  }

  @Override
  public List<Municipality> findMunicipalitiesByNameContaining(String name) {
    return municipalityService.findMunicipalitiesByNameContaining(name);
  }

  @Override
  public Municipality findMunicipalityById(Long id) {
    return municipalityService.findMunicipalityById(id);
  }

  @Override
  public Municipality findMunicipalityByCode(Long code) {
    return municipalityService.findMunicipalityByCode(code);
  }

  @Override
  public void addMunicipality(Municipality municipality) {
    municipalityService.addMunicipality(municipality);
  }

  @Override
  public void updateMunicipalityById(Long id, Municipality municipality) {
    municipalityService.updateMunicipalityById(id, municipality);
  }

  @Override
  public void deleteMunicipalityById(Long id) {
    municipalityService.deleteMunicipalityById(id);
  }
}
