package com.noname.validation;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;

/**
 * springboot自带验证框架，用于验证前端数据，在类上必须添加@Validated字段来验证
 * 建议使用统一异常处理来给前端返回需要的json格式,请查看globle包
 * Created by noname on 2019/4/9.
 */
@Controller
@RequestMapping("validation")
@Validated
public class ValidationController {

    /**
     *此方式是针对类来验证的，@Validated必须在需要验证的对象上添加，具体的验证规则则在实体中.如果想返回指定格式的json，需要在全局异常捕获中申明
     * @param book
     * @return
     */
    @GetMapping("valid1")
    @ResponseBody
    public String valid1(@Validated Book book) {
        return "success";
    }


    /**
     * 此种方法是用于验证字段的，所以验证的规则需要在该字段就写清楚
     * @param username
     * @return
     */
    @GetMapping("valid2")
    @ResponseBody
    public String valid2(@NotBlank(message = "用户名不能为空") @Length(min = 2, max = 10, message = "长度不惜在{min}-{max}之间") String username) {
        return "success";
    }
}
