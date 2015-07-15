package mum.edu.mstore.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @author bipin
 */
@Aspect
@Component
public class ServiceAspect {

    @After("execution(* mum.edu.mstore.service.*.*(..))")
    public void logMethodInfo(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method name in the service: " + methodName);
    }

    @AfterThrowing(pointcut= "execution(* mum.edu.mstore.service.*.*(..))",throwing= "exception")
    public void logExceptionMessage(JoinPoint joinPoint, Exception exception) {
        System.out.println(exception.getMessage());
    }
}
