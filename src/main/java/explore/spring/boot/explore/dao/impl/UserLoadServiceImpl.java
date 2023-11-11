package explore.spring.boot.explore.dao.impl;

import explore.spring.boot.explore.entity.EmployeeEntity;
import explore.spring.boot.explore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserLoadServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeeEntity> entity = employeeRepository.findById(Integer.parseInt(username));
        if(!entity.isPresent()){
            throw new UsernameNotFoundException(username);
        }

        EmployeeEntity employeeEntity = entity.get();
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        SimpleGrantedAuthority auth = new SimpleGrantedAuthority(employeeEntity.getEmpAddress());
        grantedAuthorityList.add(auth);

        return new User(employeeEntity.getEmpName(),employeeEntity.getEmpPassword(),grantedAuthorityList);
    }
}
