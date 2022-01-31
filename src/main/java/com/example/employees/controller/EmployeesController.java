package com.example.employees.controller;

import com.example.employees.controller.req.EmployeesReq;
import com.example.employees.controller.resp.EmployeesResp;
import com.example.employees.model.Employee;
import com.example.employees.service.EmployeesService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Получение всех сотрудников/фильтрация по департаментам", response = Iterable.class)
    @GetMapping()
    public List<EmployeesResp> findAll(@RequestParam(required = false) List<Integer> departsId) {
        return employeesService.findAll(departsId).stream()
                .map(EmployeesResp::of)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Получить сотрудника по id")
    @GetMapping("/{id}")
    public Employee findById(@PathVariable(value = "id") Long id) {
        return employeesService.findById(id);
    }
    @ApiOperation(value = "Удалить сотрудника")
    @DeleteMapping()
    public String deleteById(@RequestParam(value = "id", required = false) Long id) {
        employeesService.deleteById(id);
        return "Пользователь с id " + id + " удален";
    }
    @ApiOperation(value = "Добавить сотрудника")
    @PostMapping()
    public String createEmployees(@RequestBody @Validated EmployeesReq req) {
        Employee employees = new Employee();
        employees.setFirstName(req.getFirstName());
        employees.setLastName(req.getLastName());
        employees.setPhone(req.getPhone());
        employees.setDepartId(req.getDepartId());
        employeesService.createEmployees(employees);
        return "Пользователь добавлен";
    }
    @ApiOperation(value = "Изменить сотрудника")
    @PutMapping()
    public String updateEmployees(@RequestBody EmployeesReq req) {
        Employee employees = new Employee();
        employees.setId(req.getId());
        employees.setFirstName(req.getFirstName());
        employees.setLastName(req.getLastName());
        employees.setPhone(req.getPhone());
        employees.setDepartId(req.getDepartId());
        employeesService.updateEmployees(employees);
        return "Обновлен "
                + findById(employees.getId());
    }


}
