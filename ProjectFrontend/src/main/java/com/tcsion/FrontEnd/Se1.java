package com.tcsion.FrontEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tcsion.java.Project1Backend.dao.UserDao;
import com.tcsion.java.Project1Backend.daoimpl.UserDaoImpl;


public class Se1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Se1() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("hello");
		String uname= request.getParameter("username");
		  String pass= request.getParameter("pass");
		  GetData gd=new GetData();
		  String adminname=gd.getadminname();
		  String adminpass=gd.getadminpass();				  
		  if(uname.equalsIgnoreCase(adminname)&& pass.equals(adminpass))
		  {
			  
				 RequestDispatcher rd=request.getRequestDispatcher("home_add.jsp");
				 rd.forward(request, response);	 
		  }
		  else
		  {
		 
		 Boolean b= gd.valid(uname,pass);
		
		 if(b)
		 {
				 RequestDispatcher rd=request.getRequestDispatcher("home_cus.jsp");
				 rd.forward(request, response);	 
		 }
		 
		
			
		 else
		 {
			 JOptionPane.showMessageDialog(null,"invalid username or password");
			 RequestDispatcher rd=request.getRequestDispatcher("index.html");
			 rd.forward(request, response);	
			
		 }
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
