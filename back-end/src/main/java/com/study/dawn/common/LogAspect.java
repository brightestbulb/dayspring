package com.study.dawn.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(eventLog)")
    public void appLogPointCut(EventLog eventLog){}

    @Around("appLogPointCut(eventLog)")
    public Object doAround(ProceedingJoinPoint joinPoint, EventLog eventLog) throws Throwable{

        HttpServletRequest request = ( (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        LogCode logCode = new CommonLog();

        String logMsg = logCode.getLogMsg(eventLog, request);



        logger.info("start - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName() + " / " + logMsg);

        Object result = joinPoint.proceed();

        logger.info("finished - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName()+ " / " + eventLog.key());

        return result;

    }


}
