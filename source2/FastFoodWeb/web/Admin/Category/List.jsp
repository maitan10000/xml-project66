<%-- 
    Document   : AdminProductList
    Created on : Oct 6, 2013, 1:00:38 AM
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
        <h1>List All Product</h1>
        <a href="Admin?Action=AddProduct">Add</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Image</th>
                <th>Description</th>
                <th>CateID</th>
                <th>BuyCount</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.PRODUCT}" varStatus="counter">
                <tr>
                    <td>${item.ID}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.image}</td>
                    <td>${item.description}</td>
                    <td>${item.cateID}</td>
                    <td>${item.buyCount}</td>
                    <c:url var="delete" value="Admin?Action=DeleteProduct&ID=${item.ID}" />
                    <c:url var="edit" value="Admin?Action=EditProduct&ID=${item.ID}" />
                    <td><a href="${delete}">Delete</a>  <a href="${edit}">Edit</a></td>
                </tr>
            </c:forEach>
    </body>
</html>
