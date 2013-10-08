<%-- 
    Document   : Reset
    Created on : Oct 8, 2013, 7:28:57 PM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fastfood.common.constants.FastFoodContants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <c:set var="msg" value="${sessionScope.MSG}"/>
        <c:if test="${not empty msg}">
            <h3>${msg}</h3>
        </c:if>
        <form action="User?Action=Reset" method="POST">
            UserName: <input type="text" name="<%= FastFoodContants.USER_NAME%>" value="" /><br>
            <input type="submit" value="Get Password" />
        </form>
    </body>
</html>
