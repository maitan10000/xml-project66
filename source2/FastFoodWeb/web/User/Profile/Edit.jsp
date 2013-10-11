<%-- 
    Document   : Edit
    Created on : Oct 8, 2013, 7:45:46 PM
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
        <h1>Edit Profile</h1>
        <c:set var="user" value="${sessionScope.LOGIN}"/>

        <form action="User?Action=<%= FastFoodContants.EDIT_PROFILE%>" method="POST" onsubmit="return onSubmitForm(this);">
            <table>
                <input type="hidden" name="<%= FastFoodContants.USER_NAME%>" value="${user.userName}" />
                <tr>
                    <td>UserName: </td>
                    <td><span>${user.userName}</span></td>
                </tr>
                <tr>
                    <td>Password </td>
                    <td><input type="password" name="<%= FastFoodContants.PASSWORD%>" value="${user.password}" /></td>
                </tr>
                <tr>
                    <td>FirstName: </td>
                    <td><input type="text" name="<%= FastFoodContants.FIRST_NAME%>" value="${user.firstName}" /></td>
                </tr>
                <tr>
                    <td>LastName: </td>
                    <td> <input type="text" name="<%= FastFoodContants.LAST_NAME%>" value="${user.lastName}" /></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td> <input type="text" name="<%= FastFoodContants.EMAIL%>" value="${user.email}" /></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td> <input type="text" name="<%= FastFoodContants.ADDRESS%>" value="${user.address}" /></td>
                </tr>
                <tr>
                    <td>Phone: </td>
                    <td> <input type="text" name="<%= FastFoodContants.PHONE%>" value="${user.phone}" /></td>
                </tr>
                <tr>
                    <td>CreateDate: </td>
                    <td><span>${user.createDate}</span></td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form>
        <a href="#User?Action=<%= FastFoodContants.VIEW_PROFILE%>">Back to View</a>
    </body>
</html>
