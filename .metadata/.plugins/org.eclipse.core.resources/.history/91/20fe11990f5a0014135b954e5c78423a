<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mailingbean" scope="request" class="es.uv.isw.app1.beans.MailingBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscription Results</title>
</head>
<body>
<br/><br/>
	Dear <jsp:getProperty property="first" name="mailingbean"/>,
	<br/><br/>
	We're sorry, the address <jsp:getProperty property="email" name="mailingbean"/> 
	could not be added to the list.<br/><br/>
	The problem was: <jsp:getProperty property="errorString" name="mailingbean"/>.
</body>
</html>