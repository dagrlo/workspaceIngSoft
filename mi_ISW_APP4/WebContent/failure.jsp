<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="mailingbean" scope="request" class="es.uv.isw.app4.beans.MailingBeanImpl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscription Results</title>
</head>
<body>
   <br><br>
   Dear <jsp:getProperty name="mailingbean" property="first"/>,
   <br><br>
   We're sorry, the address <jsp:getProperty name="mailingbean" property="email"/>
   could no be added to the list.
   <br><br>
   The problem was: <jsp:getProperty name="mailingbean" property="errorString"/>.
</body>
</html>