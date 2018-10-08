/**
 * Created by Administrator on 2018/10/3.
 */
function checkuId() {
    var uId=$("#uId").val();
    if(uId == ""|| uId==null)
    {
        alert("账号不能为空或空格");
        return false;
    }
    else
        return true;
}

function checknickname() {
    var uUserName=$("#uUserName").val().replace(/(^\s*)|(\s*$)/g,"");
    if(uUserName == ""|| uUserName==null)
    {
        alert("昵称不能为空或空格");
        return false;
    }
    else
        return true;
}

function checkphone() {
    var phone=$("#uTel").val();
    if(!(/^1[34578]\d{9}$/.test(phone))){
        alert("手机号码格式有误，请重填");
        return false;
    }
    else
        return true;
}

function checkpassword() {
    var password1=$("#uPassword").val().replace(/(^\s*)|(\s*$)/g,"");
    if(password1 == ""|| password1==null||password1.length<6)
    {
        alert("密码不能为空或空格并不小于6");
        return false;
    }
    else
        return true;
}

function recheckpassword() {
    var password1=$("#uPassword").val().replace(/(^\s*)|(\s*$)/g,"");
    var password2=$("#uPassword2").val().replace(/(^\s*)|(\s*$)/g,"");
    if(password1!=password2)
    {
        alert("两次密码输入不一致,请重新输入");
        return false;
    }
    else
        return true;
    
}

function checkaddress() {
    var uAddress1=$("#uAddress1").val().replace(/(^\s*)|(\s*$)/g,"");
    if(uAddress1 == ""|| uAddress1==null)
    {
        alert("默认地址不能为空或空格");
        return false;
    }
    else
        return true;
}

function checkregister() {
    if(checknickname()==true&&checkphone()==true&&checkpassword()==true&&recheckpassword()==true&&checkaddress()==true)
    {
        register();
    }
}

function checkchange() {
    if(checknickname()==true&&checkphone()==true&&checkaddress()==true)
    {
        personal_update();
    }
    else
    {
        alert("输入信息有误，请检查");
    }
}

function checkchangepassword() {
    if(checkuId()==true&&checkphone()==true&&checkpassword()==true&&recheckpassword()==true)
    {
        rebackpassword();
    }
    else
    {
        alert("输入信息有误，请检查");
    }
    
}