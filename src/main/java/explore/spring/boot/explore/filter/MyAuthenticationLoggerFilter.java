package explore.spring.boot.explore.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;
@Slf4j
public class MyAuthenticationLoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()){
            log.info("User {} ",authentication.getName()+" is authenticated");
        }else{
            log.info("User {} ",authentication.getName()+" is NOT yet authenticated");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
