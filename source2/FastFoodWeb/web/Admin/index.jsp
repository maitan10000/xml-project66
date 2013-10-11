<%-- 
    Document   : index
    Created on : Oct 11, 2013, 10:26:40 AM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fastfood.common.constants.FastFoodContants" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:set var="user" value="${sessionScope.LOGIN}"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="Style/style.css" media="screen" />
    </head>
    <body>
        <div id="container">
            <div id="header">
                <h1>
			Fast Food
                </h1>
            </div>
            <div id="navigation">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact us</a></li>
                </ul>
                <ul class="userInfo" >
                    <c:choose>
                        <c:when test="${not empty user}">
                            <li><a href="#User?Action=NewOrder">New Order</a></li>
                            <li><a href="#User?Action=ViewProfile">${user.userName}</a></li>
                            <li><a href="#User?Action=Logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="#User?Action=Login">Login</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            <div id="content-container">
                <div id="section-navigation">
                    <ul>
                        <li><a href="#Admin?Action=ListUser">User Manage</a></li>
                        <li><a href="#Admin?Action=ListCategory">Category Manage</a></li>
                        <li><a href="#Admin?Action=ListProduct">Product Manage</a></li>
                        <li><a href="#Admin?Action=ListOrder">Order Manage</a></li>
                        <li><a href="#Admin?Action=ExportData">Export Data</a></li>
                    </ul>
                </div>
                <div id="content">

                </div>               
                <div id="footer">
			Copyright © Fast Food, 2013
                </div>
            </div>
        </div>
        <script  LANGUAGE="JavaScript">

            if(window.addEventListener) {
                window.addEventListener('hashchange', onHashChange);
            } else {
                window.attachEvent('onhashchange', onHashChange);
            }

            var warning = true;
            window.onbeforeunload = function() {
                if (warning) {
                    return "You have made changes on this page that you have not yet confirmed. If you navigate away from this page you will lose your unsaved changes";
                }
            }

            function onHashChange() {
                var hashString =  location.hash.substring(1);
                console.log(hashString);
                var action = getQueryVariable('Action', hashString);
                if(!action)
                {
                    listProductByCateID('-1');
                }else if(action == 'ProductView')
                {
                    var cateID = getQueryVariable('cateID', hashString);
                    //console.log(cateID);
                    listProductByCateID(cateID);
                }else if(action == '<%= FastFoodContants.LOGOUT%>' )
                {
                    var result = confirm('Are you sure you want to logout?');
                    if(result)
                    {
                        warning = false;
                        var url = 'User?Action=<%= FastFoodContants.LOGOUT%>';
                        var respond = XMLRequest(url,"GET", null);
                        url = 'Home.jsp';
                        document.location.href= url;
                    }
                }else if(action == 'ViewProfile')
                {
                    var url = "User?Action=ViewProfile";
                    var respondText = XMLRequest(url,"GET", null);
                    console.log(respondText);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == 'EditProfile')
                {
                    var url = "User?Action=EditProfile";
                    if(formSubmit== null)
                    {
                        var respondText = XMLRequest(url,"GET", null);
                        //console.log(respondText);
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                    }
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.LIST_USER%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.LIST_USER%>';
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.DELETE_USER%>')
                {
                    var userID = getQueryVariable('UserName', hashString);
                    var url = 'Admin?Action=<%= FastFoodContants.DELETE_USER%>&UserName='+userID;
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.EDIT_USER%>')
                {                  
                    var url = 'Admin?Action=<%= FastFoodContants.EDIT_USER%>';
                    if(formSubmit == null)
                    {                   
                        var userID = getQueryVariable('UserName', hashString);
                        url += '&UserName='+userID;
                        var respondText = XMLRequest(url,"GET", null);
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                    }                    
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.LIST_CATEGORY%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.LIST_CATEGORY%>';                    
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.EDIT_CATEGORY%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.EDIT_CATEGORY%>';
                    if(formSubmit == null)
                    {
                        var cateID = getQueryVariable('ID', hashString);
                        url += '&ID='+cateID;
                        var respondText = XMLRequest(url,"GET", null);
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                    }
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.ADD_CATEGORY%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.ADD_CATEGORY%>';
                    if(formSubmit == null)
                    {
                        var respondText = XMLRequest(url,"GET", null);
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                    }
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.DELETE_CATEGORY%>')
                {
                    var cateID = getQueryVariable('ID', hashString);
                    var url = 'Admin?Action=<%= FastFoodContants.DELETE_CATEGORY%>&ID='+cateID;
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.LIST_PRODUCT%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.LIST_PRODUCT%>';
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.EDIT_PRODUCT%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.EDIT_PRODUCT%>';
                    if(formSubmit == null)
                    {
                        var ID = getQueryVariable('ID', hashString);
                        url += '&ID='+ID;
                        var respondText = XMLRequest(url,"GET", null);
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                    }
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.ADD_PRODUCT%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.ADD_PRODUCT%>';
                    if(formSubmit == null)
                    {
                        var respondText = XMLRequest(url,"GET", null);
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                    }
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.DELETE_PRODUCT%>')
                {
                    var ID = getQueryVariable('ID', hashString);
                    var url = 'Admin?Action=<%= FastFoodContants.DELETE_PRODUCT%>&ID='+ID;
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.EXPORT_DATA%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.EXPORT_DATA%>';
                    var respondText = XMLRequest(url,"GET", null);
                    alert("Export done!");                    
                }

                formSubmit = null;
                location.hash = '#Action=Done';
            }


            //Addtion function
            function getQueryVariable(variable, hashString) {
                var query = hashString;
                var vars = query.split('?');
                query = vars[vars.length-1];
                vars = query.split('&');
                for (var i = 0; i < vars.length; i++) {
                    var pair = vars[i].split('=');
                    if (decodeURIComponent(pair[0]) == variable) {
                        return decodeURIComponent(pair[1]);
                    }
                }
            }

            //make XMLHttpRequest
            var respondXML;
            function XMLRequest(url, method, post)
            {
                var XMLRequest = null;
                try{
                    XMLRequest = new XMLHttpRequest();
                }catch(e)
                {
                    try{
                        XMLRequest = new ActiveXObject("Msxml2.XMLHTTP");
                    }catch(e)
                    {
                        XMLRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                if(XMLRequest == null)
                {
                    aler("Your brower does not support AJAX!");
                    return;
                }
                if(url.indexOf('?')>-1)
                {
                    url += '&nocache='+(Math.random()*1000000);
                }else
                {
                    url += '?nocache='+(Math.random()*1000000);
                }
                XMLRequest.open(method, url, false);
                XMLRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                XMLRequest.onreadystatechange = function() {//Call a function when the state changes.
                    if(XMLRequest.readyState == 4 && XMLRequest.status == 200) {
                        //console.log("R:" + XMLRequest.responseText);
                        console.log(XMLRequest.responseXML);
                    }
                }
                XMLRequest.send(post);
                respondXML = XMLRequest.responseXML;
                return XMLRequest.responseText;
            }

            //handle form submit
            var formSubmit = null;;
            function onSubmitForm(form)
            {
                formSubmit = form;
                var vars = form.action.split('?');
                location.hash = vars[vars.length-1];
                return false;
            }

            //
            function getSelectedOptions(el) {
                var rv = [];
                for (var i = 0; i < el.options.length; i++) {
                    if (el.options[i].selected) {
                        rv.push(el.options[i]);
                    }
                }
                return rv;
            };

            //serialze form to querystring
            function serializeToQueryString(form) {
                var results = {};
                var rv = '';
                var inputs = form.elements;

                for (var k = 0; k < inputs.length; k++) {
                    var el = inputs[k];

                    if (el == null || el.nodeName == undefined) continue;

                    var tagName = el.nodeName.toLowerCase();
                    if (!(tagName == "input" || tagName == "select" || tagName == "textarea")) continue;

                    var type = el.type, names =[], name = el.name, current;
                    if (!el.name || el.disabled || type == 'submit' || type == 'reset' || type == 'file' || type == 'image') continue;

                    var value = (tagName == 'select') ? getSelectedOptions(el).map(function(opt){
                        return opt.value;
                    }) : ((type == 'radio' || type == 'checkbox') && !el.checked) ? null : el.value;

                    if (value != null) rv = rv + "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(value);
                }
                return (rv.length > 0) ? rv.substring(1) : rv;
            };
        </script>
    </body>
</html>
