<%-- 
    Document   : ListOrder
    Created on : Oct 11, 2013, 2:39:01 AM
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
        <h1>List Order</h1>
        <c:set var="listOrder" value="${sessionScope.ORDER}"/>
        <table border="1">
            <tr>
                <th>No</th>
                <th>Status</th>
                <th>Create Date</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${listOrder}" varStatus="counter" >
                <tr>
                    <td>${counter.count}</td>
                    <td>${item.status}</td>
                    <td>${item.createDate}</td>
                    <td>
                        <a href="#Action=OrderDetail&ID=${item.ID}">Detail</a>
                        <c:if test="${item.status == 'UNAPPROVED'}">
                            <a href="#Action=<%= FastFoodContants.CANCEL_ORDER%>&ID=${item.ID}">Cancel</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
