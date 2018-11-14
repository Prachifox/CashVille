<!DOCTYPE html>
<%@page import="com.tcsion.FrontEnd.GetData" %>
 <%@ page import="java.util.List" %>
 <%@page import="java.util.Iterator"%>
<html>
  <head>
   <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!-- Import Google Icon Font -->
    <link
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet"
    />
    <!-- Import materialize.css -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
    />

    <link rel="stylesheet" href="css/main.css" />

    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
      integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
      crossorigin="anonymous"
    />
    
    <style type="text/css">
    .section-follow .fa-4x {
  margin: 10px 20px;
}
    
    </style>
    
    
    <title>CashVille</title>
    <!-- Let browser know website is optimized for mobile -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  </head>

  <body>
    <!-- Navbar -->
  
    <div class="navbar-fixed">
      <nav class=" grey darken-3">
      <div class="container"></div>
          <div class="nav-wrapper">
            <a href="#" class="brand-logo">CashVille</a>
            <a href="#" class="sidenav-trigger show-on-large right" data-target="mobile-nav">
              <i class="material-icons">menu</i>
            </a>
           
            <ul class="right hide-on-med-and-down ">
            <li><a href="home_add.jsp">Available Products</a></li>
            <li><a href="add.html">Add Product</a></li>
      <li><a href="change.html">Update Product Details</a></li>
      <li><a href="delete.html">Delete Product</a></li>
      <li><a href="getFeedback.jsp">Costumer Feedbacks</a></li>
      <li><a href="reset_pass.html">Change Password</a></li>
        <li><a href="index.html">Logout</a></li>
           
            </ul>
              
        </div>
        </div>
      </nav>
    </div>
    
  

    <ul class="sidenav grey lighten-2" id="mobile-nav">
 <li>   <div class="user-view">
    <div class=" background grey darken-3"></div>
      <a href="#">
          <img src="images/person3.jpg" alt="" class="circle">
        </a>
        <a href="#" class="name white-text">
          Pika
        </a>
        <a href="#" class="email white-text">
         pandeyprachi067@gmail.com
        </a>
    </div></li>
     <li><a href="home_add.jsp">Available Products</a></li>
      <li><a href="add.html">Add Product</a></li>
      <li><a href="change.html">Update Product Details</a></li>
      <li><a href="delete.html">Delete Product</a></li>
       <li><a href="getFeedback.jsp">Costumer Feedbacks</a></li>
      <li><a href="reset_pass.html">Change Password</a></li>
        <li><a href="index.html">Logout</a></li>    
    </ul>

 <h4 class="center">
                <span class="grey-text">Customer</span>Feedbacks
              </h4>
              <br>
              
       <div class='row'>          

<%
GetData gd=new GetData();

List<String>  l4=gd.getFeedback();
Iterator<String> aIterator = l4.iterator();

int x=0;
while(aIterator.hasNext())
{
	
	   String i = aIterator.next();
out.println("<div class='col s12 m4'><div class='card small teal lighten-3'><div class='card-content'><center><i class='material-icons large'>people</i><center><br>"+i+"</div></div></div>");

		    ++x;
	    if(x%3==0)
	    {
	    	out.println("</div><div class='row'>");	
	    }
}
 %>


<footer>
<div class="container">
<center>
<p class="flow-text black-text">CashVille &copy; 2018
</p>
</center>
</div>
 </footer>  
            
         

    <!-- JavaScript at end of body for optimized loading -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
   
 

   
    <script>
      const sideNav = document.querySelector('.sidenav');
      M.Sidenav.init(sideNav, {});

      //slider
      const slider = document.querySelector('.slider');
      M.Slider.init(slider, {
        indicators: false,
        height: 600,
        transition: 500,
        interval: 5000
      });

      //autocomplete
      const autocomplete = document.querySelector('.autocomplete');
      M.Autocomplete.init(autocomplete, {
        data: {
          Gambia: null,
          Kenya: null,
          Tanzania: null,
          Antarctica: null,
          Aruta: null,
          Florida: null,
          California: null,
          Europe: null
        }
      });
    </script>
  </body>
</html>