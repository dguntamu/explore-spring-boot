package explore.spring.boot.explore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "address")
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "house_no")
    private String houseNo;
    @Column(name = "streat_name")
    private String streatName;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "pin_code")
    private Integer pinCode;
}
