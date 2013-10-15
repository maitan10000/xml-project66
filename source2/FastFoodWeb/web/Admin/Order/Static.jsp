<%-- 
    Document   : Static
    Created on : Oct 15, 2013, 1:37:03 AM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fastfood.common.constants.FastFoodContants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Static Order</h1>
        <c:set var="static" value="${sessionScope.STATIC}"/>
        <c:set var="totalAll" value="0"/>

        <form id="Static" action="Admin?Action=<%= FastFoodContants.STATIC_ORDER%>" method="POST" onsubmit="return onSubmitForm(this);">
            From: <input type="date" name="from" value="" placeholder="dd/MM/yyyy"/> To: <input type="date" name="to" value="" placeholder="dd/MM/yyyy"/><br/>
            <input type="submit" value="View"/>
        </form>

        <c:if test="${not empty static}">
            <table>
                <tr>
                    <th>Date</th>
                    <th>Amount</th>
                </tr>
                <c:forEach var="item" items="${static}" varStatus="counter">
                    <tr>
                        <td>${item.date}</td>
                        <td><fmt:formatNumber type="number"
                                          pattern="###,###,###" value="${item.total}" /></td>
                            <c:set var="totalAll" value="${totalAll + item.total}"/>
                    </tr>
                </c:forEach>
                <tr>
                    <td>Total All</td>
                    <td><fmt:formatNumber type="number"
                                      pattern="###,###,###" value="${totalAll}" /></td>
                </tr>
            </table>
        </c:if>
    </body>
</html>
