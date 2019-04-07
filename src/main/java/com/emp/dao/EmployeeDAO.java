package com.emp.dao;

import java.util.List;

import com.emp.bo.EmployeeBO;
import com.emp.bo.EmployeeResultBO;

public interface EmployeeDAO {

public List<EmployeeResultBO> featchReecordByInput(EmployeeBO bo);		
}
