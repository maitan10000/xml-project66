<%-- 
    Document   : Register
    Created on : Oct 8, 2013, 9:40:09 AM
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
        <style type="text/css">
            #content
            {
                margin: auto;
                width: 400px;
            }
            .require{
                color: red;
            }
        </style>
    </head>
    <body>
        <div id="content">
            <h1>Register Account</h1>
            <c:set var="msg" value="${sessionScope.MSG}"/>
            <c:set var="userInfo" value="${sessionScope.USER}"/>
            <c:if test="${not empty msg}">
                <h3>${msg}</h3>
            </c:if>
            <form id="Register" action="Guest?Action=Register" method="POST" onsubmit="return validate(this)">
                <table>
                    <tr>
                        <td>
                            UserName<span class="require">*</span>:
                        </td>
                        <td>
                            <input type="text" name="<%= FastFoodContants.USER_NAME%>" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Password<span class="require">*</span>:
                        </td>
                        <td>
                            <input type="password" name="<%= FastFoodContants.PASSWORD%>" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Confirm password<span class="require">*</span>:
                        </td>
                        <td>
                            <input type="password" name="RePassword" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            FirstName:
                        </td>
                        <td>
                            <input type="text" name="<%= FastFoodContants.FIRST_NAME%>" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            LastName:
                        </td>
                        <td>
                            <input type="text" name="<%= FastFoodContants.LAST_NAME%>" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email<span class="require">*</span>:
                        </td>
                        <td>
                            <input type="text" name="<%= FastFoodContants.EMAIL%>" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Address<span class="require">*</span>:
                        </td>
                        <td>
                            <input type="text" name="<%= FastFoodContants.ADDRESS%>" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Phone<span class="require">*</span>:
                        </td>
                        <td>
                            <input type="text" name="<%= FastFoodContants.PHONE%>" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td>
                            <input type="submit" value="Create" />
                        </td>
                    </tr>
                </table>
            </form>
            <span class="require">*: require fields</span><br/>
            <a href="Home.jsp">Back to home</a>
        </div>
    </body>
    <script src="Script/validate.js"></script>
</html>
