package explore.spring.boot.explore.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="emp")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_sal")
    private String empSal;

    @Column(name = "emp_address")
    private String empAddress;

    @Column(name = "emp_dept")
    private Integer empDept;
}
