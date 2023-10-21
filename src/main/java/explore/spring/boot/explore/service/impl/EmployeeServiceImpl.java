package explore.spring.boot.explore.service.impl;

import explore.spring.boot.explore.dao.EmployeeDAO;
import explore.spring.boot.explore.entity.EmployeeEntity;
import explore.spring.boot.explore.model.EmployeeDTO;
import explore.spring.boot.explore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void addEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeEntity = getEmployeeEntity(employee);
        employeeDAO.addEmployee(employeeEntity);
    }

    @Override
    public EmployeeDTO getEmployee(Integer empId) {
        Optional<EmployeeEntity> empFromDB = employeeDAO.getEmployee(empId);
        EmployeeDTO empDTO = getEmployeeDTO(empFromDB);
        empDTO.setEmpId(empId);
        return empDTO;
    }

    private EmployeeDTO getEmployeeDTO(Optional<EmployeeEntity> empFromDB) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if(empFromDB.isPresent()){
            EmployeeEntity entity = empFromDB.get();
            employeeDTO.setEmpName(entity.getEmpName());
            employeeDTO.setEmpAddress(entity.getEmpAddress());
            employeeDTO.setEmpSal(entity.getEmpSal());
            employeeDTO.setEmpDeptNo(entity.getEmpDept());
        }
        return employeeDTO;
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
