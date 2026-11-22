package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionHandlingAspect {


    @AfterThrowing(pointcut = "execution(* tn.esprit.autoloc.service.*.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        log.error("Exception - méthode : {} | type : {} | message : {}",
                joinPoint.getSignature().getName(),
                exception.getClass().getName(),
                exception.getMessage());
    }
}