package emplyeeMgmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDbUtil {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
	
	 public static int save(Employee e){  
	        int status=0;  
	        try{  
	            Connection con=EmployeeDbUtil.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into employee(first_name,last_name,email,designation,dept_id,contact) values (?,?,?,?,?,?)");  
	            ps.setString(1,e.getFirstName());  
	            ps.setString(2,e.getLastName());  
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getDesignation()); 
	            ps.setString(5,e.getDeptId());
	            ps.setString(6,e.getContact());
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }
	 public static int update(Employee e){  
	        int status=0;  
	        try{  
	            Connection con=EmployeeDbUtil.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update employee set first_name=?,last_name=?,email=?,designation=?,dept_id=?,contact=? where id=?");  
	            ps.setString(1,e.getFirstName());  
	            ps.setString(2,e.getLastName());  
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getDesignation());  
	            ps.setString(5,e.getDeptId());  
	            ps.setString(6,e.getContact());
	            ps.setInt(7,e.getId());
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	 public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=EmployeeDbUtil.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from employee where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }
	 
	 public static Employee getEmployeeById(int id){  
	        Employee e=new Employee();  
	          
	        try{  
	            Connection con=EmployeeDbUtil.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from employee where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setFirstName(rs.getString(2));  
	                e.setLastName(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setDesignation(rs.getString(5));  
	                e.setDeptId(rs.getString(6)); 
	                e.setContact(rs.getString(7)); 
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }
	 
	 public static List<Employee> getAllEmployees(){  
	        List<Employee> list=new ArrayList<Employee>();  
	          
	        try{  
	            Connection con=EmployeeDbUtil.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from employee");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Employee e=new Employee();  
	                e.setId(rs.getInt(1));  
	                e.setFirstName(rs.getString(2));  
	                e.setLastName(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setDesignation(rs.getString(5));  
	                e.setDeptId(rs.getString(6)); 
	                e.setContact(rs.getString(7));   
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	
	
	
	
	
}
