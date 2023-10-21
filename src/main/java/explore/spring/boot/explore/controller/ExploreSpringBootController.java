package explore.spring.boot.explore.controller;

import explore.spring.boot.explore.model.EmployeeDTO;
import explore.spring.boot.explore.service.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
