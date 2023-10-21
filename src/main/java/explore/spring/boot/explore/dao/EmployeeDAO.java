package explore.spring.boot.explore.dao;

import explore.spring.boot.explore.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO{
    public void addEmployee(EmployeeEntity employeeEntity);
    Optional<EmployeeEntity> getEmployee(Integer empId);
    boolean deleteEmployeeById(Integer empId);
    EmployeeEntity updateEmpployee(EmployeeEntity employeeEntity);
    List<EmployeeEntity> findAllEmployees();
}
