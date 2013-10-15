<%-- 
    Document   : About
    Created on : Oct 15, 2013, 12:15:34 AM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fastfood.common.constants.FastFoodContants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Change about us</h1>
        <form action="Admin?Action=<%= FastFoodContants.ABOUT%>" method="POST" onsubmit="return onSubmitForm(this);">
            About:<br>
            <textarea cols="70" rows="15"  name="<%= FastFoodContants.ABOUT%>">${sessionScope.MSG}</textarea><br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
