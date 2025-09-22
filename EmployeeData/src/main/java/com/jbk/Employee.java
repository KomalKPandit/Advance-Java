package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class Employee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
           
            int id1 = Integer.parseInt(request.getParameter("empId1"));
            String fname = request.getParameter("firstName");
            String lname = request.getParameter("lastName");
            String email = request.getParameter("email");
            long phoneno = Long.parseLong(request.getParameter("mobile"));
            int age1 = Integer.parseInt(request.getParameter("age1"));
            String dob = request.getParameter("dob");  
            String salary = request.getParameter("salary");
            String exp = request.getParameter("experience");
            String add = request.getParameter("address");
            String gen = request.getParameter("gender");
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            String jobrole = request.getParameter("jobRole");

          
//            out.println("<h2>Employee Registration</h2>");
//            out.println("<h1>Employee ID: " + id1 + "</h1>");
//            out.println("<h1>First Name: " + fname + "</h1>");
//            out.println("<h1>Last Name: " + lname + "</h1>");
//            out.println("<h1>Email: " + email + "</h1>");
//            out.println("<h1>Mobile: " + phoneno + "</h1>");
//            out.println("<h1>Age: " + age1 + "</h1>");
//            out.println("<h1>Dob: " + dob + "</h1>");
//            out.println("<h1>Salary: " + salary + "</h1>");
//            out.println("<h1>Experience: " + exp + "</h1>");
//            out.println("<h1>Address: " + add + "</h1>");
//            out.println("<h1>Gender: " + gen + "</h1>");
//            out.println("<h1>State: " + state + "</h1>");
//            out.println("<h1>Country: " + country + "</h1>");
//            out.println("<h1>Job Role: " + jobrole + "</h1>");

            // --- 3. DB Connection ---
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/batch409", "root", "Komal@123");

            // --- 4. Insert into employee table ---
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO employee(empId, firstName, lastName, email, mobile, age, dob, salary, experience, address, gender, state, country, jobRole) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setInt(1, id1);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, email);
            ps.setLong(5, phoneno);
            ps.setInt(6, age1);
            ps.setString(7, dob);  // YYYY-MM-DD format
            ps.setBigDecimal(8, new java.math.BigDecimal(salary));
            ps.setString(9, exp);
            ps.setString(10, add);
            ps.setString(11, gen);
            ps.setString(12, state);
            ps.setString(13, country);
            ps.setString(14, jobrole);

            int check = ps.executeUpdate();

            if (check > 0) {
                out.println("<h1 style='color:green'>"+"Data is inserted..."+"</h1>");
            } else {
                out.println("<h1 style='color:red'>"+"Data is Not inserted..."+"</h1>");
            }

            c.close();

        } catch (Exception e) {
            out.println("<h2 style='color:red'>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace();
        }
    }
}
