package explore.spring.boot.explore.dao.impl;

import explore.spring.boot.explore.dao.EmployeeDAO;
import explore.spring.boot.explore.entity.EmployeeEntity;
import explore.spring.boot.explore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public boolean deleteEmployeeById(Integer empId) {
        employeeRepository.deleteById(empId);
        return true;
    }

    @Override
    public EmployeeEntity updateEmpployee(EmployeeEntity employeeEntity) {
        return employeeRepository.saveAndFlush(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
