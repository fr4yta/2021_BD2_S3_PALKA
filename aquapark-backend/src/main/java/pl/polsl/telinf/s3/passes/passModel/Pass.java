package pl.polsl.telinf.s3.passes.passModel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import pl.polsl.telinf.s3.passes.passTypeModel.PassType;

import javax.persistence.*;

@Entity
@Table(name = "passes")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne (targetEntity = PassType.class)
    @JoinColumn(name = "pass_type", nullable = false)
    private PassType passType;
}
