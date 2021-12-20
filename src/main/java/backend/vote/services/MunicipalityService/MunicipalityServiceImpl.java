package backend.vote.services.MunicipalityService;

import backend.vote.entities.Municipality;
import backend.vote.repositories.MunicipalityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {

  @Autowired
  private MunicipalityRepository municipalityRepository;

  String notFoundMessage = "Invalid municipality id: ";

  @Override
  public List<Municipality> findAllMunicipalities() {
    return municipalityRepository.findAll();
  }

  @Override
  public List<Municipality> findMunicipalitiesByNameContaining(String name) {
    return municipalityRepository.findByNameContaining(name);
  }

  @Override
  public Municipality findMunicipalityById(Long id) {
    return municipalityRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
  }

  @Override
  public Municipality findMunicipalityByCode(Long code) {
    return municipalityRepository
      .findByCode(code)
      .orElseThrow(
        () -> new IllegalArgumentException("Invalid municipality code: " + code)
      );
  }

  @Override
  public void addMunicipality(Municipality municipality) {
    municipalityRepository.save(municipality);
  }

  @Override
  public void updateMunicipalityById(Long id, Municipality municipality) {
    Municipality municipalityToUpdate = municipalityRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    municipalityToUpdate.setName(municipality.getName());
    municipalityToUpdate.setCode(municipality.getCode());
    municipalityRepository.save(municipalityToUpdate);
  }

  @Override
  public void deleteMunicipalityById(Long id) {
    Municipality municipalityToDelete = municipalityRepository
      .findById(id)
      .orElseThrow(() -> new IllegalArgumentException(notFoundMessage + id));
    municipalityRepository.delete(municipalityToDelete);
  }
}
