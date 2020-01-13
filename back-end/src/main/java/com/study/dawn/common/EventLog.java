package com.study.dawn.common;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface EventLog {

    String logCode();
    String key() default "";
    String type() default "";
}

interface LogCode{

    String getLogMsg(EventLog eventLog, HttpServletRequest request);

    enum Code {
        CREATE("CRT"),
        UPDATE("UPT"),
        READ("READ"),
        DELETE("DLT");

        public String logMsg;

        private Code(String logMsg){
            this.logMsg = logMsg;
        }

        public String getLogCode(){
            return this.logMsg;
        }
    }
}

class CommonLog implements LogCode{

    public String getLogMsg(EventLog eventLog, HttpServletRequest request){

        String key = eventLog.key();
        String code = eventLog.logCode();
        String type = eventLog.type();
        String value=request.getParameter(key);

        String logMsg = type + " " +Code.valueOf(code).getLogCode() + " " + key+ "=" + value;

        return logMsg;
    }

}