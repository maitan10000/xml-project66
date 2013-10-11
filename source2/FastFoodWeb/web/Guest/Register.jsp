<%-- 
    Document   : Register
    Created on : Oct 8, 2013, 9:40:09 AM
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
        <h1>Register Account</h1>
        <c:set var="msg" value="${sessionScope.MSG}"/>
        <c:set var="userInfo" value="${sessionScope.USER}"/>
        <c:if test="${not empty msg}">
            <h3>${msg}</h3>
        </c:if>
        <form action="Guest?Action=Register" method="POST">
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
                        FirstName:
                    </td>
                    <td>
                        <input type="text" name="<%= FastFoodContants.FIRST_NAME%>" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        LastName:
                    </td>
                    <td>
                        <input type="text" name="<%= FastFoodContants.LAST_NAME%>" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:
                    </td>
                    <td>
                        <input type="text" name="<%= FastFoodContants.EMAIL%>" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td>
                    <td>
                        <input type="text" name="<%= FastFoodContants.ADDRESS%>" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Phone:
                    </td>
                    <td>
                        <input type="text" name="<%= FastFoodContants.PHONE%>" value="" />
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <input type="submit" value="Create" />
                    </td>
                </tr>
            </table>
        </form>
        <a href="Home.jsp">Back to home</a>
    </body>
</html>
