package mum.edu.mstore.aspect;

import java.util.Date;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author sudarshan
 */
@Aspect
public class UserAspect {
  static Logger logger = Logger.getLogger(EmailAspect.class.getName());
  @After("execution(* mum.edu.mstore.controller.HomeController.home(..))")  
  public void logininfo(){
      System.out.println("Error login page details");
        logger.info("log file");  
  }  
}
