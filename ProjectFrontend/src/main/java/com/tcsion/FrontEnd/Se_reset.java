package com.tcsion.FrontEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class Se_reset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Se_reset() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String old=request.getParameter("uname");
		String newpass=request.getParameter("pass");
		String confirm=request.getParameter("age");
	
		  GetData gd=new GetData();
		  String adminname=gd.getadminname();
		  String adminpass=gd.getadminpass();
		 // System.out.print(adminname);
		  //System.out.print(adminpass);
		if(!newpass.equals(confirm))  
		{JOptionPane.showMessageDialog(null,"values of new password do not match");	
		}
		else if(!old.equals(adminpass))
		
		{
			JOptionPane.showMessageDialog(null,"old password incorrect");	
	}
			else
			{   
				gd.update_admin(confirm,old);
				JOptionPane.showMessageDialog(null,"password sucessfully reset");
			}
		RequestDispatcher rd=request.getRequestDispatcher("reset_pass.html");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
