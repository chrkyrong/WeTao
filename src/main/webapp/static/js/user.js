/**
 * Created by Administrator on 2018/9/13.
 */

//用户登陆
function login() {
    $.ajax({
        type: 'post',
        url: '/user/login',
        dataType: 'json',
        data: $('#checkout').serialize(),
        success: function (result) {
            if(result.code==0) {
                window.location.href = "home.html";
            }
            else if(result.code==109) {
                alert("用户被锁定");
            }
            else if(result.code==102)
            {
                alert("用户名不存在");
            }
            else if(result.code==105)
            {
                alert("用户密码错误,请重试");
            }
            else
            {
                alert("未知错误");
            }
            console.log(result);
        }
    });
}

//用户退出
function exit() {
    $.ajax({
        type: 'get',
        url: '/user/logout',
        dataType: 'json',
        data: null,
        success: function () {
            console.log();
            window.location.href="login.html";
        }
    });
}

//用户注册
function register() {
    $.ajax({
        type: 'post',
        url: '/user',
        dataType: 'json',
        data: $('#checkout').serialize(),
        success: function (result) {
            if(result.code==0) {
               alert("注册成功，你的账号为:"+result.data.uId);
               window.location.href="login.html";
            }
            else
                alert("未知错误");
            console.log(result);
        }
    });
}


//用户个人信息显示
function display1(uId) {
    $.ajax({
        type: 'get',
        url: '/user?uId='+uId,
        dataType: "json",
        data: null,
        success: function (result) {
            var s = "";
            s += '<li><h4>姓名(Name):';
            s += result.data.uUserName + '</h4><br></li>';
            s += '<li><h4>性别(Gender):';
            s += result.data.uSex + '</h4><br></li>';
            s += '<li><h4>联系电话(Tel):';
            s += result.data.uTel + '</h4><br></li>';
            s += '<li><h4>默认地址(Address1):';
            s += result.data.uAddress1 + '</h4><br></li>';
            s += '<li><h4>第二地址(Address2):';
            if (result.data.uAddress2 != null) {
                s += result.data.uAddress2 + '</h4><br></li>';
            }
            else
                s += '</h4><br></li>';
            s += '<li><h4>第三地址(Address3):';
            if (result.data.uAddress3 != null)
                s += result.data.uAddress3 + '</h4><br></li>';
            $("#stu").first("li").append(s);

            var img = "";
            img += '<figure class="tilter__figure">';
            img += '<img class="img-responsive"  src="static/images/';
            img += result.data.uIcon;
            img += '"alt="img">';
            img += ' </figure>';
            $("#img").first("figure").append(img);
        }
    });
}
//用户id显示（个人信息页面）
function display2(uId) {
    $.ajax({
        type: "get",
        url: "/user?uId="+uId,
        dataType: "json",
        data: null,
        success: function (result) {
            var id = "";
            id += result.data.uId;
            $("#uId").first("a").append(id);
        }
    });
}

function personal_update() {
    $.ajax({
        type: 'put',
        url:'/user',
        dataType: 'json',
        data:$('#checkout').serialize(),
        success: function (result) {
            console.log(result);
        }
    });
}

function personal(uId) {
    $.ajax({
        type: "get",
        url: "/user?uId="+uId,
        dataType: "json",
        data: null,
        success: function (result) {
            $("#uUserName").val(result.data.uUserName);
            $("#uTel").val(result.data.uTel);
            $("#uAddress1").val(result.data.uAddress1);
            $("#uAddress2").val(result.data.uAddress2);
            $("#uAddress3").val(result.data.uAddress3);
            $("#uSex").val(result.data.uSex);

            var img="";
            img+='<figure class="tilter__figure">';
            img+='<img class="img-responsive"  src="static/images/';
            img+=result.data.uIcon;
            img+='"alt="img">';
            img+=' </figure>';
            $("#img").first("figure").append(img);
        }
    });
    
}
