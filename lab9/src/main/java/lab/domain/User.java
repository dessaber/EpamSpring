package lab.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class User {

  private int id;

  private String firstName;

  private String lastName;

}
