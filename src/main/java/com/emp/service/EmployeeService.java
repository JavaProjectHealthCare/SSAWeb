package com.emp.service;

import java.util.List;

import com.emp.dto.EmployeeDTO;
import com.emp.dto.EmployeeResultDTO;

public interface EmployeeService {

	
	List<EmployeeResultDTO> getAllRecordByInputs(EmployeeDTO edto);
}
