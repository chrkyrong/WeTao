/**
 * Created by hzb on 2018/10/01.
 */

//管理员登陆
function login() {
    $.ajax({
        type: 'post',
        url: '/manager/login',
        dataType: 'json',
        data: $('#login').serialize(),
        success: function (r) {
            if(r.code==0) {
                alert("恭喜你拉！！")
                //window.location.href = "items-Homepage.html";
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