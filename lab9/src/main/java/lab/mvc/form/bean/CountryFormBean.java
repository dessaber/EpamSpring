package lab.mvc.form.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CountryFormBean {

  public CountryFormBean() {
  }

  @NotNull(message = "{NotNull.countryFormBean.name}")
  @Size(min = 2, max = 20)
  private String name;

  @NotNull
  @Size(min = 2, max = 3)
  private String codeName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCodeName() {
    return codeName;
  }

  public void setCodeName(String codeName) {
    this.codeName = codeName;
  }

  @Override
  public String toString() {
    return "Country [name=" + name + ", codeName=" + codeName + "]";
  }
}
