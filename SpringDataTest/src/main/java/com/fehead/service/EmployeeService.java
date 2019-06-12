package com.fehead.service;

import com.fehead.domain.Employee;
import com.fehead.repository.EmployeeCrudRepository;
import com.fehead.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaoaxiao on 2019/6/12
 * Description:
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id,Integer age){
        employeeRepository.update(id,age);
    }

    @Transactional
    public void save(List<Employee> employees){
        employeeCrudRepository.save(employees);
    }
}
