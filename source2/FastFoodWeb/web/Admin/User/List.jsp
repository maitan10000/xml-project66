<%-- 
    Document   : List
    Created on : Oct 6, 2013, 4:39:25 PM
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
        <h1>List User</h1>
        <table border="1">
            <tr>
                <th>No</th>
                <th>Username</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Role</th>
                <th>IsActive</th>
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
                    <c:url var="delete" value="Admin?Action=DeleteUser&UserName=${item.userName}" />
                    <c:url var="edit" value="Admin?Action=EditUser&UserName=${item.userName}" />
                    <td><a href="${delete}">Delete</a>  <a href="${edit}">Edit</a></td>
                </tr>
            </c:forEach>
    </body>
</html>
