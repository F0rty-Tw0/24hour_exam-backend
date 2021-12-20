package backend.vote.services.MunicipalityService;

import backend.vote.entities.Municipality;
import java.util.List;

public interface MunicipalityService {
  public List<Municipality> findAllMunicipalities();

  public List<Municipality> findMunicipalitiesByNameContaining(String name);

  public Municipality findMunicipalityById(Long id);

  public Municipality findMunicipalityByCode(Long code);

  public void addMunicipality(Municipality municipality);

  public void updateMunicipalityById(Long id, Municipality municipality);

  public void deleteMunicipalityById(Long id);
}
