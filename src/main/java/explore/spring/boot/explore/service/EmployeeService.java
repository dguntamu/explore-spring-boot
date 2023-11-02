package explore.spring.boot.explore.service;

import explore.spring.boot.explore.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(EmployeeDTO employee);
    EmployeeDTO getEmployee(Integer empId);
    void deleteEmployeeById(Integer empId);
    EmployeeDTO updateEmpployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> finAllEmployees();

    //Customer query
    List<EmployeeDTO> findByEmpAddress(String empAddress);

    //Multi condition
    List<EmployeeDTO> findByEmpAddressAndEmpDept(String empAddress, Integer empDept);

    //Sorting
    //List<EmployeeDTO> getSortedEmployees(String field);
}
