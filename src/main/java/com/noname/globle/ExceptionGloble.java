package com.noname.globle;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by noname on 2019/4/9.
 */
@ControllerAdvice
public class ExceptionGloble {

    /**
     * 验证对象时所需要的全局捕获器，如果不用这段代码则会显示很长的一段错误提示
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public String exception(HttpServletRequest request, BindException exception) {
        BindingResult result = exception.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();

        for (FieldError error : fieldErrors) {
            System.out.println(error.getField());
            System.out.println(error.getDefaultMessage());
            builder.append(error.getDefaultMessage() + "\n");
        }
        return builder.toString();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        System.out.println("-----");
        e.printStackTrace();
        return e.getMessage();
    }
}
