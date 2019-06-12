package com.fehead.repository;


import com.fehead.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xiaoaxiao on 2019/6/11
 * Description:该接口继承Repository接口，后面是一个泛型，第一个参数是实体类，第二个参数是主键的类型
 */
//@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository extends Repository<Employee,Integer> {

    public Employee findByName(String name);

    // where name like ?% and age<?
    public List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    //where name in (?,?...) or age <?
    public List<Employee> findByNameInOrAgeLessThan(List<String> names,Integer age);

    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    public Employee getEmployeeByMaxId();



    @Query("select o from Employee o where o.name=:name and o.age=:age")
    public Employee queryParams2(@Param("name") String name, @Param("age") Integer age);

    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    public Employee queryParams1(String name,Integer age);

    @Query("select o from Employee o where o.name like %:name%")
    public List<Employee> queryLike1(@Param("name") String name);

    //原生态查询
    @Query(nativeQuery = true,value = "select count(1) from employee")
    public long getCount();

    //更新操作
    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    public void update(@Param("id") Integer id,@Param("age") Integer age);
}
