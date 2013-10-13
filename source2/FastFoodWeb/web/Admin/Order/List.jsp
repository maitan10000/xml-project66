<%-- 
    Document   : List
    Created on : Oct 6, 2013, 5:23:19 PM
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
        <table border="1" class="admin-table">
            <tr>
                <th>No.</th>
                <th>Customer</th>
                <th>Creator</th>
                <th>Status</th>
                <th>Notes</th>
                <th>ReceiveAddress</th>
                <th>CreateDate</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.ORDER}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td><a href="#Admin?Action=<%= FastFoodContants.EDIT_USER%>&UserName=${item.buyerName}">${item.buyerName}</a></td>
                    <td><a href="#Admin?Action=<%= FastFoodContants.EDIT_USER%>&UserName=${item.creator}">${item.creator}</a></td>
                    <td style="font-size: 11px;" >${item.status}</td>
                    <td>${item.notes}</td>
                    <td>${item.receiveAddress}</td>
                    <td>${item.createDate}</td>
                    <c:url var="delete" value="#Admin?Action=DeleteOrder&ID=${item.ID}" />
                    <c:url var="edit" value="#Admin?Action=EditOrder&ID=${item.ID}" />
                    <c:url var="detail" value="#Admin?Action=OrderDetail&ID=${item.ID}" />
                    <td>
                        <a href="${delete}">Delete</a>
                        <a href="${edit}">Edit</a>
                        <a href="${detail}">Detail</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
