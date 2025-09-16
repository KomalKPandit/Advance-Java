package service;

import dao.EmployeeDao;

public class EmployeeService {
	
	EmployeeDao dao = new EmployeeDao();

	public void insertData(int id, String name,String city,int salary) throws Exception {

		dao.insertData(id,name,city,salary);
	}

	public void updateData(int id, String name, String city, int salary) throws Exception {
		dao.updateData(id,name,city,salary);
		
	}
	public void deleteData(int id) throws Exception {
		dao.deleteData(id);
		
	}
	
	public void readData() throws Exception {
		dao.readData();
		
	}
	
}