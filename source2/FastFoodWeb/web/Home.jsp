<%-- 
    Document   : home
    Created on : Oct 9, 2013, 12:27:41 AM
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
        <style type="text/css">
            *{
                margin: 0;
                padding: 0;
            }
            body{
                background: url("http://zurb.com/playground/uploads/upload/upload/87/wood-bg.jpg") repeat scroll 0 0 rgba(0, 0, 0, 0);
            }
            #container
            {
                margin: 0 auto;
                width: 1000px;
                background: #fff;
            }

            #header
            {
                background: #ccc;
                padding: 20px;
            }

            #header h1 { margin: 0; }

            #navigation
            {
                float: left;
                width: 1000px;
                background: #333;
            }

            #navigation ul
            {
                margin: 0;
                padding: 0;
            }

            #navigation ul li
            {
                list-style-type: none;
                display: inline;
            }

            #navigation li a, .userInfo li a
            {
                display: block;
                padding: 5px 10px;
                color: #fff;
                text-decoration: none;
            }

            #navigation li a
            {
                float: left;
                border-right: 1px solid #fff;
            }

            .userInfo{
                float: right;
            }
            .userInfo li a
            {
                border-left : 1px solid #fff;
            }
            #navigation li a:hover
            {
                background: #383;
            }

            #content-container
            {
                float: left;
                width: 1000px;
                background: #fff;
            }

            #section-navigation
            {
                float: left;
                width: 120px;
                padding: 20px 0;
                margin: 0 20px;
                display: inline;
                border: violet thin solid;
            }

            #section-navigation ul
            {
                margin: 0;
                padding: 0;
            }

            #section-navigation ul li
            {
                margin: 0 0 1em;
                padding: 0;
                list-style-type: none;
            }

            #content
            {
                float: left;
                width: 600px;
                min-height: 500px;
                padding: 0 0;
                margin: auto;
                border:blue thin solid;                
            }

            #content h2 {
                margin: 0 auto;
            }

            #aside
            {
                float: right;
                width: 200px;
                padding: 20px 0;
                margin: 0 20px 0 0;
                display: inline;
                border: violet thin solid;
            }

            #aside h3 { margin: 0; }

            #footer
            {
                clear: left;
                background: #ccc;
                text-align: center;
                padding: 20px;
                height: 1%;
            }

            .product
            {
                width: 170px;
                height: 220px;
                border: 2px blue solid;
                margin: 10px 10px 10px 10px;
            }

            #content li{               
                display: inline-block;
            }

            .productImage
            {
                width:  170px;
                height: 170px;                
            }
            #productDetail .productInfo
            {
                margin-top: 20px;
                float: left;
                margin-left: 50px;
            }
            #productDetail .productImage
            {
                float: left;
                width: 250px;
                height: 250px;
            }
            #productDetail .productDesc
            {
                padding-top: 10px;
                clear: both;
            }
        </style>
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
                            <li><a href="#User?Action=ViewCart">ViewCart</a></li>
                            <li><a href="#User?Action=ViewProfile">${user.userName}</a></li>
                            <li><a href="#User?Action=Logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="User?Action=Login">Login</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            <div id="content-container">
                <div id="section-navigation">               
                    <c:import url="Data/categorys.xml" var="cateXML"/>
                    <c:import url="Style/categorys.xsl" var="cateXSL"/>
                    <x:transform xml="${cateXML}" xslt="${cateXSL}"/>
                </div>
                <div id="content">
                    <div id="productID">
                        <img src="" class="productImage"/>
                        <div id="productInfo" class="productInfo">
                            <p>Name:</p>
                            <p>Price:</p>
                        </div>
                    </div>
                    <div id="productID">
                        <img src="" class="productImage"/>
                        <div id="productInfo" class="productInfo">
                            <p>Name:</p>
                            <p>Price:</p>
                        </div>
                    </div>
                </div>
                <div id="aside">
                    <h3>
				Aside heading
                    </h3>
                    <p>
				Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan.
                    </p>
                </div>
                <div id="footer">
			Copyright © Fast Food, 2013
                </div>
            </div>
        </div>
        <script LANGUAGE="JavaScript">
           
            init();
            if(window.addEventListener) {
                window.addEventListener('hashchange', onHashChange);
            } else {
                window.attachEvent('onhashchange', onHashChange);
            }
            
            function onHashChange() {
                var hashString =  location.hash.substring(1);
                console.log(hashString);
                var action = getQueryVariable('Action', hashString);
                if(action == 'ProductView')
                {
                    var cateID = getQueryVariable('cateID', hashString);
                    //console.log(cateID);
                    listProductByCateID(cateID);
                }else if(action == 'ProductDetail')
                {
                    var productID = getQueryVariable('ID', hashString);
                    var url = "Guest";
                    var post = "Action=ProductDetail&ID="+productID;
                    XMLRequest(url,"POST", post);
                    var id = respondXML.getElementsByTagName("ID")[0].childNodes[0].nodeValue;
                    var name = respondXML.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                    var price = respondXML.getElementsByTagName("price")[0].childNodes[0].nodeValue;
                    var image = respondXML.getElementsByTagName("image")[0].childNodes[0].nodeValue;
                    var description = respondXML.getElementsByTagName("description")[0].childNodes[0].nodeValue;
                    var cateID = respondXML.getElementsByTagName("cateID")[0].childNodes[0].nodeValue;
                    var buyCount = respondXML.getElementsByTagName("buyCount")[0].childNodes[0].nodeValue;
                    var content = '';
                    content +='<div id="productDetail" class="productDetail">'
                    content +='<img src="'+image+'" class="productImage"/>'
                    content +='<div id="productInfo" class="productInfo">'
                    content +='<h4>'+name+'</h4>'
                    content +='Price: '+price +' VND'
                    content +='<br>Sold: '+buyCount                                  
            <c:choose>
                <c:when test="${not empty user}">
                            content +='<form action="User?Action=BuyProduct" method="Post" onsubmit="return onSubmitForm(this);">'
                            content +='<input type="hidden" name="ProductID" value="'+id+'"/>'
                            content +='<br>Quantity: <input type="text" name="Quantity" value="1"/>'
                            content +='<input type="submit" value="Buy"/>'
                            content +='</form>'
                </c:when>
                <c:otherwise>
                            content +='<br><a href="#">Login to buy</a>'
                </c:otherwise>
            </c:choose>
                        content +='</div><div id="productDesc" class="productDesc">'
                        content +='<b>Description:</b> <p>'+description+'</p></div></div>'
                        document.getElementById("content").innerHTML = content;
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
                            console.log(post);
                            var respondText = XMLRequest(url,"POST", post);
                        }
                        document.getElementById("content").innerHTML = respondText;
                    }else if(action == '<%= FastFoodContants.BUY_PRODUCT%>')
                    {                        
                        var productID = formSubmit.ProductID.value;
                        var quantity = formSubmit.Quantity.value;                        
                        CART.addItem(productID, quantity);                                                
                    }else if(action == '<%= FastFoodContants.VIEW_CART%>')
                    {                        
                        document.getElementById("content").innerHTML = CART.display();
                    }else if(action == '<%= FastFoodContants.EDIT_CART%>')
                    {
                        var productID = getQueryVariable('ID', hashString);
                        var newQuantity=prompt("Please enter new quantity:", '0');
                        CART.editItem(productID, newQuantity);
                        document.getElementById("content").innerHTML = CART.display();
                    }else if(action == '<%= FastFoodContants.DELETE_CART%>' )
                    {
                        var productID = getQueryVariable('ID', hashString);
                        CART.removeItem(productID);
                        document.getElementById("content").innerHTML = CART.display();
                    }else if(action == '<%= FastFoodContants.CHECKOUT%>')
                    {
                        var content = '<form action="User?Action=<%= FastFoodContants.CONFIRM_ORDER%>"';
                        content += ' method="POST" onsubmit="return onSubmitForm(this);"><br>';
                        content += 'Receive Address: <input type="text" name="ReceiveAdd" value=""/><br>';
                        content += '<input type="submit" value="Confirm Order"/></form>';
                        document.getElementById("content").innerHTML = content;
                    }else if(action == '<%= FastFoodContants.CONFIRM_ORDER%>')
                    {
                        var receiveAdd = formSubmit.ReceiveAdd.value;
                        var orderXML = CART.toXMLString();
                        var url = 'User?Action=<%= FastFoodContants.CONFIRM_ORDER%>';
                        var post = 'Order='+encodeURIComponent(orderXML)+'&ReceiveAdd='+receiveAdd;
                        var respond = XMLRequest(url,"POST", post);
                        CART.clear();//clear cart
                        document.getElementById("content").innerHTML = respond;
                    }else if(action == '<%= FastFoodContants.PRINT_PDF%>')
                    {
                        var orderID = getQueryVariable('ID', hashString);
                        var url = 'User?Action=<%= FastFoodContants.PRINT_PDF%>&ID='+orderID;
                        var win=window.open(url, '_blank');
                        win.focus();
                    }else if(action == '<%= FastFoodContants.LIST_OLD_ORDER%>'){
                        var url = 'User?Action=<%= FastFoodContants.LIST_OLD_ORDER%>';
                        var respond = XMLRequest(url,"GET", null);
                        document.getElementById("content").innerHTML = respond;
                    }

                    formSubmit = null;
                    location.hash = '#Action=Done';
                }

                //Order area
                var CART = {
                    items: [],
                    addItem: function(productID, quantity)
                    {                       
                        var numQu = Number(quantity);
                        if(isNaN(quantity)== true)
                        {
                            alert('Please input integer');
                            return;
                        }
                        for(var i = 0; i < this.items.length; i++)
                        {
                            if(this.items[i][0] == productID)
                            {
                                this.items[i][1] = numQu + Number(this.items[i][1]);
                                alert('Your item was added');
                                return;
                            }
                        }
                        this.items[this.items.length] = [productID, numQu];
                        alert('Your item was added');
                    },
                    getItem: function()
                    {
                        return this.items;
                    },
                    display: function()
                    {
                        var total = 0;
                        var content = '';                       
                        content += '<table border="1"><tr><th>ID</th><th>Name</th><th>Price</th><th>Quantiy</th><th>Total</th><th></th></tr>';
                        for(var i = 0; i<this.items.length;i++)
                        {
                            xmlObj.setProperty("SelectionLanguage","XPath");
                            var path = '//ProductView[ID = '+this.items[i][0]+']';
                            var nodes=xmlObj.selectNodes(path);
                            var productView = nodes[0];
                            var productName = productView.childNodes[1].childNodes[0].nodeValue;
                            var productPrice = productView.childNodes[2].childNodes[0].nodeValue;
                            content += '<tr><td>'+this.items[i][0]+'</td><td>'+productName
                            content += '</td><td>'+productPrice + '</td><td>'+this.items[i][1];
                            content += '</td><td>'+this.items[i][1]*productPrice+'</td>';
                            content += '<td><a href="#Action=EditCart&ID='+this.items[i][0];
                            content += '">Edit</a> | <a href="#Action=DeleteCart&ID='+this.items[i][0]+'">Delete</a></td></tr>';
                            total += this.items[i][1]*productPrice;
                        }
                        content += '</td><td colspan="4"></td><td>'+total+'</td></tr>';
                        content += '</table>';
                        if(this.items.length > 0)
                        {
                            content += '<a href="#Action=Checkout">Check out</a>';

                        }
                        content += '<a href="#Action=ListOldOrder">View Old Order</a>';
                        return content;
                    },
                    editItem: function(productID, quantity)
                    {
                        if(isNaN(quantity)== true)
                        {
                            alert('Please input integer');
                            return;
                        }
                        for(var i = 0; i < this.items.length; i++)
                        {
                            if(this.items[i][0] == productID)
                            {
                                this.items[i][1] = quantity;
                                return true;
                            }
                        }
                        return false;
                    },
                    removeItem: function(productID)
                    {
                        var itemsTemp = [];
                        for(var i = 0; i < this.items.length; i++)
                        {
                            if(this.items[i][0] != productID)
                            {
                                itemsTemp[itemsTemp.length-1] = this.items[i];
                            }
                        }
                        this.items = itemsTemp;
                    },
                    toXMLString: function()
                    {
                        var XMLString = '<Order xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" ';
                        XMLString += 'xmlns="http://xml.netbeans.org/schema/Order" ';
                        XMLString += 'xsi:schemaLocation="http://xml.netbeans.org/schema/Order Order.xsd" >';
                        for(var i = 0; i < this.items.length;i++)
                        {
                            XMLString += '<OrderDetail><ID>'+this.items[i][0];
                            XMLString += '</ID><Quantity>'+this.items[i][1];
                            XMLString += '</Quantity></OrderDetail>';
                        }
                        XMLString += '</Order>';
                        return XMLString;
                    },clear: function()
                    {
                        this.items = [];
                    }
                }
                 
                //End order area


                // Product View
                var xmlObj, xsltObj, tranFObj;

                function init()
                {
                    xmlObj = new ActiveXObject('MSXML2.DOMDocument.6.0');
                    xmlObj.async = false;
                    xmlObj.load('Data/products.xml');
                
                    xsltObj=new ActiveXObject('MSXML2.FreeThreadedDOMDocument.6.0');
                    xsltObj.async = false;
                    xsltObj.load('Style/products.xsl');

                    tranFObj   = new ActiveXObject("Msxml2.XSLTemplate.6.0");
                    tranFObj.stylesheet = xsltObj;
                }

                function listProductByCateID(cateID)
                {
                    var objXSLTProc = tranFObj.createProcessor();
                    objXSLTProc.input = xmlObj;
                    objXSLTProc.addParameter("cateIDIn", cateID, "");
                    var result = objXSLTProc.transform();
                    console.log(result);
                    //console.log(objXSLTProc.output);
                    document.getElementById("content").innerHTML = objXSLTProc.output;
                }
                //End product view

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
                var formSubmit;
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
                            return $(opt).value;
                        }) : ((type == 'radio' || type == 'checkbox') && !el.checked) ? null : el.value;

                        if (value != null) rv = rv + "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(value);
                    }
                    return (rv.length > 0) ? rv.substring(1) : rv;
                };
        </script>
    </body>
</html>
