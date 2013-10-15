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
        <h1>Edit Category</h1>
        <c:set var="category" value="${sessionScope.CATE}"/>
        <form id="Cate-Edit" action="Admin?Action=EditCategory" method="POST"  onsubmit="return onSubmitForm(this);">
            <table class="ae-table">
                <input type="hidden" name="ID" value="${category.ID}" />
                <tr>
                    <td>Name<span class="require">*</span>: </td>
                    <td> <input type="text" name="Name" value="${category.name}" /></td>
                </tr>
                <tr>
                    <td>IsActive </td>
                    <td>
                        <select name="IsActive">
                            <c:forEach var="item" items="True,False">
                                <c:choose>
                                    <c:when test="${category.isActive == item}">
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
                    <td></td>
                    <td> <input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form>
        <span class="require">*: require fields</span><br/>
        <a href="#Admin?Action=ListCategory">Back to List</a>
    </body>
</html>
