package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Userdb
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Userdb" })
  
public class Userdb extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
/*String n=request.getParameter("userName");  
String p=request.getParameter("userPass");  
String e=request.getParameter("userEmail");  
  */        
try{  
	Class.forName("com.mysql.cj.jdbc.Driver");
	//Class.forName("com.mysql.jdbc.Driver");
    String url ="jdbc:mysql://localhost:3307/java5";
Connection con=DriverManager.getConnection(url,"root","root");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into userinfo(name,email,pass) values(?,?,?)");  
  
ps.setString(1,"hanu");  
ps.setString(2,"hanu@gmail.com");  
ps.setString(3,"1111");  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
out.print("You are not successfully registered...");  
      
          
}catch (Exception e2) {System.out.println("exxx"+e2);}  
          
out.close();  
}  
  
}  