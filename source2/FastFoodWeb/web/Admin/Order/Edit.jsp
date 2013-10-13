<%-- 
    Document   : Edit
    Created on : Oct 12, 2013, 3:16:53 PM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="fastfood.common.constants.FastFoodContants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Order</h1>
        <c:set var="orderBean" value="${sessionScope.ORDER}"/>
        <form action="Admin?Action=EditOrder" method="POST" onsubmit="return onSubmitForm(this);">
            <input type="hidden" name="<%= FastFoodContants.ID%>" value="${orderBean.ID}"/>
            <table>
                <tr>
                    <td>
                        Status:
                    </td>
                    <td>
                        <select name="<%= FastFoodContants.STATUS%>">
                            <c:forEach var="item" items="UNAPPROVED,APPROVED,DELIVERED,CANCEL">
                                <c:choose>
                                    <c:when test="${orderBean.status == item}">
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
                    <td>
                        Notes:
                    </td>
                    <td>
                        <textarea name="<%= FastFoodContants.NOTES%>" cols="80" rows="10">${orderBean.notes}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <input type="submit" value="Save"/>
                    </td>

                </tr>
            </table>
        </form>
    </body>
</html>
