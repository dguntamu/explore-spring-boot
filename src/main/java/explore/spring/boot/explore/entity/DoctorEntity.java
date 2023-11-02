package explore.spring.boot.explore.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
