package com.fehead.repository;

import com.fehead.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoaxiao on 2019/6/11
 * Description:
 */
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName(){
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee);
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan(){
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test",22);

        for(Employee employee:employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameInOrAgeLessThanv(){
        List<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        names.add("test4");

        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names,20);

        for(Employee employee:employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployeeByMaxId(){
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee);
    }

    @Test
    public void testQueryParams1(){
        Employee employee = employeeRepository.queryParams1("test1",20);
        System.out.println(employee);
    }

    @Test
    public void testQueryParams2(){
        Employee employee = employeeRepository.queryParams2("test1",20);
        System.out.println(employee);
    }

    @Test
    public void testQueryLike1(){
        List<Employee> employees = employeeRepository.queryLike1("test");

        for(Employee employee:employees){
            System.out.println(employee);
        }
    }

    @Test
    public void testGetCount(){
        Long count = employeeRepository.getCount();
        System.out.println(count);
    }

    //更新操作
    @Test
    public void testUpdate(){
        employeeRepository.update(5,100);
    }
}
