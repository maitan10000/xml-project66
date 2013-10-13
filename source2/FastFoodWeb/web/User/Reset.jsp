<%-- 
    Document   : Reset
    Created on : Oct 8, 2013, 7:28:57 PM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fastfood.common.constants.FastFoodContants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            #content
            {
                margin: auto;
                width: 300px;
            }
        </style>
    </head>
    <body>
        <div id="content">
            <h1>Reset Password</h1>
            <c:set var="msg" value="${sessionScope.MSG}"/>
            <c:if test="${not empty msg}">
                <h3>${msg}</h3>
            </c:if>
            <form id="Reset" action="User?Action=Reset" method="POST" onsubmit="return validate(this)">
                <table>
                    <tr>
                        <td>
                            UserName:
                        </td>
                        <td>
                            <input type="text" name="<%= FastFoodContants.USER_NAME%>" value="" /><br>
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td>
                            <input type="submit" value="Get Password" />
                        </td>
                    </tr>
                </table>
            </form>
            <a href="Home.jsp">Back to home</a>
        </div>
    </body>
    <script src="Script/validate.js"></script>
</html>
