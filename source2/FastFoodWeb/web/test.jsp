<%-- 
    Document   : test
    Created on : Oct 13, 2013, 10:06:39 AM
    Author     : Everything
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script>
            function loadXMLDoc(dname)
            {
                if (window.ActiveXObject)
                {
                    xhttp=new ActiveXObject("Msxml2.XMLHTTP.3.0");
                }
                else
                {
                    xhttp=new XMLHttpRequest();
                }
                xhttp.open("GET",dname,false);
                xhttp.send("");
                return xhttp.responseXML;
            }

            function displayResult()
            {
                xml=loadXMLDoc("Data/categorys.xml");
                xsl=loadXMLDoc("Style/categorys.xsl");
                // code for IE
                if (window.ActiveXObject)
                {
                    ex=xml.transformNode(xsl);
                    document.getElementById("example").innerHTML=ex;
                }
                // code for Mozilla, Firefox, Opera, etc.
                else if (document.implementation && document.implementation.createDocument)
                {
                    xsltProcessor=new XSLTProcessor();
                    xsltProcessor.importStylesheet(xsl);
                    xsltProcessor.setParameter(null, "cateID", "2");
                    resultDocument = xsltProcessor.transformToDocument(xml);
                    var result = new XMLSerializer().serializeToString( resultDocument );
                    alert(result );
                    //document.getElementById("example").appendChild(resultDocument);
                    //document.write(result );
                }
            }
        </script>
    </head>
    <body onload="displayResult()">
        <div id="example" ><span>test</span></div>
    </body>
</html>

