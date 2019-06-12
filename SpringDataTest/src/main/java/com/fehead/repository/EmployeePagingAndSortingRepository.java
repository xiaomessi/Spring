package com.fehead.repository;

import com.fehead.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by xiaoaxiao on 2019/6/12
 * Description:
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee,Integer> {
}
