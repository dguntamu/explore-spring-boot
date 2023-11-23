package explore.spring.boot.explore.controller;

import explore.spring.boot.explore.aop.Loggable;
import explore.spring.boot.explore.model.EmployeeDTO;
import explore.spring.boot.explore.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExploreSpringBootController {
    Logger logger = LoggerFactory.getLogger(ExploreSpringBootController.class);
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/ping")
    public String ping(){
        return "I'm reachable";
    }

    @PostMapping("/emp")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        logger.debug("Initiated Employee Onboarding...");
        if(employeeDTO.getEmpName().equals("dj")){
            throw new RuntimeException();
        }
        employeeService.addEmployee(employeeDTO);
        logger.info("Employee '{}' Onboarded successfully",employeeDTO.getEmpName());
        return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
    }

    @GetMapping("/emp/{empId}")
    @Loggable //Step-2: Appllying Loggable
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer empId){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(empId));
    }

    @DeleteMapping("/emp/{empId}")
    public void deleteEmployeeById(@PathVariable Integer empId){
     employeeService.deleteEmployeeById(empId);
        System.out.println("Delete employee with ID "+empId);
    }

    @PutMapping("/emp")
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.updateEmpployee(employeeDTO);
    }

    /**
     *
     * @param authentication : This authentication object is provided by spring after completing below process.
     *                       AuthenticationFilter(I)  -> UsernamePasswordAuthenticationFilter(C) --> From based login, BasicAuthenticationFilter(C) --> postman login
     *                       AuthenticationManager(I) -> ProviderManager(C)
     *                       AuthenticationProvider(I) -> DaoAuthenticationProvider (C)
     *                                                    MyCustomBasicAuthenticationProvider implements AuthenticationProvider
     *                                                    OTPAuthenicationProvider implements AuthenticationProvider
     *                                                    ThumbImpresionAuthenticationProvider implements AuthenticationProvider
     * @return
     */
    @GetMapping("/emps")
    public ResponseEntity<List<EmployeeDTO>> getEmployees(Authentication authentication){
        logger.info("User Name after FILTER CHAIN COMPLETED {} ",authentication.getPrincipal().toString()+", password : {} ",authentication.getCredentials());
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.finAllEmployees());
    }

    @GetMapping("/emp-address/{empAddress}")
    @Loggable //Step-2: Applying Loggable
    public ResponseEntity<List<EmployeeDTO>> findEmployeeByAddress(@PathVariable String empAddress){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findByEmpAddress(empAddress));
    }

    @GetMapping("/emp-by-address-dept/{empAddress}/{empDept}")
    @Loggable //Step-2: Applying Loggable
    public ResponseEntity<List<EmployeeDTO>> findEmployeeByAddressAndEmpDept(@PathVariable String empAddress,@PathVariable Integer empDept){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findByEmpAddressAndEmpDept(empAddress,empDept));
    }
}
