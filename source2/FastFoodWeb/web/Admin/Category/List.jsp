<%-- 
    Document   : AdminProductList
    Created on : Oct 6, 2013, 1:00:38 AM
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
        <h1>List All Category</h1>
        <a href="Admin?Action=<%= FastFoodContants.ADD_CATEGORY%>">Add</a>
        <a href="Admin?Action=<%= FastFoodContants.EXPORT_CATE%>">Export...</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>IsActive</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.CATE}" varStatus="counter">
                <tr>
                    <td>${item.ID}</td>
                    <td>${item.name}</td>
                    <td>${item.isActive}</td>
                    <c:url var="delete" value="Admin?Action=DeleteCategory&ID=${item.ID}" />
                    <c:url var="edit" value="Admin?Action=EditCategory&ID=${item.ID}" />
                    <td><a href="${delete}">Delete</a>  <a href="${edit}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
