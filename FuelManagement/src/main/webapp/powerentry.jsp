<%@page import="com.jsp.control.SellControl"%>
<%@page import="com.jsp.control.StockControl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./component/allcss.jsp"%>
<meta charset="ISO-8859-1">
<title>Power Stock Entry</title>
</head>
<body>
<%@include file="./component/navbar.jsp"%>
<c:if test="${empty userObj}">
	   <c:redirect url="userlogin.jsp"></c:redirect>
	</c:if>
<br>
<br>
<br>
<%StockControl ssdao = new StockControl();
  SellControl sdao = new SellControl();
  double petrol = ssdao.getTotalPetrolStock() - sdao.gettotalSoldPetrol();
  double power = ssdao.getTotalPowerStock() - sdao.gettotalSoldPower();
  double mobil = ssdao.getTotalMobilStock() - sdao.gettotalSoldMobil();
  double diesel = ssdao.getTotalDieselSTock() - sdao.gettotalSoldDiesel();
%>
<div class="mainform">
  
    <section>
      <form action="Enterthestock" method="post">
      <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
		<table>
		<div class="dropdown">
						<button class="btn  dropdown-toggle btn-success" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">Select
							Fueltype</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="petrolentry.jsp">Petrol</a></li>
                            <li><a class="dropdown-item" href="mobilentry.jsp">Mobil</a></li>
                            <li><a class="dropdown-item" href="powerentry.jsp">Power</a></li>
                            <li><a class="dropdown-item" href="dieselentry.jsp">Diesel</a></li>
						</ul>
					</div>
		  <tr>
		  <td>Date: </td>
		  <td><input type="date" placeholder="Enter the date" name="date" required></td>
		  </tr>
		  
		  <tr>
		  <td>FuelType: </td>
		  <td><input type="text" value= "Power" name="fueltype" readonly  required></td>
		  </tr>
		  
		  <tr>
		  <td>Opening Stock: </td>
		  <td><input type="text" placeholder="opening stock" name="openingstock" required value="<%=power %>" readonly></td>
		  </tr>
		  
		  
		  
		  <tr>
		  <td>Purchase Quantity: </td>
		  <td><input type="number" placeholder="Purchase quantity" name="purchaseqty" required></td>
		  </tr>
		  
		  <tr>
		  <td>Purchase Rate: </td>
		  <td> <input type="number" placeholder="Purchase Rate" name="purchaserate" required></td>
		  </tr>
		  
		  <tr>
		  <td>Total Stock: </td>
		  <td><input type="text" placeholder="Total Stock" name="totalstock" value="<%=power %>" readonly></td>
		  </tr>
		  
		  
		  
		  
		  
		  <tr>
		   <td colspan="2"><button>submit</button></td>
		   
		  </tr>
		
		</table>

		    
			
			
		
	</form>
    
    </section>
  
  </div>
	<br>
<br>
<br>

</body>
</html>