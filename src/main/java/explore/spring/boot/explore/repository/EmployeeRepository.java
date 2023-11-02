package explore.spring.boot.explore.repository;

import explore.spring.boot.explore.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    List<EmployeeEntity> findByEmpAddress(String empAddress);
    List<EmployeeEntity> findByEmpAddressAndEmpDept(String empAddress,Integer empDept);
    /*long countByEmpSal(String empSal);
    int deleteBEmpId(String empId);*/
}
