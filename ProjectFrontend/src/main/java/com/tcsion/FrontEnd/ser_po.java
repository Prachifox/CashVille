package com.tcsion.FrontEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class ser_po extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ser_po() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname=request.getParameter("ProductItem");
		Integer punit=Integer.parseInt(request.getParameter("Quantity"));
		Integer pprice=Integer.parseInt(request.getParameter("price"));
		String link=request.getParameter("link");
GetData gd=new GetData();
Long id=gd.get_id(pname);
if(id!=-1)
{

		
JOptionPane.showMessageDialog(null,"Product already exists...you can update its information.");
	RequestDispatcher rd=request.getRequestDispatcher("add.html");
	rd.forward(request,response);
	}

else 
{
	gd.addProduct(pname, punit, pprice,link);
	JOptionPane.showMessageDialog(null,"Product has been successfully added");
	RequestDispatcher rd=request.getRequestDispatcher("add.html");
	rd.forward(request,response);
}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request,response);
	}

}
