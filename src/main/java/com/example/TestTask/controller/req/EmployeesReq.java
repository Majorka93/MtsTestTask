package com.example.TestTask.controller.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data

public class EmployeesReq {

    private Long id;
    @NotEmpty
    @NotNull
    private String lastName;
    @NotEmpty
    @NotNull
    private String firstName;
    @NotNull
    private Long phone;
    private Integer departId;


}
