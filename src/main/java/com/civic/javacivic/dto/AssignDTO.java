package com.civic.javacivic.dto;

import com.civic.javacivic.model.Department;
import lombok.Data;

@Data
public class AssignDTO {
    private Department.DepartmentName departmentName;
    private String adminComment;
}
