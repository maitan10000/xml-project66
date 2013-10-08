<%-- 
    Document   : Edit
    Created on : Oct 6, 2013, 4:39:30 PM
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
        <h1>Edit User</h1>
        <c:set var="user" value="${sessionScope.USER}"/>

        <form action="Admin?Action=<%= FastFoodContants.EDIT_USER%>" method="POST">
            <table>
                <input type="hidden" name="<%= FastFoodContants.USER_NAME%>" value="${user.userName}" />
                <tr>
                    <td>UserName: </td>
                    <td><span>${user.userName}</span></td>
                </tr>
                <tr>
                    <td>FirstName: </td>
                    <td><input type="text" name="<%= FastFoodContants.FIRST_NAME%>" value="${user.firstName}" /></td>
                </tr>
                <tr>
                    <td>LastName: </td>
                    <td> <input type="text" name="<%= FastFoodContants.LAST_NAME%>" value="${user.lastName}" /></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td> <input type="text" name="<%= FastFoodContants.EMAIL%>" value="${user.email}" /></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td> <input type="text" name="<%= FastFoodContants.ADDRESS%>" value="${user.address}" /></td>
                </tr>
                <tr>
                    <td>Phone: </td>
                    <td> <input type="text" name="<%= FastFoodContants.PHONE%>" value="${user.phone}" /></td>
                </tr>
                <tr>
                    <td>Role: </td>
                    <td>
                        <select name="<%= FastFoodContants.ROLE%>">
                            <c:forEach var="item" items="Customer,Admin">
                                <c:choose>
                                    <c:when test="${user.role == item}">
                                        <option value="${item}" selected>${item}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${item}">${item}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>IsActive </td>
                    <td>
                        <select name="<%= FastFoodContants.IS_ACTIVE%>">
                            <c:forEach var="item" items="True,False">
                                <c:choose>
                                    <c:when test="${user.active == item}">
                                        <option value="${item}" selected>${item}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${item}">${item}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form>
        <a href="Admin?Action=<%= FastFoodContants.LIST_USER%>">Back to List</a>
    </body>
</html>
