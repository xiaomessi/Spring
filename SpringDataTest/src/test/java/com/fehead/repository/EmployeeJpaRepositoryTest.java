package com.fehead.repository;

import com.fehead.domain.Employee;
import com.fehead.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoaxiao on 2019/6/11
 * Description:
 */
public class EmployeeJpaRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeeJpaRepository  = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){

        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println(employee);

        System.out.println("employee(10)"+employeeJpaRepository.exists(10));
        System.out.println("employee(1000)"+employeeJpaRepository.exists(1000));
    }
}
