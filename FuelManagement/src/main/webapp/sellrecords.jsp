<%@page import="com.jsp.control.StockControl"%>
<%@page import="com.jsp.dto.StockSellEnt"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.control.SellControl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell Records</title>
<%@include file="./component/allcss.jsp" %>
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

 <h2 style="text-align: center;text-decoration: underline; color:white;">Sold Records</h2>
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
   <table id="sells">
     <tr>
                <th>#ID</th>
				<th>Date</th>
				<th>Fuel Type</th>
				<th>Closing Stock</th>
				<th>Sell Rate</th>
				<th>Sell Quantity</th>
				<th>Total Value</th>
				<th>Total Stock</th>
				<th>Sell Value</th>
				<th>Profit & Loss</th>
				<th>Action</th>
				
				
     </tr>
     <% SellControl sxdao = new SellControl(); 
        List<StockSellEnt> list = sxdao.fetchAllSell();
        for(StockSellEnt s:list)
        {%>
        	<tr>
        	  <td><%=s.getId() %></td>
        	  <td><%=s.getDate() %></td>
        	  <td><%=s.getFuelType() %></td>
        	  <td><%=s.getClosingStock() %></td>
        	  <td><%=s.getSellRate() %></td>
        	  <td><%=s.getSellQty() %></td>
        	  <td><%=s.getTotalValue() %></td>
        	  <td><%=s.getTotalstock() %></td>
        	  <td><%=s.getSellvalue() %></td>
        	  <td id="pl"><%=s.getpAndl() %></td>
        	  <%-- <td><a href="updatesell.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-primary"><i class="fa-regular fa-pen-to-square"></i></a>
				<a href="deletesell?id=<%=s.getId()%>" class="btn btn-sm btn-danger"><i class="fa-regular fa-square-minus"></i></a></td>  --%>
        	  <td>
				<a href="deletesell?id=<%=s.getId()%>" class="btn btn-sm btn-danger"><i class="fa-regular fa-square-minus"></i></a></td> 
        	
        	</tr>
        <%}
      %>
     
    
   
   </table>
    
    </section>
  
  </main>
    
	
	
	<br>
	<br>
	<br>
	
	<script>
        let v = document.querySelectorAll("#pl")
        console.log(typeof(v))

        console.log(Array.isArray(v))
        
        let pure = Array.from(v);
        console.log(Array.isArray(pure))

        pure.forEach((elem)=>{
            if(elem.innerText>=0){
                elem.style.color="#53b7e6"
            }else{
                elem.style.color="red"
            }
            
        })
        
        

    </script>

</body>

</body>
</html>