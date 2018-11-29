package com.tcsion.FrontEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class Se_change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Se_change() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname=request.getParameter("ProductItem");
		Integer punit=Integer.parseInt(request.getParameter("Quantity"));
		Float pprice=Float.parseFloat(request.getParameter("price"));
GetData gd=new GetData();
Long id=gd.get_id(pname);

if(id==-1)
{
	
	JOptionPane.showMessageDialog(null,"OOPS! The product does not exists ");	
	return;
}
gd.updateproduct(id, punit, pprice);
		
JOptionPane.showMessageDialog(null,"Product has been successfully updated");
		
	RequestDispatcher rd=request.getRequestDispatcher("home_add.jsp");
	rd.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
