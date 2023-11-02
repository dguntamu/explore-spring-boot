package explore.spring.boot.explore.model;

import lombok.*;

@Data
@ToString
public class EmployeeDTO {
    private Integer empId;
    private String empName;
    private String empAddress;
    private String empSal;
    private Integer empDeptNo;

}
