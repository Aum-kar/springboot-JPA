package learn.springJpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Data
@NoArgsConstructor
public class UserDetails {
    @Id private int uid;
    private String firstName;
    private String lastName;
    private String address;
}
