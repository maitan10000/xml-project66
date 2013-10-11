<%-- 
    Document   : View
    Created on : Oct 8, 2013, 7:45:41 PM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>       
        <h1>View Profile</h1>
        <c:set var="user" value="${sessionScope.LOGIN}"/>
        <table>
            <tr>
                <td>
                    UserName:
                </td>
                <td>
                    ${user.userName}
                </td>
            </tr>
            <tr>
                <td>
                    FirstName:
                </td>
                <td>
                    ${user.firstName}
                </td>
            </tr>
            <tr>
                <td>
                    LastName:
                </td>
                <td>
                    ${user.lastName}
                </td>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td>
                    ${user.email}
                </td>
            </tr>
            <tr>
                <td>
                    Address:
                </td>
                <td>
                    ${user.address}
                </td>
            </tr>
            <tr>
                <td>
                    Phone:
                </td>
                <td>
                    ${user.phone}
                </td>
            </tr>
            <tr>
                <td>
                    CreateDate:
                </td>
                <td>
                    ${user.createDate}
                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td>
                    <a href="#User?Action=EditProfile">Edit Profile</a>
                </td>
            </tr>
        </table>
    </body>
</html>
