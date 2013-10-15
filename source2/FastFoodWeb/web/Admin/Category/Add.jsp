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
        <form id="Cate-Add" action="Admin?Action=AddCategory" method="POST"  onsubmit="return onSubmitForm(this);">
            <table class="ae-table">
                <tr>
                    <td>Name<span class="require">*</span>: </td>
                    <td> <input type="text" name="Name" value="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Add" /></td>
                </tr>
            </table>
            <span class="require">*: require fields</span><br/>
            <a href="#Admin?Action=ListCategory">Back to List</a>
        </form>
    </body>
</html>
