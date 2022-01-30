package com.example.TestTask.controller;

import com.example.TestTask.controller.req.EmployeesReq;
import com.example.TestTask.controller.resp.EmployeesResp;
import com.example.TestTask.model.Employee;
import com.example.TestTask.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }


    @GetMapping()
    public List<EmployeesResp> findAll(@RequestParam(required = false) List<Integer> departsId) {
        return employeesService.findAll(departsId).stream()
                .map(EmployeesResp::of)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public Employee findById(@PathVariable(value = "id") Long id) {
        return employeesService.findById(id);
    }

    @DeleteMapping()
    public String deleteById(@RequestParam(value = "id", required = false) Long id) {
        employeesService.deleteById(id);
        return "Пользователь с id " + id + " удален";
    }

    @PostMapping()
    public String createEmployees(@RequestBody @Validated EmployeesReq req) {
        Employee employees = new Employee();
        employees.setFirstName(req.getFirstName());
        employees.setLastName(req.getLastName());
        employees.setPhone(req.getPhone());
        employees.setDepartId(req.getDepart());
        employeesService.createEmployees(employees);
        return "Пользователь добавлен";
    }

    @PutMapping()
    public String updateEmployees(@RequestBody EmployeesReq req) {
        Employee employees = new Employee();
        employees.setId(req.getId());
        employees.setFirstName(req.getFirstName());
        employees.setLastName(req.getLastName());
        employees.setPhone(req.getPhone());
        employees.setDepartId(req.getDepart());
        employeesService.updateEmployees(employees);
        return "Обновлен "
                + findById(employees.getId());
    }


}
