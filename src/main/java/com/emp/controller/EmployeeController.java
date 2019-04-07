package com.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.emp.commond.EmployeeCommond;
import com.emp.dto.EmployeeDTO;
import com.emp.dto.EmployeeResultDTO;
import com.emp.service.EmployeeService;

@SuppressWarnings("deprecation")
public class EmployeeController extends AbstractCommandController {

	private EmployeeService empService;
	
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}
	@Override
	public ModelAndView handle(HttpServletRequest reqt, HttpServletResponse res, Object cmd,
			BindException be) throws Exception {
		
		System.out.println("EmployeeController.handle()");
		//get Command Class object
		EmployeeCommond commond=(EmployeeCommond)cmd;
		
		//convert command object into dto object 
		EmployeeDTO dto=new EmployeeDTO();
		
		dto.setEmpNo(commond.getEmpNo());
		dto.seteName(commond.geteName());
		dto.setJob(commond.getJob());
		dto.setSal(commond.getSal());
		
		//use service class object 
		List<EmployeeResultDTO> listRDTO=empService.getAllRecordByInputs(dto);
		
		return new ModelAndView("searchEmp","empResult",listRDTO);
	}

}
