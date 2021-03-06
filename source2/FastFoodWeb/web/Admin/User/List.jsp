<%-- 
    Document   : List
    Created on : Oct 6, 2013, 4:39:25 PM
    Author     : Everything
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fastfood.common.constants.FastFoodContants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:set var="user" value="${sessionScope.LOGIN}"/>

<html>
    <body>
        <h1>List User</h1>
        <table border="1" class="admin-table">
            <tr>
                <th>No</th>
                <th>Username</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Role</th>
                <th>Active</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.USER}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${item.userName}</td>
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.email}</td>
                    <td>${item.address}</td>
                    <td>${item.phone}</td>
                    <td>${item.role}</td>
                    <td>${item.active}</td>
                    <td>
                        <a href="#Admin?Action=<%= FastFoodContants.DELETE_USER%>&UserName=${item.userName}">Delete</a>
                        <a href="#Admin?Action=<%= FastFoodContants.EDIT_USER%>&UserName=${item.userName}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
