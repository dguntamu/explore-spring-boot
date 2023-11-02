package explore.spring.boot.explore.dao;

import explore.spring.boot.explore.entity.DoctorEntity;

public interface DoctorDAO {
    void saveDoctor(DoctorEntity doctorEntity);
}
