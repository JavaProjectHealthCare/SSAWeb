package com.emp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.emp.bo.EmployeeBO;
import com.emp.bo.EmployeeResultBO;

public class EmployeeDAOImpl implements EmployeeDAO {

	//private static final String GET_RECORD_BY_INPUTS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE (EMPNO IS NOT NULL AND EMPNO=?) OR (ENAME IS NOT NULL AND ENAME LIKE ?) OR (JOB IS NOT NULL AND JOB LIKE ?) OR (SAL IS NOT NULL AND SAL=?)";
	
private static final String GET_RECORD="SELECT * FROM EMP WHERE EMPNO=?";
	private JdbcTemplate jt;
	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public List<EmployeeResultBO> featchReecordByInput(EmployeeBO bo) {
	
		List<EmployeeResultBO> listERBO=jt.query(GET_RECORD,
													new ResultSetExtractor<List<EmployeeResultBO>>() {

														@Override
														public List<EmployeeResultBO> extractData(ResultSet rs)throws SQLException, DataAccessException {
															
															List<EmployeeResultBO> listRBO=new ArrayList<EmployeeResultBO>();
															EmployeeResultBO ebo=new EmployeeResultBO();
															
															while(rs.next()) {
															ebo.setEmpNo(rs.getInt(1));
															ebo.seteName(rs.getString(2));
															ebo.setDeptNo(rs.getInt(3));
															ebo.setMgr(rs.getInt(4));
															ebo.setSal(rs.getInt(5));
															ebo.setJob(rs.getString(6));
															 
															listRBO.add(ebo);
															}
															return listRBO;
														}
													},
											
												bo.getEmpNo(),
												bo.geteName(),
												bo.getJob(),
												bo.getSal());
	
	
		
		return listERBO;
	}

}
