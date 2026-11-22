package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.autoloc.service.*.*(..)")
    public void logBefore(JoinPoint joinPoint){
        String methodeName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        log.info("Before - methode appelée :" + methodeName);
    }
}
