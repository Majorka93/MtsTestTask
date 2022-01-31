package com.example.employees.service;

import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public Employee findById(Long id) {
        return employeesRepository.findById(id).get();
    }

    public List<Employee> findAll(List<Integer> departsId) {
        if (departsId == null || departsId.isEmpty()) {
            return employeesRepository.findAll();
        } else {
            return employeesRepository.findAllByDepartIdIn(departsId);
        }
    }

    public Employee updateEmployees(Employee employees) {
        return employeesRepository.save(employees);
    }

    public Employee createEmployees(Employee employees) {
        return employeesRepository.save(employees);
    }

    public void deleteById(Long id) {
        employeesRepository.deleteById(id);
    }


}
