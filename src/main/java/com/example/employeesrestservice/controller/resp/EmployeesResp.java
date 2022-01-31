package com.example.employeesrestservice.controller.resp;

import com.example.employeesrestservice.model.Employee;
import lombok.Data;

@Data
public class EmployeesResp {

    private Long id;
    private String lastName;
    private String firstName;
    private Long phone;
    private Integer departId;


    public static EmployeesResp of(Employee employee) {
        EmployeesResp employeesResp = new EmployeesResp();
        employeesResp.setFirstName(employee.getFirstName());
        employeesResp.setLastName(employee.getLastName());
        employeesResp.setPhone(employee.getPhone());
        employeesResp.setDepartId(employee.getDepartId());
        return employeesResp;

    }
}
