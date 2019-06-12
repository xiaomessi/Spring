package com.fehead.repository;

import com.fehead.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by xiaoaxiao on 2019/6/12
 * Description:
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {
}
