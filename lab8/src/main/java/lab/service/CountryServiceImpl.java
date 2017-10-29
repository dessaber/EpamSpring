package lab.service;

import java.util.List;
import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Repository is more convenient declaration for such a class than general @Service
@Repository
@Transactional
public class CountryServiceImpl implements CountryService {

  private final CountryDao countryDao;

  @Autowired
  public CountryServiceImpl(CountryDao countryDao) {
    this.countryDao = countryDao;
  }

  public List<Country> getAllCountriesInsideTransaction(Propagation propagation) {

    switch (propagation) {
      case REQUIRED:
        return getAllCountriesRequired();
      case SUPPORTS:
        return getAllCountriesSupports();
      case NEVER:
        return getAllCountriesNever();
      case MANDATORY:
        return getAllCountriesMandatory();
      case NOT_SUPPORTED:
        return getAllCountriesNotSupported();
      case REQUIRES_NEW:
        return getAllCountriesRequiresNew();
      default:
        return getAllCountries();
    }
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public List<Country> getAllCountriesRequired() {
    return countryDao.getCountryList();
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public List<Country> getAllCountriesRequiresNew() {
    return countryDao.getCountryList();
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public List<Country> getAllCountriesSupports() {
    return countryDao.getCountryList();
  }

  @Transactional(propagation = Propagation.NEVER)
  public List<Country> getAllCountriesNever() {
    return countryDao.getCountryList();
  }

  @Transactional(propagation = Propagation.MANDATORY)
  public List<Country> getAllCountriesMandatory() {
    return countryDao.getCountryList();
  }

  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  public List<Country> getAllCountriesNotSupported() {
    return countryDao.getCountryList();
  }

  @Transactional
  public List<Country> getAllCountries() {
    return countryDao.getCountryList();
  }

}