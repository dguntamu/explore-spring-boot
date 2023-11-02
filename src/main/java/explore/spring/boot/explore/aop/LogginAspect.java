package explore.spring.boot.explore.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class LogginAspect {
    Logger logger = LoggerFactory.getLogger(LogginAspect.class);

    /*@Before("allGetters()")
    public void logginBeforeAdvice(){
        logger.debug("Before logging advice");
    }*/

    @Around("allGetters()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before target called...");
        try {
            proceedingJoinPoint.proceed();
            logger.info("After target called...");
        } catch (Throwable e) {
            logger.info("After throwing called...");
            throw new RuntimeException(e);
        }
        logger.info("After finally...");
    }

    @Pointcut("execution(* get*())")
    public void allGetters(){

    }

    /**
     * Step-3: Definition of Loggable
     */
    @Around("@annotation(explore.spring.boot.explore.aop.Loggable)")
    public void applyLoggable(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("applyLoggable() executed before target");
        try {
            proceedingJoinPoint.proceed();
            logger.info("applyLoggable() executed after target");
        } catch (Throwable e) {
            logger.info("applyLoggable() throws exception");
            throw new RuntimeException(e);
        }
        logger.info("applyLoggable() executed successfully...");
    }
}
