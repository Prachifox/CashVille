package com.tcsion.FrontEnd;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class placeo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public placeo() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pname=request.getParameter("ProductItem");
		Integer quantity=Integer.parseInt(request.getParameter("Quantity"));
		Long contact=Long.parseLong(request.getParameter("no"));
		String email=request.getParameter("email");
		String d_add=request.getParameter("d_add");

	
		
		GetData gd=new GetData();
		Integer qua=gd.getquantity(pname);
		Long id=gd.get_id(pname);
		Float price=gd.getprice(pname);
		Float p=price*quantity;
		
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
			JOptionPane.showMessageDialog(null,"Order Placed . A confirmation mail will be sent shortly.Redirecting to bill details");	
			gd.updateproduct(id, qua-quantity, price);
			
			 try{
		            String host ="smtp.gmail.com" ;
		            String user = "7.CashVille@gmail.com";
		            String pass = "javaproject@123";
		            String to = email;
		            String from = "7.CashVille@gmail.com";
		            String subject = "Order Details At CashVille";
		            String messageText = "Sir/Ma,am,\nYour Order has been successfully placed .It will be delivered within a week."
		            		+ "\nORDER DETAILS :\n"
		            		+ "Product                :"+pname+",\nQuantity              :"+quantity+",\nTotal cost                 :"+p+",\nYour Contact No :"+contact+
		            		",\nEmail Address    :"+email+",\nDelivery Address:"+d_add;
		            boolean sessionDebug = false;

		            Properties props = System.getProperties();

		            props.put("mail.smtp.starttls.enable", "true");
		            props.put("mail.smtp.host", host);
		            props.put("mail.smtp.port", "587");
		            props.put("mail.smtp.auth", "true");
		            props.put("mail.smtp.starttls.required", "true");

		            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		            Session mailSession = Session.getDefaultInstance(props, null);
		            mailSession.setDebug(sessionDebug);
		            Message msg = new MimeMessage(mailSession);
		            msg.setFrom(new InternetAddress(from));
		            InternetAddress[] address = {new InternetAddress(to)};
		            msg.setRecipients(Message.RecipientType.TO, address);
		            msg.setSubject(subject); msg.setSentDate(new Date());
		            msg.setText(messageText);

		           Transport transport=mailSession.getTransport("smtp");
		           transport.connect(host, user, pass);
		           transport.sendMessage(msg, msg.getAllRecipients());
		           transport.close();
		           System.out.println("message send successfully");
		           
		        }catch(Exception ex)
		        {
		            System.out.println(ex);
		        }
         request.setAttribute("cost", p);
			RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
			rd.include(request,response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
