package com.emp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.emp.bo.EmployeeBO;
import com.emp.bo.EmployeeResultBO;
import com.emp.dao.EmployeeDAO;
import com.emp.dto.EmployeeDTO;
import com.emp.dto.EmployeeResultDTO;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao;
	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<EmployeeResultDTO> getAllRecordByInputs(EmployeeDTO edto) {

	//convert EmployeeDTO to EmployeeBO
		EmployeeBO ebo=new EmployeeBO();
		ebo.setEmpNo(edto.getEmpNo());
		ebo.seteName(edto.geteName());
		ebo.setJob(edto.getJob());
		ebo.setSal(edto.getSal());
		
		//use dao
		List<EmployeeResultBO> listRBO=dao.featchReecordByInput(ebo);
		
		//convert listRBO to ListRDTO
		
		List<EmployeeResultDTO> listRDTO=new ArrayList<EmployeeResultDTO>();
		
		for(EmployeeResultBO rbo:listRBO) {
			EmployeeResultDTO rdto=new EmployeeResultDTO();
			BeanUtils.copyProperties(rdto, rbo);
			rdto.setSrNo(listRBO.size()+1);
			
			listRDTO.add(rdto);
		}
		return listRDTO;
	}//method
}//class