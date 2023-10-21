package explore.spring.boot.explore.dao.impl;

import explore.spring.boot.explore.dao.EmployeeDAO;
import explore.spring.boot.explore.entity.EmployeeEntity;
import explore.spring.boot.explore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void addEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    @Override
    public Optional<EmployeeEntity> getEmployee(Integer empId) {
        Optional<EmployeeEntity> empFromDB = employeeRepository.findById(empId);
        if(empFromDB.isPresent()){
            return empFromDB;
        }
        return Optional.empty();
    }
}
