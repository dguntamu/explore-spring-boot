package explore.spring.boot.explore.model;

import explore.spring.boot.explore.entity.Address;
import lombok.*;

@Data
@ToString
public class EmployeeDTO {
    private Integer empId;
    private String empName;
    private String empAddress;
    private String empSal;
    private Integer empDeptNo;
    private Address address;

}
