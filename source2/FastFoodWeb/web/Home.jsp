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

<c:if test="${user.role == 'Admin'}">
    <jsp:forward page="Admin/index.jsp"/>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta property="fb:admins" content="100000748729787" />
        <meta property="fb:app_id" content="122784627862612" />

        <meta property="og:title" content="Fast Food Website" />
        <meta property="og:image" content="http://xmltest.jelastic.servint.net/Data/Img/Main.jpg" />
        <meta property="og:site_name" content="Best Fast Food Website" />
        <meta property="og:description" content="Fast food menus online ★ Easy ordering ★  Enjoy fast food delivered to your door with Fast Food ★" />

        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="Style/style.css" media="screen" />
    </head>
    <body>
        <div id="fb-root"></div>
        <script>(function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=122784627862612";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>

        <div id="container">
            <div id="header">
                <h1>
			Fast Food
                </h1>
            </div>
            <div id="navigation">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#Guest?Action=About">About us</a></li>
                </ul>
                <ul class="userInfo" >
                    <c:choose>
                        <c:when test="${not empty user}">
                            <li><a href="#User?Action=ViewCart" ><span id="ViewCart">View Cart</span></a></li>
                            <li><a href="#User?Action=ViewProfile">${user.userName}</a></li>
                            <li><a href="#User?Action=Logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="#Guest?Action=Register">Register</a></li>
                            <li><a href="#User?Action=Login">Login</a></li>
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
                </div>
                <div id="aside">                  
                </div>
                <div id="footer">
			Copyright © Fast Food, 2013
                </div>
            </div>
        </div>
        <script  LANGUAGE="JavaScript">
        init();
        listProductByCateID('-1');
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
            }else if(action == 'ProductDetail')
            {
                var productID = getQueryVariable('ID', hashString);
                var url = "Guest";
                var post = "Action=ProductDetail&ID="+productID;
                XMLRequest(url,"POST", post);
                var id = respondXML.getElementsByTagName("ID")[0].childNodes[0].nodeValue;
                var name = respondXML.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                var price = respondXML.getElementsByTagName("price")[0].childNodes[0].nodeValue;
                var image = '';
                var description = '';
                try
                {
                    image = respondXML.getElementsByTagName("image")[0].childNodes[0].nodeValue;
                    description = respondXML.getElementsByTagName("description")[0].childNodes[0].nodeValue;
                }catch(e)
                {
                    console.log(e);
                }
                var cateID = respondXML.getElementsByTagName("cateID")[0].childNodes[0].nodeValue;
                var buyCount = respondXML.getElementsByTagName("buyCount")[0].childNodes[0].nodeValue;
                var content = '';
                content +='<div id="productDetail" class="productDetail">';
                content +='<img src="Data/Img/'+image+'" class="productImage"/>';
                content +='<div id="productInfo" class="productInfo">';
                content +='<h4>'+name+'</h4>';
                content +='Price: '+price +' VND';
                content +='<br>Sold: '+buyCount;
            <c:choose>
                <c:when test="${not empty user}">
                        content +='<form action="User?Action=BuyProduct" method="Post" onsubmit="return onSubmitForm(this);">';
                        content +='<input type="hidden" name="ProductID" value="'+id+'"/>';
                        content +='<br>Quantity: <input type="text" name="Quantity" size="2" value="1"/>';
                        content +='  <input type="submit" value="Buy"/>';
                        content +='</form>';
                </c:when>
                <c:otherwise>
                        content +='<br><a href="#User?Action=Login">Login to buy</a>'
                </c:otherwise>
            </c:choose>
                    content += '</div><div id="Like">';
                    content += '<div class="fb-like" data-href="http://'+location.hostname+'/#Action=ProductDetail&ID='+id+'" data-width="200"';
                    content += 'data-layout="button_count" data-show-faces="true" data-send="true"></div></div>';
                    content += '<div id="productDesc" class="productDesc">';
                    content +='<b>Description:</b> <p>'+description+'</p></div></div>';
                    
                    content += '<div id="comment"><div class="fb-comments" data-href="http://'+location.hostname+'/#Action=ProductDetail&ID='+id+'" data-numposts="5" data-order-by="reverse_time"></div>';
                    document.getElementById("content").innerHTML = content;
                    try{
                        FB.XFBML.parse(document.getElementById("like"));
                        FB.XFBML.parse(document.getElementById("comment"));
                    }catch(e)
                    {
                        console.log(e);
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
                        //console.log(post);
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
                    var content = '<form id="ConfirmOrder" action="User?Action=<%= FastFoodContants.CONFIRM_ORDER%>"';
                    content += ' method="POST" onsubmit="return onSubmitForm(this);"><br>';
                    content += 'Receive Address: <input type="text" name="ReceiveAdd" value="${user.address}"/><br>';
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
                    alert('Thank for order, we will call you to confirm the order within 15 minutes');
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
                }else if(action == '<%= FastFoodContants.VIEW_ORDER_DETAIL%>')
                {
                    var orderID = getQueryVariable('ID', hashString);
                    var url = 'User?Action=<%= FastFoodContants.VIEW_ORDER_DETAIL%>&ID='+orderID;
                    var respond = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respond;
                }else if(action == '<%= FastFoodContants.CANCEL_ORDER%>')
                {
                    var orderID = getQueryVariable('ID', hashString);
                    var url = 'User?Action=<%= FastFoodContants.CANCEL_ORDER%>&ID='+orderID;
                    var respond = XMLRequest(url,"GET", null);
                    document.getElementById("content").innerHTML = respond;
                }
                else if(action == '<%= FastFoodContants.REGISTER%>' )
                {
                    warning = false;
                    var url = 'Guest?Action=Register';
                    document.location.href= url;
                }else if(action == '<%= FastFoodContants.LOGIN%>' )
                {
                    warning = false;
                    var url = 'User?Action=Login';
                    document.location.href= url;
                } else if(action == '<%= FastFoodContants.LOGOUT%>' )
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
                }else if(action == '<%= FastFoodContants.ABOUT%>' )
                {
                    var url = 'Data/About.html';;
                    var respond = XMLRequest(url,"GET", null);
                    var content = '<div id="about">'+respond+'</div>';
                    document.getElementById("content").innerHTML = content;
                }

                formSubmit = null;
                location.hash = '#Action=Done';
            }


            //update viewcart info
            function updateViewCartInfo(productCount)
            {
                if(productCount > 0)
                {
                    document.getElementById("ViewCart").innerHTML = 'View Cart('+productCount+')';
                    document.getElementById("ViewCart").className = "ViewCart";
                }else
                {
                    document.getElementById("ViewCart").innerHTML = 'View Cart(0)';
                    document.getElementById("ViewCart").className = "";
                }

            }
            //Order area
            var CART = {
                items: [],
                addItem: function(productID, quantity)
                {
                    var numQu = Number(quantity);
                    if(isNaN(quantity)== true)
                    {
                        alert('Please input a number');
                        return;
                    }
                    for(var i = 0; i < this.items.length; i++)
                    {
                        if(this.items[i][0] == productID)
                        {
                            this.items[i][1] = numQu + Number(this.items[i][1]);
                            alert('Your item was added');
                            updateViewCartInfo(this.items.length);
                            return;
                        }
                    }
                    this.items[this.items.length] = [productID, numQu];
                    updateViewCartInfo(this.items.length);
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
                        var path = '//ProductView[ID = '+this.items[i][0]+']';
                        try{
                            xmlObj.setProperty("SelectionLanguage","XPath");
                            var nodes=xmlObj.selectNodes(path);
                            var productView = nodes[0];
                            var productName = productView.childNodes[1].childNodes[0].nodeValue;
                            var productPrice = productView.childNodes[2].childNodes[0].nodeValue;
                        }catch(e)
                        {
                            var nodes = xmlObj.evaluate( path, xmlObj, null, XPathResult.ANY_TYPE, null);
                            var result=nodes.iterateNext();
                            var productName = result.getElementsByTagName('Name')[0].innerHTML;
                            var productPrice = result.getElementsByTagName('Price')[0].innerHTML;
                        }                    
                        
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
                        content += '<a href="#Action=Checkout">Check out</a>   ';

                    }
                    content += '<a href="#Action=ListOldOrder">View Old Order</a>';
                    return content;
                },
                editItem: function(productID, quantity)
                {
                    if(isNaN(quantity)== true)
                    {
                        alert('Please input a number');
                        return;
                    }
                    for(var i = 0; i < this.items.length; i++)
                    {
                        if(this.items[i][0] == productID)
                        {
                            this.items[i][1] = quantity;
                            updateViewCartInfo(this.items.length);
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
                            itemsTemp[itemsTemp.length] = this.items[i];
                        }
                    }
                    this.items = itemsTemp;
                    updateViewCartInfo(this.items.length);
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
                    updateViewCartInfo(this.items.length);
                }
            }

            //End order area

            // Product View
            var xmlObj, xsltObj, tranFObj;

            function init()
            {
                if (window.ActiveXObject)
                {
                    xmlObj = new ActiveXObject('MSXML2.DOMDocument.6.0');
                    xmlObj.async = false;
                    xmlObj.load('Data/products.xml');

                    xsltObj=new ActiveXObject('MSXML2.FreeThreadedDOMDocument.6.0');
                    xsltObj.async = false;
                    xsltObj.load('Style/products.xsl');

                    tranFObj   = new ActiveXObject("Msxml2.XSLTemplate.6.0");
                    tranFObj.stylesheet = xsltObj;
                }else
                {
                    var XHR = new XMLHttpRequest();
                    XHR.open("GET",'Data/products.xml',false);
                    XHR.send("");
                    xmlObj = XHR.responseXML;

                    XHR.open("GET",'Style/products.xsl',false);
                    XHR.send("");
                    xsltObj = XHR.responseXML;
                }
            }

            //list product
            function listProductByCateID(cateID)
            {
                if (window.ActiveXObject)
                {
                    var objXSLTProc = tranFObj.createProcessor();
                    objXSLTProc.input = xmlObj;
                    objXSLTProc.addParameter("cateIDIn", cateID, "");
                    objXSLTProc.transform();
                    var result = objXSLTProc.output;
                }else
                {
                    xsltProcessor=new XSLTProcessor();
                    xsltProcessor.importStylesheet(xsltObj);
                    xsltProcessor.setParameter(null,"cateIDIn",cateID);
                    var resultTmp = xsltProcessor.transformToFragment(xmlObj,document);
                    var result = new XMLSerializer().serializeToString( resultTmp );
                }
                document.getElementById("content").innerHTML = result;
            }
            //End product view

        </script>
    </body>
    <script src="Script/validate.js"></script>
    <script src="Script/functions.js"></script>
    <!-- Histats.com  START  (standard)-->
    <script type="text/javascript">document.write(unescape("%3Cscript src=%27http://s10.histats.com/js15_giftop.js%27 type=%27text/javascript%27%3E%3C/script%3E"));</script>
    <a href="http://www.histats.com" target="_blank" title="website free tracking" ><script  type="text/javascript" >
    try {Histats.startgif(1,2477823,4,10053,"div#histatsC {position: absolute;top:50%;left:0px;}body>div#histatsC {position: fixed;}");
        Histats.track_hits();} catch(err){};
        </script></a>
    <noscript><style type="text/css">div#histatsC {position: absolute;top:50%;left:0px;}body>div#histatsC {position: fixed;}</style>
        <a href="http://www.histats.com" alt="website free tracking" target="_blank" ><div id="histatsC"><img border="0" src="http://s4is.histats.com/stats/i/2477823.gif?2477823&103"></div></a>
    </noscript>
    <!-- Histats.com  END  -->
</html>
