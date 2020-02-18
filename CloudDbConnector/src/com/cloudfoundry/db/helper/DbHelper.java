package com.cloudfoundry.db.helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DbHelper
 */
@WebServlet("/dbhelper")
public class DbHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbHelper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fbDb(request, response);
	}

	private void fbDb(HttpServletRequest request, HttpServletResponse response) {
		
		ResultSet rs = null;
		
		
    	try {
			
    		System.out.println("Connecting to Db");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager
					.getConnection(
							"jdbc:mysql://172.30.48.26:3306/df63c0488a60c46d8817afac390acc050",
							"uE0OMNtjUHgaK", "pSvXh7UlGLADG");
			System.out.println("Connection done");
		
			Statement st = con.createStatement();
			
			System.out.println("Query Received: " + request.getParameter("queryTxt"));
			
			rs = st.executeQuery(request.getParameter("queryTxt"));
			
			request.getSession().setAttribute("resultset", rs);
			
			System.out.println("Query Executed");
			
			getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		fbDb(request, response);
	}

}
