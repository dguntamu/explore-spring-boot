package explore.spring.boot.explore.dao;

import explore.spring.boot.explore.entity.EmployeeEntity;

import java.util.Optional;

public interface EmployeeDAO{
    public void addEmployee(EmployeeEntity employeeEntity);
    Optional<EmployeeEntity> getEmployee(Integer empId);
}
