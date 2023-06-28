package home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addtocart
 */
@WebServlet("/Addtocart")
public class Addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =request.getParameter("id");	
		
		
		

		String driver = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String database = "db";
		String userid = "root";
		String password = "root";
		try {
		Class.forName(driver);
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
String proid=null;
String pname=null;
String pimage=null;
String prate=null;

		try{
		connection = DriverManager.getConnection(connectionUrl+database, userid, password);
		statement=connection.createStatement();
		String sql ="select * from product where id="+id;
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		int pid1=resultSet.getInt("id");
		proid= resultSet.getString("id");
		pname= resultSet.getString("name");
		  pimage=resultSet.getString("imagename");
		 prate=resultSet.getString("rate");
		}
			System.out.print(pname);
			System.out.print(pimage);
		
			
			String sql1 ="select * from addtocart where pid="+id;
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				System.out.print("*********************************************");
				int qty=resultSet.getInt("qty");
				qty++;
				PreparedStatement stmt;
				String query="update addtocart set qty = ? where pid=?";
				stmt=connection.prepareStatement(query);
				stmt.setInt(1,qty);
				
				stmt.setString(2,proid);
				
				int row=stmt.executeUpdate(); // it returns no of rows affected.
				
				if(row>0) {
					
					 request.setAttribute("message", "Image added into database successfully.");

					 // response.sendRedirect("Home.jsp");
						request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
				
			}
			else {
				
				System.out.print("********************%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*************************");
			
			PreparedStatement stmt;
			String query="insert into  addtocart(pid,qty) values(?,?)";
			stmt=connection.prepareStatement(query);
			stmt.setString(1,proid);
			
			stmt.setInt(2,1);
			int row=stmt.executeUpdate(); // it returns no of rows affected.
			
			if(row>0)
			{response.getWriter().append("Served at: "+pimage+"\n"+row);	
				
				 request.setAttribute("message", "Image added into database successfully.");

				 // response.sendRedirect("Home.jsp");
					request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
			
			else
			{
				System.out.println("Failed to upload image.");
			}
			
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();	
			}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
