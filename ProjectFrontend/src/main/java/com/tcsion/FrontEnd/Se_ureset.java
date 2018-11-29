package com.tcsion.FrontEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class Se_ureset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Se_ureset() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String old=request.getParameter("uname");
		String newpass=request.getParameter("pass");
		String confirm=request.getParameter("age");
		String username=request.getParameter("uname1");
		GetData gd=new GetData();
		
		if(!newpass.equals(confirm))  
		{JOptionPane.showMessageDialog(null,"values of new password do not match");	
		RequestDispatcher rd=request.getRequestDispatcher("reset_pass_1.html");
		rd.forward(request, response);
		}
			else if(gd.valid(username, old))
			{
			System.out.println("changing customer password");
		        gd.update_admin(confirm,old);
		       
				JOptionPane.showMessageDialog(null,"password sucessfully reset");
				RequestDispatcher rd=request.getRequestDispatcher("reset_pass_1.html");
				rd.forward(request, response);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"old password incorrect");
				RequestDispatcher rd=request.getRequestDispatcher("reset_pass_1.html");
				rd.forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
