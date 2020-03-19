package cn.edu.jnu.crowdbc.config;

import org.springframework.web.bind.annotation.ControllerAdvice;

//@ControllerAdvice
public class ExceptionHandler {
//    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e) {
//        System.out.println("未知异常！原因是:" + e);
        return e.getMessage();
    }
}
