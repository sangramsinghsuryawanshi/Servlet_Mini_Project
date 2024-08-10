package com.servlet.operation.controller;


import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.operation.been.EncapsulateInsertion;
import com.servlet.operation.dao.QueryOperation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDelete
 */
@WebServlet("/ServletDelete")
public class ServletDelete extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDelete() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		EncapsulateInsertion ei = new EncapsulateInsertion();
		ei.setId(id);
		int status = QueryOperation.isDelete(ei);
		if (status != 0) 
		{
			pw.print("<script>alert('Deleted successfully!!');window.location.replace('operation.html');</script>");
		} 
		else 
		{
			pw.print("<script>alert('Deleted Unsuccessfull!!');window.location.replace('operation.html');</script>");
	    }
	}

}
