package com.tcsion.FrontEnd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class Se extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Se() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	  String uname= request.getParameter("uname");
	  String pass= request.getParameter("pass");
	  Integer age= Integer.parseInt(request.getParameter("age"));
	  String contact= request.getParameter("contact");
	  String role= request.getParameter("role");
		GetData gd=new GetData();
		
		
		Long i=gd.get_id_user(uname);
		if(i==-1)
		{
		gd.addUser(uname, pass,age,contact,role);
		JOptionPane.showMessageDialog(null," account successfully created ");	
		
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Username already taken ");	
		}
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
