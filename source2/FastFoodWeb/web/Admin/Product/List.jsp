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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List All Product</h1>
        <a href="#Admin?Action=<%= FastFoodContants.ADD_PRODUCT%>">Add</a>
        <table border="1" class="admin-table">
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Price</th>
                <th>Image</th>
                <th>Description</th>
                <th>Category</th>
                <th>Sold</th>
                <th></th>
            </tr>
            <c:set var="cate" value="${sessionScope.CATE}"/>
            <c:forEach var="item" items="${sessionScope.PRODUCT}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><img alt=""  style="widows: 20px; height: 20px;" src="Data/Img/${item.image}" /></td>
                    <td>${fn:substring(item.description, 0, 10)} ...</td>
                    <td>
                        <c:forEach var="cateItem" items="${cate}">
                            <c:if test="${item.cateID == cateItem.ID}">
                                ${cateItem.name}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${item.buyCount}</td>
                    <td>
                        <a href="#Admin?Action=<%= FastFoodContants.DELETE_PRODUCT%>&ID=${item.ID}">Delete</a>
                        <a href="#Admin?Action=<%= FastFoodContants.EDIT_PRODUCT%>&ID=${item.ID}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
