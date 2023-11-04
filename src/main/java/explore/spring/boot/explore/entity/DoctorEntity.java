package explore.spring.boot.explore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {
    @EmbeddedId
    private DoctorEntityPK doctorEntityPK;
    private String emailId;
    private String address;
}
