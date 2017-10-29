package lab.dao;

import java.util.List;
import lab.domain.Country;

public interface CountryDao {

  public void insert(Country country);

  public Country select(int id);

  public List<Country> selectAll();

}
