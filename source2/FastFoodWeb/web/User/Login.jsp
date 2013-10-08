<%-- 
    Document   : Login
    Created on : Oct 8, 2013, 6:36:20 PM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fastfood.common.constants.FastFoodContants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <c:set var="msg" value="${sessionScope.MSG}"/>
        <c:if test="${not empty msg}">
            <h3>${msg}</h3>
        </c:if>
        <form action="User?Action=<%= FastFoodContants.LOGIN%>" method="POST">
            <table>
                <tr>
                    <td>
                        UserName:
                    </td>
                    <td>
                        <input type="text" name="<%= FastFoodContants.USER_NAME%>" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Password:
                    </td>
                    <td>
                        <input type="text" name="<%= FastFoodContants.PASSWORD%>" value="" />
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <input type="submit" value="Login" />
                        <a href="User?Action=<%= FastFoodContants.RESET_PASS%>">Forget password</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
