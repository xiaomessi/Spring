package com.fehead.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by xiaoaxiao on 2019/6/20
 * Description: 自定义注解类实现ConstraintValidator接口，可在其中使用@Autowired获取Spring中的bean
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    //可使用@Autowired获取Spring中的bean

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    /**
     * 用这个方法添加验证信息，通过验证返回true，不通过，返回false
     */
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(o);
        return false;
    }
}
