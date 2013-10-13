<%-- 
    Document   : Add
    Created on : Oct 6, 2013, 11:26:04 AM
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
        <h1>Add product</h1>
        <c:set var="cate" value="${sessionScope.CATE}"/>

        <form action="Admin?Action=<%=FastFoodContants.ADD_PRODUCT%>" method="POST" onsubmit="return onSubmitForm(this);">
            <table>
                <tr>
                    <td>Name: </td>
                    <td> <input type="text" name="<%= FastFoodContants.NAME%>" value="" /></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="text" name="<%= FastFoodContants.PRICE%>" value="" /></td>
                </tr>
                <tr>
                    <td>Image: </td>
                    <td>
                        <input id="image-link" type="hidden" name="<%= FastFoodContants.IMAGE%>" value="" />
                        <img id="upload-image" src="" />
                        <div id="upload-area">
                            <form>
                                <input type="file" name="file"/>
                            </form>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Desctiption: </td>
                    <td> <textarea name="<%= FastFoodContants.DESCRIPTION%>" cols="80" rows="10"></textarea></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td> <select name="<%= FastFoodContants.P_CATEID%>">
                            <c:forEach var="item" items="${cate}">
                                <option value="${item.ID}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Add" /></td>
                </tr>
            </table>            
        </form>
        <a href="#Admin?Action=<%= FastFoodContants.LIST_PRODUCT%>">Back to List</a>
    </body>
</html>
