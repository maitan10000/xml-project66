/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



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
    //console.log(XMLRequest.responseXML);
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
    if(validate(form))
    {
        formSubmit = form;
        var vars = form.action.split('?');
        location.hash = vars[vars.length-1];
    }
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