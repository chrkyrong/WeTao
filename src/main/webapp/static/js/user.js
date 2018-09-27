/**
 * Created by Administrator on 2018/9/13.
 */

//用户登陆
function login() {
    $.ajax({
        type: 'post',
        url: '/weitao/user/login',
        dataType: 'json',
        data: $('#checkout').serialize(),
        success: function (result) {
            window.location.href="home.html";
            console.log(result);
        }
    });
}

//用户退出
function exit() {
    $.ajax({
        type: 'get',
        url: '/weitao/user/logout',
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
        url: '/weitao/user',
        dataType: 'json',
        data: $('#checkout').serialize(),
        success: function (result) {
            console.log(result);
        }
    });
}


//用户个人信息显示
function display1(uId) {
    $.ajax({
        type: 'get',
        url: '/weitao/user?uId='+uId,
        dataType: "json",
        data: null,
        success: function (result) {
            var s = "";
            s += '<li><h3>姓名(Name):';
            s += result.data.uUserName + '</h3><br></li>';
            s += '<li><h3>性别(Gender):';
            s += result.data.uSex + '</h3><br></li>';
            s += '<li><h3>联系电话(Tel):';
            s += result.data.uTel + '</h3><br></li>';
            s += '<li><h3>默认地址(Address1):';
            s += result.data.uAddress1 + '</h3><br></li>';
            s += '<li><h3>第二地址(Address2):';
            if (result.data.uAddress2 != null) {
                s += result.data.uAddress2 + '</h3><br></li>';
            }
            else
                s += '</h3><br></li>';
            s += '<li><h3>第三地址(Address3):';
            if (result.data.uAddress3 != null)
                s += result.data.uAddress3 + '</h3><br></li>';
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
function display2() {
    $.ajax({
        type: "get",
        url: "/weitao/user?uId=1000000",
        dataType: "json",
        data: null,
        success: function (result) {
            var id = "";
            id += '<a href="disply.html">';
            id += result.data.uId;
            id += '</a>';
            $("#uId").first("a").append(id);
        }
    });
}

function personal_update() {
    $.ajax({
        type: 'put',
        url:'/weitao/user',
        dataType: 'json',
        data:$('#checkout').serialize(),
        success: function (result) {
            console.log(result);
        }
    });
}

function personal() {
    $.ajax({
        type: "get",
        url: "/weitao/user?uId=1000000",
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
