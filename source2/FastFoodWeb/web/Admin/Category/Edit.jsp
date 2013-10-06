<%-- 
    Document   : Edit
    Created on : Oct 6, 2013, 10:09:29 AM
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
        <h1>Edit product</h1>
        <c:set var="product" value="${sessionScope.PRODUCT}"/>
        <c:set var="cate" value="${sessionScope.CATE}"/>

        <form action="Admin?Action=EditProduct" method="POST">
            <table>
                <input type="hidden" name="ID" value="${product.ID}" />
                <tr>
                    <td>Name: </td>
                    <td> <input type="text" name="Name" value="${product.name}" /></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="text" name="Price" value="${product.price}" /></td>
                </tr>
                <tr>
                    <td>Image: </td>
                    <td> <input type="text" name="Image" value="${product.image}" /></td>
                </tr>
                <tr>
                    <td>Desctiption: </td>
                    <td> <textarea name="Description">${product.description}</textarea></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td> <select name="CateID">
                            <c:forEach var="item" items="${cate}">
                                <c:choose>
                                    <c:when test="${product.cateID == item.ID}">
                                        <option value="${item.ID}" selected>${item.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${item.ID}">${item.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form>
                <a href="Admin?Action=ListProduct">Back to List</a>
    </body>
</html>
