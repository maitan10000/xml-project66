<%-- 
    Document   : Add
    Created on : Oct 6, 2013, 11:26:04 AM
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
        <h1>Add Cate</h1>
    <form action="Admin?Action=AddCategory" method="POST">
        <table>       
            <tr>
                <td>Name: </td>
                <td> <input type="text" name="Name" value="" /></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="Price" value="" /></td>
            </tr>
            <tr>
                <td>Image: </td>
                <td> <input type="text" name="Image" value="" /></td>
            </tr>
            <tr>
                <td>Desctiption: </td>
                <td> <textarea name="Description"></textarea></td>
            </tr>
            <tr>
                <td>Category: </td>
                <td> <select name="CateID">
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
        <a href="Admin?Action=ListProduct">Back to List</a>
    </form>
</body>
</html>