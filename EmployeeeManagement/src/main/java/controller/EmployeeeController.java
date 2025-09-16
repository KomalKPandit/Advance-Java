package controller;

import dao.EmployeeDao;
import service.EmployeeService;
import java.util.Scanner;

public class EmployeeeController {
	

	public static void main(String[] args) throws Exception {

		EmployeeService employeeservice = new EmployeeService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== Employee Records Management =====");
			System.out.println("[1] -> Add Employee Data");
			System.out.println("[2] -> Update Employee Data");
			System.out.println("[3] -> Delete Employee Data");
			System.out.println("[4] -> View Employee Data");
			System.out.println("[5] -> Exit");
			System.out.print("Enter choice: ");
			int ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:
				addEmployee(sc,employeeservice);
				break;
			case 2:
				updateEmployee(sc,employeeservice);
				break;
			case 3:
				deleteEmployee(sc,employeeservice);
				break;
			case 4:
				employeeservice.readData();
				break;

			case 5:
				System.out.println(" Exit...");
				return;
			default:
				System.out.println(" Invalid Choice!");
			}
			
		}


	}

	public static void addEmployee(Scanner sc,EmployeeService employeeservice) throws Exception {
		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Employee Name: ");
		String name = sc.nextLine();

		System.out.print("Enter City: ");
		String city = sc.nextLine();

		System.out.print("Enter Salary: ");
		int salary = sc.nextInt();
		employeeservice.insertData(id,name,city,salary);
		
	}
	
	public static void updateEmployee(Scanner sc,EmployeeService employeeservice) throws Exception {

	 System.out.print("Enter Empolyee ID to update: ");
       int id = sc.nextInt();
       sc.nextLine();
       
       System.out.print("Enter Employee Name: ");
		String name = sc.nextLine();

		System.out.print("Enter City: ");
		String city = sc.nextLine();

		System.out.print("Enter Salary: ");
		int salary = sc.nextInt();
		
		employeeservice.updateData(id,name,city,salary);

}
	public static void deleteEmployee(Scanner sc,EmployeeService employeeservice) throws Exception {
		System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        employeeservice.deleteData(id);
	}
}

   
    		   