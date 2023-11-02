package explore.spring.boot.explore.service.impl;

import explore.spring.boot.explore.dao.DoctorDAO;
import explore.spring.boot.explore.entity.DoctorEntity;
import explore.spring.boot.explore.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDAO doctorDAO;
    @Override
    public void saveDoctor(DoctorEntity doctorEntity) {
        doctorDAO.saveDoctor(doctorEntity);
    }
}
