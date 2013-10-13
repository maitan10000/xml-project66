<%-- 
    Document   : Detail
    Created on : Oct 12, 2013, 3:16:47 PM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="orderID" value="${sessionScope.ORDER}" />
        <c:import url="/OrderXML/${orderID}.xml" var="orderXML"/>
        <c:import url="/Style/order.xsl" var="orderXSL"/>
        <x:transform xml="${orderXML}" xslt="${orderXSL}"/>
        <a href="#Action=PrintPDF&ID=${orderID}">Print</a>
    </body>
</html>
