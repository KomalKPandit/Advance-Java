package com.jbk;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")

public class Employee extends HttpServlet {
	
	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("empId1");
		int id1 = Integer.parseInt(id);
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mob = request.getParameter("mobile");
		long phoneno = Long.parseLong(mob);
		String age = request.getParameter("age1");
		int age1 = Integer.parseInt(age);
//		String dob = request.getParameter("dob1");
//		int dob1 = Integer.parseInt(dob);
		String salary = request.getParameter("salary");
		String exp = request.getParameter("experience");
		String add = request.getParameter("address");
		String gen = request.getParameter("gender");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String jobrole = request.getParameter("jobRole");
		
		
		System.out.println(id1);  
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(email);
		System.out.println(mob );
		System.out.println(age1);
//		System.out.println(dob1);
		System.out.println(salary);
		System.out.println(exp);
		System.out.println(add);
		System.out.println( gen);
		System.out.println(state);
		System.out.println(country);
		System.out.println(jobrole);
}
}