package com.study.dawn.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

    @Around("@annotation(com.study.dawn.common.EventLog)")
    public Object validationValue(ProceedingJoinPoint joinPoint, EventLog eventLog) throws Throwable{

        HttpServletRequest request = ( (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        LogCode logCode = new CommonLog();

        String logType = eventLog.logCode();
        logger.info(logCode.getLogMsg(eventLog, request));

        logger.info("start - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();

        logger.info("finished - " + joinPoint.getSignature().getDeclaringTypeName() + " / " + joinPoint.getSignature().getName());


        return result;
    }



}
