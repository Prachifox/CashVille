package com.tcsion.FrontEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class se_use extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public se_use() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname=request.getParameter("ProductItem");
		Integer quantity=Integer.parseInt(request.getParameter("Quantity"));
		GetData gd=new GetData();
		Integer qua=gd.getquantity(pname);
		Long id=gd.get_id(pname);
		Float price=gd.getprice(pname);
		
		if(qua==0)

		{
			JOptionPane.showMessageDialog(null," The product does not exists ");	
			RequestDispatcher rd=request.getRequestDispatcher("placeorder.html");
			rd.forward(request,response);
		}
		
		else if(qua<quantity)
		{
			JOptionPane.showMessageDialog(null," The product exists but its available quantity is less than your requirement");	
			RequestDispatcher rd=request.getRequestDispatcher("placeorder.html");
			rd.forward(request,response);
		}
		else
		{
			JOptionPane.showMessageDialog(null," your order has been sucessfully placed");	
			gd.updateproduct(id, qua-quantity, price);
			RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
			rd.include(request,response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
