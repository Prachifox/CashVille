<!DOCTYPE html>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
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
            <a href="#" class="sidenav-trigger" data-target="mobile-nav">
              <i class="material-icons">menu</i>
            </a>
           
            <ul class="right hide-on-med-and-down ">
           
                <li><a href="home_cus.html">Available Products</a></li>
      <li><a href="placeorder.html">Place Order</a></li>
       <li><a href="feedback.html">Feedbacks</a></li>
      <li><a href="reset_pass_1.html">Reset Password</a></li>
        <li><a href="index.html">Logout</a></li>
           
            </ul>
              
        </div>
        </div>
      </nav>
    </div>


    <ul class="sidenav" id="mobile-nav">
    
                <li><a href="home_cus.html">Available Products</a></li>
      <li><a href="placeorder.html">Place Order</a></li>
       <li><a href="feedback.html">Feedbacks</a></li>
      <li><a href="reset_pass_1.html">Reset Password</a></li>
        <li><a href="index.html">Logout</a></li>
    </ul>
    
   
     
      <div class="row grey lighten-4">
      <div class="col s12 m6 offset-m3">
           <div class="card blue-grey lighten-4">
          <div class="card-image">
            <img src="images/cart1.jpg">
            <span class="card-title">Happy Shopping</span>
          </div>
        </div>
      </div>
      </div>
      
   <section>
     <div class="row">
 <div class="col s12 m8 offset-m2">
        <!-- SIMPLE CARD WITHOUT TITLE -->
        <div class="card">
          <div class="card-content">
           <span class="card-title z-depth-4"><center><h1>Order Details</h1><center></span>
 <table class="striped"><tbody>
 <tr><th>Product Name </th><th><%=request.getParameter("ProductItem") %></th></tr>
 <tr><th>Quantity</th><th><%=request.getParameter("Quantity") %></th></tr>
 <tr><th>Total Cost</th><th><%=request.getAttribute("cost") %></th></tr>
<tr><th>Contact No.</th><th><%= request.getParameter("no") %></th></tr>
<tr><th>Email</th><th><%= request.getParameter("email") %></th></tr>
<tr><th>Delivery Address</th><th><%= request.getParameter("d_add") %></th></tr>
<tr><th>Date and Time :</th><th><% SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	out.println(formatter.format(date)); %></th></tr>
</tbody>
</table>
          </div>
</div>
</div>
</div>
</section>

<footer>
<section>
<center>
<p class="flow-text black-text">CashVille &copy; 2018
</p>
</center>
</section>
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
