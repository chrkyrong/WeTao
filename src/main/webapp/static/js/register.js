/**
 * Created by Administrator on 2018/10/3.
 */
function checkuId() {
    var uId=$("#uId").val();
    if(uId=="undefined"|| uId == null|| uId == "")
    {
        alert("账号不能为空");
        return false;
    }
    else
        return true;
}

function checknickname() {
    var uUserName=$("#uUserName").val();
    if(uUserName=="undefined"|| uUserName == null|| uUserName == "")
    {
        alert("昵称不能为空");
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
    var password1=$("#uPassword").val();
    if(password1=="undefined"|| password1 == null|| password1 == "")
    {
        alert("密码不能为空");
        return false;
    }
    else
        return true;
}

function recheckpassword() {
    var password1=$("#uPassword").val();
    var password2=$("#uPassword2").val();
    if(password1!=password2)
    {
        alert("两次密码输入不一致,请重新输入");
        return false;
    }
    else
        return true;
    
}

function checkaddress() {
    var uAddress1=$("#uAddress1").val();
    if(uAddress1=="undefined"|| uAddress1 == null|| uAddress1 == "")
    {
        alert("默认地址不能为空");
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
    else
    {
        alert("输入信息有误，请检查");
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