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
                    if(valiEmail(form.Email)){
                        if(valiAddress(form.Address))
                        {
                            return valiPhone(form.Phone);
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
        if(valiPassword(form.Password)){
            if(valiEmail(form.Email)){
                if(valiAddress(form.Address)){
                    return valiPhone(form.Phone);
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
    }
    return true;
}

//validate function
function valiUserName(element)
{
    var pattern = /^\w{4,}$/g;
    if(!pattern.test(element.value))
    {
        message('Username must at least 4 characters contain number, _ and word');
        element.focus();
        return false;
    }
    return true;
}

//validate Password
function valiPassword(element)
{
    var pattern = /^\S{6,}$/g
    if(!pattern.test(element.value))// 6 nonspace characters  required
    {
        message('Password must at least 6 nonspace characters!');
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
    var pattern = /\w{1,}/g;
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
        message('Phone number must is 6-12 digit');
        element.focus();
        return false;
    }
    return true;
}

function message(msgString)
{
    alert(msgString);
}