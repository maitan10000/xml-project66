/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function validate(form)
{
    if(form.id == 'Register'){
        if(valiUserName(form.UserName)){
            if(valiPassword(form.Password)) {
                if(valiRePassword(form.Password,form.RePassword)){
                    if(valiFirstName(form.FirstName)){
                        if(valiLastName(form.LastName)){
                            if(valiEmail(form.Email)){
                                if(valiAddress(form.Address))
                                {
                                    return valiPhone(form.Phone);
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }else if(form.id == 'Reset')
    {
        return valiUserName(form.UserName);
    }else if(form.id == 'EditUser')
    {
        if(valiPassword(form.Password)) {
            if(valiRePassword(form.Password,form.RePassword)){
                if(valiFirstName(form.FirstName)){
                    if(valiLastName(form.LastName)){
                        if(valiEmail(form.Email)){
                            if(valiAddress(form.Address))
                            {
                                return valiPhone(form.Phone);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }else if(form.id == 'ConfirmOrder')
    {
        return valiAddress(form.ReceiveAdd);
    }else if(form.id == 'Login')
    {
        if(valiUserName(form.UserName)){
            return valiPassword(form.Password);
        }
        return false;
    }else if(form.id == 'Cate-Add' || form.id == 'Cate-Edit')
    {
        return valiString(form.Name, 1, 256);
    }else if(form.id == 'Product-Add' || form.id == 'Product-Edit')
    {
        if(valiString(form.Name, 1, 256)){
            return valiNumber(form.Price, 1, 15);            
        }
        return false;
    }else if(form.id == 'Admin-EditUser')
    {
        if(valiFirstName(form.FirstName)){
            if(valiLastName(form.LastName)){
                if(valiEmail(form.Email)){
                    if(valiAddress(form.Address))
                    {
                        return valiPhone(form.Phone);
                    }
                }
            }
        }
        return false;
    }else if(form.id == 'Static')
    {
        if(valiDate(form.from)){
            return valiDate(form.to);
        }
        return false;
    }
    return true;
}

//validate function
function valiUserName(element)
{
    var pattern = /^\w{4,30}$/g;
    if(!pattern.test(element.value))
    {
        message('Username must from 4-30 characters contains number, _ and word');
        element.focus();
        return false;
    }
    return true;
}

//validate Password
function valiPassword(element)
{
    var pattern = /^\S{6,30}$/g
    if(!pattern.test(element.value))// 6 nonspace characters  required
    {
        message('Password must from 6-30 nonspace characters!');
        element.focus();
        return false;
    }
    return true;
}

//validate repassword
function valiRePassword(pss, repss)
{
    if(pss.value != repss.value)//check confirm password
    {
        message('Confirm password not match!');
        repss.value = '';
        repss.focus();
        return false;
    }
    return true;
}

//validate firstname
function valiFirstName(element)
{
    var pattern = /^[\w\s]{0,50}$/g;
    if(!pattern.test(element.value))
    {
        message('Please input a valid First Name (maximum 50 characters)');
        element.focus();
        return false;
    }
    return true;
}

//validate firstname
function valiLastName(element)
{
    var pattern = /^[\w\s]{0,50}$/g;
    if(!pattern.test(element.value))
    {
        message('Please input a valid Last Name (maximum 50 characters)');
        element.focus();
        return false;
    }
    return true;
}

//validate email
function valiEmail(element)
{
    var pattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/g;
    if(!pattern.test(element.value))
    {
        message('Please input a valid email');
        element.focus();
        return false;
    }
    return true;
}

//validate address
function valiAddress(element)
{
    var pattern = /^[a-zA-Z0-9, \/]{1,256}$/g;
    if(!pattern.test(element.value))
    {
        message('Please input a valid address');
        element.focus();
        return false;
    }
    return true;
}

//validate phone
function valiPhone(element)
{
    var pattern = /^\d{6,12}$/g;
    if(!pattern.test(element.value))
    {
        message('Phone number must be 6-12 digit');
        element.focus();
        return false;
    }
    return true;
}

//validate String
function valiString(element, min, max)
{
    var pattern = new RegExp("^\\w{"+min+","+max+"}$", 'g');
    if(!pattern.test(element.value))
    {
        message('The '+element.name+' must be from '+min+' to '+max +' character!');
        element.focus();
        return false;
    }
    return true;
}

//validate number
function valiNumber(element, min, max)
{
    var pattern = new RegExp("^\\d{"+min+","+max+"}$", 'g');
    if(!pattern.test(element.value))
    {
        message('The '+element.name+' must be from '+min+' to '+max +' number!');
        element.focus();
        return false;
    }
    return true;
}

//validate date
function valiDate(element)
{
    var pattern = /^\d{1,2}\/\d{1,2}\/\d{4}$/g;
    if(!pattern.test(element.value))
    {
        message('The date must have form: dd/MM/yyyy');
        element.focus();
        return false;
    }
    return true;
}
function message(msgString)
{
    alert(msgString);
}
