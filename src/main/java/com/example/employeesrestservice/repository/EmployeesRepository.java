package com.example.employeesrestservice.repository;

import com.example.employeesrestservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByDepartIdIn(Collection<Integer> departId);
}

