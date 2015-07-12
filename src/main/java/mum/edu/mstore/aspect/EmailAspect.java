package mum.edu.mstore.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmailAspect {

	static Logger logger = Logger.getLogger(EmailAspect.class.getName());
	@After("execution(* mum.edu.mstore.HomeController.sendEmailTest(..))")
	public void sendEmail(){
		System.out.println("send email");
		
	}
}
