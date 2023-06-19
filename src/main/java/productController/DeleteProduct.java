package productController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int  id=Integer.parseInt(request.getParameter("id"));
		
		Connection connection=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			PreparedStatement stmt;
			String query= "DELETE FROM product WHERE id = ?";
			stmt=connection.prepareStatement(query);
			stmt.setInt(1,id);
			
			int row=stmt.executeUpdate(); // it returns no of rows affected.
			
			if(row>0)
			{
				System.out.println("Image added into database successfully.");
				 request.setAttribute("message", "Image added into database successfully.");

	              // forwards to the message page
	              getServletContext().getRequestDispatcher("/index.jsp")
	                  .include(request, response);
			}
			
			else
			{
				System.out.println("Failed to upload image.");
			}
			
			
		}
		catch (Exception e)
		{
			System.out.println("exc"+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	String  id=request.getParameter("id");
		response.getWriter().append(id).append(request.getContextPath());*/
	}

}
