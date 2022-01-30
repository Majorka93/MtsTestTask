package com.example.TestTask.controller.resp;

import com.example.TestTask.model.Employee;
import lombok.Data;

@Data
public class EmployeesResp {

    private Long id;
    private String lastName;
    private String firstName;
    private Long phone;
    private Integer depart;


    public static EmployeesResp of(Employee employee) {
        EmployeesResp employeesResp = new EmployeesResp();
        employeesResp.setFirstName(employee.getFirstName());
        employeesResp.setLastName(employee.getLastName());
        employeesResp.setPhone(employee.getPhone());
        employeesResp.setDepart(employee.getDepartId());
        return employeesResp;

    }
}
