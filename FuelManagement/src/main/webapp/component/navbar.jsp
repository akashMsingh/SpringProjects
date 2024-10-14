<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark  bg-body-tertiary nevi">
  <div class="container-fluid">
    <a class="navbar-brand" href="home.jsp">Fuel Managment System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
       
        
        
        
        
        
        
        
        
        <c:if test="${empty userObj}">
			<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Sign Up/Login
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="userlogin.jsp">Login</a></li>
            <li><a class="dropdown-item" href="createuser.jsp">Sign up</a></li>
            
          </ul>
        </li>
		</c:if>
		
		<c:if test="${not empty userObj}">
		<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Action
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="petrolentry.jsp">Enter Stock</a></li>
            <li><a class="dropdown-item" href="petrolsell.jsp">Sell Stock</a></li>
            
          </ul>
        </li>
        
			<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle active bg-danger" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" >
          <i class="fa-solid fa-user"></i>  ${userObj.fullname}
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="allstock.jsp">View Stock Entries</a></li>
            <li><a class="dropdown-item" href="sellrecords.jsp">View Sold History</a></li>
            <li><a class="dropdown-item" href="editprofile.jsp">Edit Profile</a></li>
            
            <li><a class="dropdown-item" href="logoutuser">logout</a></li>
            
           
            
          </ul>
        </li>
		</c:if>
        
        
        
      </ul>
      
    </div>
  </div>
</nav>