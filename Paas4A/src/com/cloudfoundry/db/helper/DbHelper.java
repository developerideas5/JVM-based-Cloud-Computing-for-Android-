package com.cloudfoundry.db.helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jvm.cloud.util.DbConstant;

/**
 * Servlet implementation class DbHelper
 */
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
		
		dbHelper(request, response);
	}

	private void dbHelper(HttpServletRequest request, HttpServletResponse response) {
		
		ResultSet rs = null;
		
    	try {
			
    		System.out.println("Connecting to Db1");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(DbConstant.url, DbConstant.username, DbConstant.password);
			
			System.out.println("Connection done");
		
			Statement st = con.createStatement();
			
			System.out.println("Query Received: " + request.getParameter("queryTxt"));
			
			String sql = request.getParameter("queryTxt");
			
			if(sql.indexOf("select") != -1) {
			rs = st.executeQuery(sql);
			} else {
				st.executeUpdate(sql);	
			}
			request.getSession().setAttribute("resultset", rs);
			
			System.out.println("Resultset found");
			
			getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbHelper(request, response);
	}
}
