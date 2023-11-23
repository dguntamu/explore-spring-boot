package explore.spring.boot.explore.authenticationprovider;

import explore.spring.boot.explore.entity.EmployeeEntity;
import explore.spring.boot.explore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class MyCustomBasicAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String passWord = authentication.getCredentials().toString();

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(Integer.parseInt(userName));
        if(employeeEntity.isPresent() && passwordEncoder.matches(passWord,employeeEntity.get().getEmpPassword())){
            List<GrantedAuthority> roles = new ArrayList<>();
            SimpleGrantedAuthority role = new SimpleGrantedAuthority(employeeEntity.get().getEmpAddress());
            roles.add(role);
            return new UsernamePasswordAuthenticationToken(userName,passWord,roles);
        }else{
            throw new UsernameNotFoundException(employeeEntity.get().getEmpName());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
