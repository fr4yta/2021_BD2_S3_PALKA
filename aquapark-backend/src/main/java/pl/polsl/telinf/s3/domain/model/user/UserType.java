package pl.polsl.telinf.s3.domain.model.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_types")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserType implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userType;
    @OneToMany (targetEntity = User.class, cascade = CascadeType.ALL, mappedBy = "userType", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> users;

    @Override
    public String getAuthority() {
        return this.userType;
    }
}
