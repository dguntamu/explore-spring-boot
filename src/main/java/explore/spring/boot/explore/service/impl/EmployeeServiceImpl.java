package explore.spring.boot.explore.service.impl;

import explore.spring.boot.explore.dao.EmployeeDAO;
import explore.spring.boot.explore.entity.EmployeeEntity;
import explore.spring.boot.explore.model.EmployeeDTO;
import explore.spring.boot.explore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void addEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeEntity = getEmployeeEntity(employee);
        employeeDAO.addEmployee(employeeEntity);
    }

    private EmployeeEntity getEmployeeEntity(EmployeeDTO employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(employee.getEmpId());
        employeeEntity.setEmpName(employee.getEmpName());
        employeeEntity.setEmpAddress(employee.getEmpAddress());
        employeeEntity.setEmpSal(employee.getEmpSal());
        employeeEntity.setEmpDept(employee.getEmpDeptNo());
        return employeeEntity;
    }
}
