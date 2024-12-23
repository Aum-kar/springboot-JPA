package learn.springJpa;

import learn.springJpa.model.UserDetails;
import learn.springJpa.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);


//		READ DATA FROM DATABASE
		/*
		Notice that we have declared method findByFirstName in UserRepository but not defined.
		Since we have a property firstName, lastName, address in UserDetails entity, we can use
		findByFirstName(), findByLastName(), findByAddress() method respectively to get data.
		 */
		Optional<UserDetails> foundByName = repository.findByFirstName("Jane");
		System.out.println(foundByName.orElse(new UserDetails()));

		Optional<UserDetails> getAddress = repository.getAddressFindById(5);
		System.out.println(getAddress);
	}

}
