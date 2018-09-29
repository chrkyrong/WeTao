/**
 * Created by Administrator on 2018/9/13.
 */
function getId() {
    var uId;
    $.ajax({
        url:"/session/user",
        type: "get",
        data: null,
        async: false,
        //返回错误
        success: function (result) {
            uId=result.data;
            console.log(result);
        }
    });
    return uId;
}