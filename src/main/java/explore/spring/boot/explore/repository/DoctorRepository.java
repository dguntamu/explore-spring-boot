package explore.spring.boot.explore.repository;

import explore.spring.boot.explore.entity.DoctorEntity;
import explore.spring.boot.explore.entity.DoctorEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, DoctorEntityPK> {
}
