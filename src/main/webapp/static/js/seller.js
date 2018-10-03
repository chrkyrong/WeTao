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
    var tel = $("#sTel").val();
    var sex = $("#sSex").val();
    var address = $("#ddlProvince").find("option:selected").text()+$("#ddlCity").find("option:selected").text()+$("#ddlDistrict").find("option:selected").text()+$("#sAddress").val();
    var icon = $("#sIcon").val();
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
            alert(r.data.sIcon);
            var img = $('<img>');
            img.attr("src", "static/images/seller/"+r.data.sIcon);
            img.attr("style", "width: 250px;height: 250px;position: absolute;left: 610px;top: 100px");
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
}
//修改并上传头像
function upload(f){
    var str = "";
    for(var i=0;i<f.length;i++){
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function(e){
            str+='<img src="'+e.target.result+'" style="width: 250px;height: 250px;position: absolute;left: 610px;top: 100px"/>';
            document.getElementById("huixian").innerHTML = str;
        }
    }
    $.ajaxFileUpload({
        url:"uploadPhoto",
        secureuri:false,//是否启动安全提交，默认为false
        fileElementId:"load",//需要上传的文件ID
        dataType:'text',
        success:function (data) {
            alert(data);
            $("#sIcon").val(data);
        }
    })
}

function upload1(f){
    var str = "";
    for(var i=0;i<f.length;i++){
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function(e){
            str+='<img src="'+e.target.result+'" style="width: 250px;height: 250px;position: absolute;left: 530px;top: 220px"/>';
            document.getElementById("huixian").innerHTML = str;
        }
    }
    $.ajaxFileUpload({
        url:"uploadPhoto",
        secureuri:false,//是否启动安全提交，默认为false
        fileElementId:"load",//需要上传的文件ID
        dataType:'text',
        success:function (data) {
            alert(data);
            $("#sIcon").val(data);
        }
    })
}
/*//用户个人信息显示
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
    
}*/
