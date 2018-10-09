// // 获取URL后面的参数
// function getQueryString(name) {
//     var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
//     var r = window.location.search.substr(1).match(reg);
//     if (r != null) return unescape(r[2]);
//     return null;
// }


//商品详情评论的展示
function Onload1(iId) {
    iId = getQueryString('iId');
    $.ajax({
        type: 'get',
        url: '/evaluate/selectEvaluate?iId=' + iId,
        dataType: 'json',
        data: null,
        success: function (result) {
            var s = "";
            $.each(result.data, function (i, v) {
                s += '<tr><td><img width="60px" height="60px" src="static/images/' + v.user.uIcon + '"/>';
                s += '</td><td>' + v.user.uUserName;
                s += '</td><td>' + v.evaluate.eLevel;
                // s += '</td><td><img width="50px" height="50px" src="static/images/' + v.evaluate.ePhotos + '"/>';
                if (v.evaluate.ePhotos == null || v.evaluate.ePhotos == "") {
                    s += "</td><td>无买家秀";
                }
                else {
                    s += '</td><td><center><a class = "b-goods__media js-zoom-images" href = "static/images/' + v.evaluate.ePhotos + '">';
                    s += '<img alt = "img" width="100px" height="100px" src = "static/images/' + v.evaluate.ePhotos + '" class ="img-responsive"></a><center>';
                }
                s += '</td><td>' + v.evaluate.eDescription + '</td>';
                s += '</tr>';
            })
            $("#evaluated").first("tr").append(s);
            loadpicture();
        },
        error: function () {
            var s = "评论加载失败";
            alert(s);

        }
    })

}


// 评论页面加载订单详情
function Onload2(iId) {
    iId = getQueryString('iId');
    $.ajax({
        type: 'get',
        url: '/evaluate/selectEvaluate?iId=' + iId,
        dataType: 'json',
        data: null,
        success: function (result) {
            var s = "";
            $.each(result.data, function (i, v) {
                s += '<tr><td><img width="50px" height="50px" src="static/images/' + v.user.uIcon + '"/>';
                s += '</td><td>' + v.user.uUserName + '</td><td>' + v.evaluate.eLevel + '</td><td><img width="50px" height="50px" src="static/images/' + v.evaluate.ePhotos + '"/></td><td>' + v.evaluate.eDescription + '</td>';
                s += '</tr>';
            })
            $("#evaluated").first("tr").append(s);
        },
        error: function () {
            var s = "评论加载失败";
            alert(s);

        }
    })
}


//提交评论
function confirmEvaluate() {
    var form = new FormData(document.getElementById("formTest"));
    $.ajax({
        contentType: 'application/json;charset=UTF-8',   //定义编码
        url: '/evaluate/insertEvaluate',
        type: 'POST',
        data: form,
        processData: false,
        contentType: false, /*使用formdate一定要加上去*/
        success: function (result) {
            if (result.code == "0") {
                alert("评论成功！");
                // 返回订单页面
                location.href = "order.html";
            }
            else
                alert("错误");
        }
    });
}


//文件上传
function uploadPhoto() {
    $.ajaxFileUpload({
        // contentType: 'application/json;charset=UTF-8',
        url: "/evaluate/upFile1",
        secureuri: false,//是否启动安全提交，默认为false
        fileElementId: "upfilePhotoId",//需要上传的文件ID
        dataType: 'text',
        success: function (data) {
            $("#photo").html("<div style='height: 100px;width: 200px'><img height='80px' width='80px' src='" + data + "'/></div>");
        }
    })
}

// 买家查看评论页面预加载
function Onload4() {
    $.ajax({
        type: 'post',
        url: '/evaluate/sellerEvaluation' ,
        dataType: 'json',
        data: null,
        success: function (result) {
            var s = "";
            $.each(result.data, function (i, v) {
                s += "<tr><td>" + v.evaluateVo.items.iName;
                s += "</td><td>" + v.store.stName;
                s += "</td><td>" + v.evaluateVo.user.uUserName;
                s += "</td><td>" + v.evaluateVo.evaluate.eDescription;
                s += "</td><td>" + v.evaluateVo.evaluate.eLevel;
                if (v.evaluateVo.evaluate.ePhotos == null || v.evaluateVo.evaluate.ePhotos == "") {
                    s += "</td><td>无买家秀";
                }
                else {
                    s += "</td><td><a class = 'b-goods__media js-zoom-images' href = 'static/images/" + v.evaluateVo.evaluate.ePhotos + "'>";
                    s += "<center><img alt = 'img' src = 'static/images/" + v.evaluateVo.evaluate.ePhotos + "'class ='img-responsive' style='height: 50px;width: 50px'></a></center>";
                }
                s += "</td><td>" + v.order.oDate;
                s += "</td><td><div class = 'dropdown'><span style ='color:#FFC125'>详情</span><div class = 'dropdown-content'><p>总价：" + v.order.oPrice + "</p>";
                s += "<p>留言：" + v.order.oMessage + "</p></div></div></td></tr>";

            })
            $("#show").first("tr").append(s);
        },
        error: function () {
            var s = "评论加载失败";
            alert(s);
        }
    })
}