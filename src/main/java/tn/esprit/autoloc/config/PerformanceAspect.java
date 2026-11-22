package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {


    @Around("execution(* tn.esprit.autoloc.service.*.*(..))")
    public Object mesurerTempsExecution(ProceedingJoinPoint pjp) throws Throwable {
        long debut = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } finally {
            long duree = System.currentTimeMillis() - debut;
            String nomMethode = pjp.getSignature().getName();
            log.info("Performance - méthode {} exécutée en {} ms", nomMethode, duree);
            if (duree > 1000) {
                log.warn("Performance - ATTENTION : la méthode {} est lente ({} ms > 1000 ms)", nomMethode, duree);
            }
        }
    }
}