package com.example.TestTask.repository;

import com.example.TestTask.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByDepartIdIn(Collection<Integer> departId);
}

