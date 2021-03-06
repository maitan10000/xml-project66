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
        <a href="#Admin?Action=<%= FastFoodContants.ADD_CATEGORY%>">Add</a>
        <table border="1">
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.CATE}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${item.name}</td>
                    <c:url var="delete" value="#Admin?Action=DeleteCategory&ID=${item.ID}" />
                    <c:url var="edit" value="#Admin?Action=EditCategory&ID=${item.ID}" />
                    <td><a href="${delete}">Delete</a>  <a href="${edit}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
