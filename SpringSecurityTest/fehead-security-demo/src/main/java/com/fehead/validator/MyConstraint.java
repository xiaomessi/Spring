package com.fehead.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiaoaxiao on 2019/6/20
 * Description:
 */
// 注解的作用地方：方法+参数上可以使用自定义注解
@Target({ElementType.METHOD,ElementType.FIELD})
// 注解在运行时使用
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
// 自定义注解（Annotation）
public @interface MyConstraint{
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
