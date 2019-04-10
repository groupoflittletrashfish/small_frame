package com.noname.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by noname on 2019/4/9.
 */
@Data
public class Book {
    private Integer id;
    @NotBlank(message = "name不允许为空")
    @Length(min = 2, max = 10, message = "长度必须在{min}={max}之间")
    private String name;
    @DecimalMin(value = "0.1", message = "价格不能低于{value}毛钱")
    @NotNull(message = "价格不能为空")
    private BigDecimal price;
}
