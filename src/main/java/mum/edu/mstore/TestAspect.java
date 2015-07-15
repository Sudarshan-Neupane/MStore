package mum.edu.mstore;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TestAspect {
	
	
	 @After("execution(* mum.edu.mstore.controller.HomeController.home(..))")	
	  public void AfterEmailTrace(JoinPoint joinPoint)
	  {
		  //System.out.println(new Date() + "\t" + "method = "+ joinPoint.getSignature().getName());
		  //Using Log4j
		 System.out.println("I am your aspect");
		  
	  }

}
