<%-- 
    Document   : index
    Created on : Sep 29, 2013, 10:08:09 AM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:set var="user" value="${sessionScope.LOGIN}"/>
        <c:if test="${not empty user}">
            Welcome, <a href="User?Action=ViewProfile"> ${user.userName}</a>
        </c:if>
        <a href="Admin?Action=ListProduct">List Product</a>
        <a href="Admin?Action=ListUser">List User</a>
        <a href="Admin?Action=ListOrder">List Order</a>
        <a href="Admin?Action=ListCategory">List Category</a>
        <a href="Guest?Action=Register">Register</a>
        <a href="User?Action=Login">Login</a>



    </body>
</html>
