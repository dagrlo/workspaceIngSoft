<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="es.uv.isw.app6.beans.Item" %>
<jsp:useBean id="orders" scope="session" class="es.uv.isw.app6.beans.ShoppingCart" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <style>
  <jsp:include page="/css/style.css" flush="true" />
  </style>
 <title>Final Shopping Cart</title>
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <br><br>
    <table class="body">
        <tr>
            <th class="body">Product</th>
            <th class="body">Quantity</th>
            <th class="body">Date</th>
        </tr>    
    <%
       	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy (HH:mm)");
        String p, d;
        int q;
                
        ArrayList<Item> orderList = orders.getOrders();
                
        for (Item order : orderList) {
            d = df.format(order.getDate());
            p = order.getProduct();
            q = order.getQuantity();
    %>        	
            <tr>
                <td class="body"><%= p %></td>
                <td class="body" align="right"><%= q %></td>
                <td class="body" align="center"><%= d %></td>
            </tr>
    <%  
        }
    %>  
    </table><br>
        <form action="OrderClose" method="get">
        <input type="submit" value="Close Shopping Cart"> <br>   
    </form>    	
</body>
</html>