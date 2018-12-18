<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html>  
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
    <title>Admin page</title>  
</head>  
<body>  
    Dear <strong>${user}</strong>, Welcome to Admin Page. 
    <form action="logout" method="post">
    	<input type="submit" value="Logout"/>
    	<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />  
    </form> 
</body>  
</html>