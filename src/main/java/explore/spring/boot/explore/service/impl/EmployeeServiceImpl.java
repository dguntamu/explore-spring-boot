package explore.spring.boot.explore.service.impl;

import explore.spring.boot.explore.dao.EmployeeDAO;
import explore.spring.boot.explore.entity.EmployeeEntity;
import explore.spring.boot.explore.model.EmployeeDTO;
import explore.spring.boot.explore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        EmployeeDTO empDTO = new EmployeeDTO();
        if (empFromDB.isPresent()) {
            empDTO = getEmployeeDTO(empFromDB.get());
            empDTO.setEmpId(empId);
        }

        return empDTO;
    }

    @Override
    public void deleteEmployeeById(Integer empId) {
        employeeDAO.deleteEmployeeById(empId);
    }

    @Override
    public EmployeeDTO updateEmpployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = getEmployeeEntity(employeeDTO);
        employeeDAO.updateEmpployee(employeeEntity);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> finAllEmployees() {
        List<EmployeeDTO> allEmployees = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = employeeDAO.findAllEmployees();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            allEmployees.add(getEmployeeDTO(employeeEntity));
        }
        return allEmployees;
    }

    private EmployeeDTO getEmployeeDTO(EmployeeEntity empFromDB) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpName(empFromDB.getEmpName());
        employeeDTO.setEmpAddress(empFromDB.getEmpAddress());
        employeeDTO.setEmpSal(empFromDB.getEmpSal());
        employeeDTO.setEmpDeptNo(empFromDB.getEmpDept());
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
