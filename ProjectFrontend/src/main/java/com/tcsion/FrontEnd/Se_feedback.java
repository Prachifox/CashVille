package com.tcsion.FrontEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class Se_feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Se_feedback() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String uname= request.getParameter("name");
		  String email= request.getParameter("email");
		  Long contact= Long.parseLong(request.getParameter("no"));
		  String feedback= request.getParameter("feedback");
		
		  GetData gd=new GetData();
		  gd.addFeedback(uname,email,contact,feedback);
		  JOptionPane.showMessageDialog(null,"Feedback successfully added");	
		  RequestDispatcher rd=request.getRequestDispatcher("feedback.html");
			rd.forward(request, response);
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
