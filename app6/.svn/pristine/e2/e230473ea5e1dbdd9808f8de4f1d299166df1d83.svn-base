<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="item" scope="request" class="es.uv.isw.app6.beans.Item" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <style>
  <jsp:include page="/css/style.css" flush="true" />
  </style>
  <title>New Item Added</title>
</head>
<body>
    <br>
    A new item has been added to your orders list on <jsp:getProperty name="item" property="date"/>:<br><br>
    Product: <jsp:getProperty name="item" property="product"/><br>
    Quantity: <jsp:getProperty name="item" property="quantity"/><br><br>
    Thank you!<br><br>
    <form action="OrderSelect" method="get">
        <input type="submit" name="action" value="Add a new Item"> <br>
        <input type="submit" name="action" value="Finish"><br>   
    </form>
</body>
</html>