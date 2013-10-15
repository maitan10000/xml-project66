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
                    <li><a href="#">About us</a></li>
                </ul>
                <ul class="userInfo" >
                    <c:choose>
                        <c:when test="${not empty user}">
                            <li><a href="#User?Action=NewOrder"><span id="newOrder">New Order (0)</span></a></li>
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
                        <li><a href="#Admin?Action=About">Change About Us</a></li>
                        <li><a href="#Admin?Action=ListUser">User Manage</a></li>
                        <li><a href="#Admin?Action=ListCategory">Category Manage</a></li>
                        <li><a href="#Admin?Action=ListProduct">Product Manage</a></li>
                        <li><a href="#Admin?Action=ListOrder">Order Manage</a></li>
                        <li><a href="#Admin?Action=ExportData">Export Data</a></li>                        
                        <li><a href="#Admin?Action=StaticOrder">Static</a></li>
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
            setInterval(function(){checkNewOrder()},10000);
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
                if(action == '<%= FastFoodContants.LOGOUT%>' )
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
                    //console.log(respondText);
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
                        document.getElementById("content").innerHTML = respondText;
                        UploadImage();
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                        document.getElementById("content").innerHTML = respondText;
                    }                   
                }else if(action == '<%= FastFoodContants.ADD_PRODUCT%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.ADD_PRODUCT%>';
                    if(formSubmit == null)
                    {
                        var respondText = XMLRequest(url,"GET", null);
                        document.getElementById("content").innerHTML = respondText;
                        UploadImage();
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                        document.getElementById("content").innerHTML = respondText;
                    }
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
                }else if(action == '<%= FastFoodContants.LIST_ORDER%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.LIST_ORDER%>';
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.DELETE_ORDER%>' )
                {
                    var ID = getQueryVariable('ID', hashString);
                    var url = 'Admin?Action=<%= FastFoodContants.DELETE_ORDER%>&ID='+ID;
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.VIEW_ORDER_DETAIL%>')
                {
                    var ID = getQueryVariable('ID', hashString);
                    var url = 'Admin?Action=<%= FastFoodContants.VIEW_ORDER_DETAIL%>&ID='+ID;
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.PRINT_PDF%>')
                {
                    var orderID = getQueryVariable('ID', hashString);
                    var url = 'User?Action=<%= FastFoodContants.PRINT_PDF%>&ID='+orderID;
                    var win=window.open(url, '_blank');
                    win.focus();
                }
                else if(action == '<%= FastFoodContants.EDIT_ORDER%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.EDIT_ORDER%>';
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
                }else if(action == 'NewOrder')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.LIST_ORDER_BY_STATUS%>&Status=UNAPPROVED';
                    var respondText = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.ABOUT%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.ABOUT%>';
                    if(formSubmit == null)
                    {
                        var respondText = XMLRequest(url,"GET", null);
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                    }
                    document.getElementById("content").innerHTML = respondText;
                }else if(action == '<%= FastFoodContants.STATIC_ORDER%>')
                {
                    var url = 'Admin?Action=<%= FastFoodContants.STATIC_ORDER%>';
                    if(formSubmit == null)
                    {
                        var respondText = XMLRequest(url,"GET", null);
                    }else
                    {
                        var post = serializeToQueryString(formSubmit);
                        var respondText = XMLRequest(url,"POST", post);
                    }
                    document.getElementById("content").innerHTML = respondText;
                }

                formSubmit = null;
                location.hash = '#Action=Done';
            }
            
            //upload image
            function UploadImage()
            {
                document.querySelector('form input[type=file]').addEventListener('change', function(event){
                    // Read files
                    var files = event.target.files;
                    // Iterate through files
                    for (var i = 0; i < files.length; i++) {
                        // Ensure it's an image
                        if (files[i].type.match(/image.*/)) {
                            var fileName = files[i].name;
                            // Load image
                            var reader = new FileReader();
                            reader.onload = function (readerEvent) {
                                var image = new Image();
                                image.onload = function (imageEvent) {                                   
                                    // Resize image
                                    var canvas = document.createElement('canvas'),
                                    max_size = 250;
                                    canvas.width = max_size;
                                    canvas.height = max_size;
                                    canvas.getContext('2d').drawImage(image, 0, 0, max_size, max_size);

                                    // Upload image                                    
                                    var url = 'Admin?Action=<%= FastFoodContants.UPLOAD_FILE%>';
                                    var post = 'Image='+encodeURIComponent(canvas.toDataURL('image/jpeg'))+'&Name='+fileName;
                                    var respond = XMLRequest(url, "POST", post);
                                    console.log(respond);
                                    document.getElementById("image-link").value = respond;
                                    document.getElementById("upload-image").src = 'Data/Img/'+respond;
                                }
                                image.src = readerEvent.target.result;
                            }
                            reader.readAsDataURL(files[i]);
                        }
                    }
                    // Clear files
                    event.target.value = '';
                });
            }
            //end upload image

            //check new order
            function checkNewOrder()
            {
                var url = 'Admin?Action=<%= FastFoodContants.COUNT_NEW_ORDER%>&Status=UNAPPROVED';
                var respondText = XMLRequest(url,"GET", null);
                document.getElementById("newOrder").innerHTML = "New Order("+respondText+")";
                if(respondText >0)
                {
                    document.getElementById("newOrder").innerHTML = "New Order ("+respondText+")";
                    document.getElementById("newOrder").className = "newOrder";
                }else
                {
                    document.getElementById("newOrder").className = "";
                }
            }           
        </script>
    </body>
    <script src="Script/validate.js"></script>
    <script src="Script/functions.js"></script>
</html>
