package mum.edu.mstore.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Controller;


@Aspect
@Controller
public class LoggingAspect {
	
	
	 @After("execution(* mum.edu.mstore.controller.*.*(..))")	
	  public void AfterControllerTrace(JoinPoint joinPoint)
	  {
		 
		 System.out.println((new Date() + "\t" + "method=" +joinPoint.getSignature().getName()+ "\n"+"message =" +"Called" + "\n" ));
		  
	  }
	 
	 
	 @After("execution(* mum.edu.mstore.service.*.*(..))")	
	  public void AfterServiceTrace(JoinPoint joinPoint)
	  {
		 
		 System.out.println((new Date() + "\t" + "method=" +joinPoint.getSignature().getName()+ "\n"+"message =" +"Called" + "\n" ));
		  
	  }



}
