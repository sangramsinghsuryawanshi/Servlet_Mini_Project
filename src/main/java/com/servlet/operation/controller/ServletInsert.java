package com.servlet.operation.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.operation.been.EncapsulateInsertion;
import com.servlet.operation.dao.QueryOperation;

/**
 * Servlet implementation class ServletOperation
 */
@WebServlet("/ServletInsert")
public class ServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		EncapsulateInsertion ei = new EncapsulateInsertion();
		ei.setId(id);
		ei.setName(name);
		ei.setEmail(email);
		ei.setPassword(password);
		int status = QueryOperation.isInsert(ei);
		if (status != 0) 
		{
			pw.print("<script>alert('inserted successfully!!');window.location.replace('operation.html');</script>");
		} 
		else 
		{
			pw.print("<script>alert('inserted Unsuccessfull!!');window.location.replace('operation.html');</script>");
	    }
		
	}

}
