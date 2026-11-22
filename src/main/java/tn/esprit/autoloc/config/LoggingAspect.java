package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @Before("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String nomMethode = joinPoint.getSignature().getName();
        Object[] parametres = joinPoint.getArgs();
        log.info("Before - méthode appelée : {} | paramètres : {}", nomMethode, Arrays.toString(parametres));
    }


    @After("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("After - exécution terminée de la méthode : {}", joinPoint.getSignature().getName());
    }
}