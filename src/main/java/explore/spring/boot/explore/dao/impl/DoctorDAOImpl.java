package explore.spring.boot.explore.dao.impl;

import explore.spring.boot.explore.dao.DoctorDAO;
import explore.spring.boot.explore.entity.DoctorEntity;
import explore.spring.boot.explore.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDAOImpl implements DoctorDAO {
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public void saveDoctor(DoctorEntity doctorEntity) {
        doctorRepository.save(doctorEntity);
    }
}
