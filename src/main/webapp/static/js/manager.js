/**
 * Created by hzb on 2018/10/01.
 */

//管理员登陆
function manager_login() {
    $.ajax({
        type: 'post',
        url: '/manage/login',
        dataType: 'json',
        data: $("#manager_login").serialize(),
        success: function (r) {
            if(r.code==0) {
                window.location.href = "manage_seller.html";
            } else if (r.code==102) {
                alert("用户名不存在");
            } else if (r.code==105) {
                alert("用户密码错误,请重试");
            }else{
                alert("未知错误");
            }
            console.log(r);
        }
    });
}


// （超级）管理员添加（普通）管理员
function manageAdd() {
    if(checkManagerPsw()){
        var mPassword = $("#password1").val();
        $.ajax({
            url: '/manage/addManager',
            type: 'POST',
            dataType: 'json',
            data: {mPassword: mPassword},
            success: function (result) {
                alert("添加管理员成功,新管理员的登陆ID为："+result.data);
                location.reload();
            },
            error: function (result) {
                alert(result.message());
            }
        })
    }
}


// （超级）管理员添加（普通）管理员时，校验两次输入的密码是否一致
function checkManagerPsw() {
    var password = $("#password1").val();
    var rpt = $("#password2").val();
    if (password != rpt) {
        alert("两次输入密码不一致，请重新输入");
        return false;
    } else {
        return true;
    }
}