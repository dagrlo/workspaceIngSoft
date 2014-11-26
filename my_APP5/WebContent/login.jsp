<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="userbean" scope="session" class="es.uv.isw.app5.beans.UserBeanImpl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
   <form action="pages/workflow" method="get">
      Username: <input type="text" name="username" value=<jsp:getProperty name="userbean" property="username"/>>
      <br>
      Password: <input type="text" name="password">
      <br>
      <input type="submit" value="Log In"/>
   </form>
</body>
</html>
