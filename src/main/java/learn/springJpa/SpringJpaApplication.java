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

//		ADD USER TO DATABASE
		UserDetails user1 = context.getBean(UserDetails.class);
		user1.setUid(2);
		user1.setFirstName("Aquatic");
		user1.setLastName("Animal");
		user1.setAddress("Ocean");
		repository.save(user1);


//		UPDATE USER IN DATABASE
		UserDetails user2 = context.getBean(UserDetails.class);
		user2.setUid(1);
		user2.setFirstName("Terrestrial");
		user2.setLastName("Organism");
		user2.setAddress("land");
		repository.save(user2);


//		DROP USERS FROM DATABASE
		repository.deleteAll();
		repository.delete(user1);


//		READ DATA FROM DATABASE
		List<UserDetails> allRecords = repository.findAll();
		Optional<UserDetails> oneRecord = repository.findById(1);

		System.out.println(allRecords);
		System.out.println(oneRecord.orElse(new UserDetails()));
	}

}
