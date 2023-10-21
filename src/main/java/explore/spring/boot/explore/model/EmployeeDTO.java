package explore.spring.boot.explore.model;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@Data
@AllArgsConstructor
public class EmployeeDTO {
private Integer empId;
private String empName;
private String empAddress;
private String empSal;
private Integer empDeptNo;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empSal='" + empSal + '\'' +
                ", empDeptNo=" + empDeptNo +
                '}';
    }
}
