package com.servlet.operation.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import com.servlet.operation.been.EncapsulateInsertion;
import com.servlet.operation.dao.QueryOperation;

/**
 * Servlet implementation class ServletFetching
 */
@WebServlet("/ServletFetching")
public class ServletFetching extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFetching() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try 
        {	
        	PrintWriter pw = response.getWriter();
        	List<EncapsulateInsertion> li =QueryOperation.DataFetch();
            pw.write("<!DOCTYPE html>\r\n"
                    + "<html>\r\n"
                    + "<head>\r\n"
                    + "    <meta charset=\"UTF-8\">\r\n"
                    + "    <title>Data Table</title>\r\n"
                    + "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/table.css\">\r\n"
                    + "</head>\r\n"
                    + "<body>\r\n"
                    + "    <div class=\"container\">\r\n"
                    + "        <h1>Student Data</h1>\r\n"
                    + "        <table>\r\n"
                    + "            <thead>\r\n"
                    + "                <tr>\r\n"
                    + "                    <th>ID</th>\r\n"
                    + "                    <th>Name</th>\r\n"
                    + "                    <th>Email</th>\r\n"
                    + "                    <th>Password</th>\r\n"
                    + "                </tr>\r\n"
                    + "            </thead>\r\n"
                    + "            <tbody>");
            
        
            for(EncapsulateInsertion en:li)
            {
            	 pw.write("<tr>\r\n"
                         + "    <td>" + en.getId()+ "</td>\r\n"
                         + "    <td>" + en.getName() + "</td>\r\n"
                         + "    <td>" +  en.getEmail() + "</td>\r\n"
                         + "    <td>" +  en.getPassword()+ "</td>\r\n"
                         + "</tr>");
            }

            pw.write("        </tbody>\r\n"
                    + "        </table>\r\n"
                    + "    </div>\r\n"
                    + "</body>\r\n"
                    + "</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
