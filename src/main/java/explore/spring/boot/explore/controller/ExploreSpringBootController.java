package explore.spring.boot.explore.controller;

import explore.spring.boot.explore.model.EmployeeDTO;
import explore.spring.boot.explore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExploreSpringBootController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/ping")
    public String ping(){
        return "I'm reachable";
    }

    @PostMapping("/emp")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        System.out.println("In Controller..");
        employeeService.addEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
    }

    @GetMapping("/emp/{empId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer empId){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(empId));
    }

    @DeleteMapping("/emp/{empId}")
    public void deleteEmployeeById(@PathVariable Integer empId){
     employeeService.deleteEmployeeById(empId);
        System.out.println("Delelte employee with ID "+empId);
    }

    @PutMapping("/emp")
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.updateEmpployee(employeeDTO);
    }

    @GetMapping("/emps")
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.finAllEmployees());
    }
}
