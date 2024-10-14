<%@page import="com.jsp.control.SellControl"%>
<%@page import="com.jsp.dto.StockEnt"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.control.StockControl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Records</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body style="background-color: #383636;">
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
 <br>
 <br>
 <br>
 
 <div class="box">
   <div style="background-color: #080808;"><h1 style="color:blue; text-shadow: 0px 0px 10px blue;"><i class="fa-solid fa-car-battery"></i><%=power %></h1></div>
   <div style="background-color: #080808;"><h1 style="color:orange; text-shadow: 0px 0px 10px orange;"><i class="fa-solid fa-oil-can"></i><%=diesel%></h1></div>
   <div style="background-color: #080808;"><h1 style="color:red; text-shadow: 0px 0px 10px red;"><i class="fa-solid fa-gas-pump"></i><%=petrol%></h1></div>
   <div style="background-color: #080808;"><h1 style="color:purple; text-shadow: 0px 0px 10px purple;"><i class="fa-solid fa-bottle-droplet"></i><%=mobil%></h1></div>
 
 </div>
 
 <br>
 <br>
 <br>
 
 
  <main>
    <section>
    <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>


	<table border="1" id="sells">
		<thead>
			<tr>
				<th>#ID</th>
				<th>Date</th>
				<th>Fuel Type</th>
				<th>Opening Stock</th>
				<th>Opening Value</th>
				<th>Purchase Quantity</th>
				<th>Purchase Rate</th>
				<th>Purchase Value</th>
				<th>Total Stock</th>
				<th>Total Value</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>
			<%StockControl scao = new StockControl();
			  List<StockEnt> list = scao.fetchAll();
			  for(StockEnt s:list)
			{%>
			<tr>
			
			    <td><%=s.getId()%></td>
				<td><%=s.getEntdate()%></td>
				<td><%=s.getFuelType()%></td>
				<td><%=s.getOpenstock()%></td>
				<td><%=s.getOpenvalue()%></td>
				<td><%=s.getPurchaseQty()%></td>
				<td><%=s.getPurchaseRate()%></td>
				<td><%=s.getPurchaseValue()%></td>
				<td><%=s.getTotalStock()%></td>
				<td><%=s.getTotalValue() %></td>
				<td><a href="UpdateStock.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-primary"><i class="fa-regular fa-pen-to-square"></i></a>
				<a href="deletes?id=<%=s.getId()%>" class="btn btn-sm btn-danger"><i class="fa-regular fa-square-minus"></i></a></td>
			
			</tr>
				
				
			<%}
			%>
		</tbody>
	</table>
    
    </section>
    
    </main>
    
    <br>
    <br>
    <br>
</body>
</html>