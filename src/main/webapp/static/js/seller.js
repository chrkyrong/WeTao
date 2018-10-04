/**
 * Created by hzb on 2018/10/01.
 */

//商家登陆
function login() {
    $.ajax({
        type: 'post',
        url: '/seller/login',
        dataType: 'json',
        data: $('#login').serialize(),
        success: function (r) {
            if(r.code==0) {
                window.location.href = "items-Homepage.html";
            }
            else if(r.code==109) {
                alert("用户被锁定");
            }
            else if(r.code==102)
            {
                alert("用户名不存在");
            }
            else if(r.code==105)
            {
                alert("用户密码错误,请重试");
            }
            else
            {
                alert("未知错误");
            }
            console.log(r);
        }
    });
}

//用户退出
function exit() {
    $.ajax({
        type: 'get',
        url: '/seller/logout',
        dataType: 'json',
        data: null,
        success: function () {
            window.location.href="seller_login.html";
        }
    });
}

//商家注册
function register() {
    var account = $("#sAccount").val();
    var password = $("#sPassword").val();
    var rpt = $("#sPassword_rpt").val();
    var tel = $("#sTel").val();
    var sex = $("#sSex").val();
    var address = $("#ddlProvince").find("option:selected").text()+$("#ddlCity").find("option:selected").text()+$("#ddlDistrict").find("option:selected").text()+$("#sAddress").val();
    var icon = $("#sIcon").val();
    var add = $("#sAddress").val();
    if (account.length > 0 && password.length > 0 && rpt.length > 0 && tel.length > 0 && add.length>0) {
        $.post('/seller/register',{
            sAccount : account,
            sPassword : password,
            sSex : sex,
            sTel : tel,
            sAddress : address,
            sIcon: icon,
        },function (r) {
            if(r.code==0) {
                alert("你的账号为:"+r.data.sId);
                location.reload();
            }
            else
                alert("未知错误");
        });
    } else {
        alert("请补全全部信息");
    }
}
//展示商家的个人信息
function display1() {
    $.ajax({
        type:'get',
        url:'/seller/find',
        dataType:'json',
        data:null,
        success:function (r) {
            $("#sAccount").val(r.data.sAccount);
            $("#sTel").val(r.data.sTel);
            var img = $('<img>');
            img.attr("src", "static/images/seller/"+r.data.sIcon);
            img.attr("style", "width: 250px;height: 250px;position: absolute;left: 900px;top: 100px");
            $('#huixian').append(img);
        },
    })
}
//修改商家信息
function update_info() {
    var account = $("#sAccount").val();
    var tel = $("#sTel").val();
    var sex = $("#sSex").val();
    var address = $("#ddlProvince").find("option:selected").text()+$("#ddlCity").find("option:selected").text()+$("#ddlDistrict").find("option:selected").text()+$("#sAddress").val();
    var icon = $("#sIcon").val();
    if ($("#sAddress").val().length>0) {
        $.post('/seller/modify/info',{
            sAccount : account,
            sSex : sex,
            sTel : tel,
            sAddress : address,
            sIcon : icon,
        },function (r) {
            if(r.code==0) {
                alert("个人信息修改成功");
                location.href="items-Homepage.html";
            }
            else
                alert("未知错误");
        });
    } else {
        alert("请输入地址");
    }
}
//修改并上传头像
function upload(f){
    var str = "";
    for(var i=0;i<f.length;i++){
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function(e){
            str+='<img src="'+e.target.result+'" style="width: 250px;height: 250px;position: absolute;left: 900px;top: 100px"/>';
            document.getElementById("huixian").innerHTML = str;
        }
    }
    $.ajaxFileUpload({
        url:"uploadPhoto",
        secureuri:false,//是否启动安全提交，默认为false
        fileElementId:"load",//需要上传的文件ID
        dataType:'text',
        success:function (data) {
            $("#sIcon").val(data);
        }
    })
}
//修改并上传头像
function upload1(f){
    var str = "";
    for(var i=0;i<f.length;i++){
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function(e){
            str+='<img src="'+e.target.result+'" style="width: 250px;height: 250px;position: absolute;left: 780px;top: 230px"/>';
            document.getElementById("huixian").innerHTML = str;
        }
    }
    $.ajaxFileUpload({
        url:"uploadPhoto",
        secureuri:false,//是否启动安全提交，默认为false
        fileElementId:"load",//需要上传的文件ID
        dataType:'text',
        success:function (data) {
            $("#sIcon").val(data);
        }
    })
}
//修改商家登录密码
function update_password() {
    var tel = $("#sTel").val();
    var password = $("#sPassword").val();
    var rpt = $("#sPassword_rpt").val();
    if (tel.length > 0 && password.length > 0 && rpt.length > 0) {
        $.post('/seller/modify/pass',{
            sTel : tel,
            sPassword : password,
        },function (r) {
            if(r.code==0) {
                alert("密码修改成功");
                window.location.href = "items-Homepage.html";
            } else if (r.code == 109) {
                alert("用户被锁定,将退出登录");
                exit();
            } else if (r.code == 108) {
                alert("您输入的手机有误，请重新输入");
            } else
                alert("未知错误");
        });
    }
}

