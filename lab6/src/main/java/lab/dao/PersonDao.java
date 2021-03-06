package lab.dao;

import lab.model.Person;

import java.util.stream.Stream;

public interface PersonDao {
	void insert(Person user);

	int insert(String firstName,
			   String lastName,
			   int countryId,
			   int age,
			   double height,
			   boolean programmer,
			   boolean broke);

	Person select(int id);
	
	Stream<Person> selectAll();
	
}
