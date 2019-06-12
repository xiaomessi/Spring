package com.fehead.service;

import com.fehead.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaoaxiao on 2019/6/12
 * Description:
 */
public class EmployeeServiceTest {

    private ApplicationContext ctx = null;

    private EmployeeService employeeService = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testUpdate(){
        employeeService.update(5,100);
    }


}