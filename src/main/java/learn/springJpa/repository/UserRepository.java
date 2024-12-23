package learn.springJpa.repository;

import learn.springJpa.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {
    Optional<UserDetails> findByFirstName(String userName);

    /*
    * Java Persistence Query Language (JPQL):
    * It is an object-oriented query language.
    * It deals with Entity and its fields
    * instead of database table and columns to get data from database.
     */
    @Query("SELECT u.address FROM UserDetails u WHERE u.uid=?1")
    Optional<UserDetails> getAddressFindById(int id);
}
