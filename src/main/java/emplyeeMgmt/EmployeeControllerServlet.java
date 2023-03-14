package emplyeeMgmt;
import java.io.IOException;
import java.util.List;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet implementation class EmployeeControllerServlet
 */
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listEmployees(request, response);
				break;
				
			case "ADD":
				addEmployee(request, response);
				break;
				
			case "LOAD":
				loadEmployee(request, response);
				break;
				
			case "UPDATE":
				updateEmployee(request, response);
				break;
			
			case "DELETE":
				deleteEmployee(request, response);
				break;
				
			default:
				listEmployees(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// delete student from database
		EmployeeDbUtil.delete(Integer.parseInt(theStudentId));
		
		// send them back to "list students" page
		listEmployees(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String designation = request.getParameter("designation");
		String contact = request.getParameter("contact");
		String deptId = request.getParameter("deptid");
		
		// create a new student object
		Employee theStudent = new Employee(id, firstName, lastName, email, designation,deptId, contact);
		
		// perform update on database
		EmployeeDbUtil.update(theStudent);
		
		// send them back to the "list students" page
		listEmployees(request, response);
		
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// get student from database (db util)
		Employee employee = EmployeeDbUtil.getEmployeeById(Integer.parseInt(theStudentId));
		//Student theStudent = studentDbUtil.getStudent(theStudentId);
		
		// place student in the request attribute
		request.setAttribute("THE_STUDENT", employee);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/UpdateEmployeeForm.jsp");
		dispatcher.forward(request, response);		
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String designation = request.getParameter("designation");
		String contact = request.getParameter("contact");
		String deptId = request.getParameter("deptid");
		
		// create a new student object
		Employee employee = new Employee(firstName, lastName, email, designation, deptId, contact);
		
		
		// add the student to the database
		EmployeeDbUtil.save(employee);
				
		// send back to main page (the student list)
		listEmployees(request, response);
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Employee> employees = EmployeeDbUtil.getAllEmployees();
		
		// add students to the request
		request.setAttribute("STUDENT_LIST", employees);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListEmployee.jsp");
		dispatcher.forward(request, response);
	}

	
	

}
