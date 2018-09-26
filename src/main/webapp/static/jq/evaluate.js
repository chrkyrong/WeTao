// 获取URL后面的参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}


//商品详情评论的展示
function Onload1(iId) {
    iId = getQueryString('iId');
    alert(iId);
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


// 评论页面加载订单详情
function Onload2(iId) {
    iId = getQueryString('iId');
    alert(iId);
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
    console.log('submit');
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
                alert("评论成功！")
                window.location.href = 'shop_single.html?iId=8000003';
            }
            else
                alert("错误")
        }
    });
}

//文件上传
function uploadPhoto() {
    $.ajaxFileUpload({
        contentType: 'application/json;charset=UTF-8',
        url: "/evaluate/upFile1",
        secureuri: false,//是否启动安全提交，默认为false
        fileElementId: "upfilePhotoId",//需要上传的文件ID
        dataType: 'text',
        success: function (data) {
            //测试什么数据
            // alert(data + "----")
            $("#photo").html("<div style='height: 100px;width: 200px'><img height='80px' width='80px' src='" + data + "'/></div>");
        }
    })
}

//查询订单详情
function Onload3(orderId) {
    orderId = getQueryString('orderId');
    alert(orderId);
    $.ajax({
        contentType: 'application/json;charset=UTF-8',
        type: 'get',
        url: '/detail/orderId?orderId=' + orderId,
        dataType: 'json',
        data: null,
        success: function (result) {
            var s1 = "";
            var s2 = "<h2 class='typography-title' id='ORDERID'>" + orderId + "号订单 </h2>";
            var s3 = "<input type='hidden' name='order_id' id='order_id' value='" + orderId + "'/>";
            $("#orderId").first("h2").append(s2);
            $("#pa").first("input").append(s3);
            // alert(s2);
            $.each(result.data, function (i, v) {
                s1 += '<tr><td>' + v.item.iPhotos;
                s1 += '</td><td>' + v.item.iName + '</td><td>' + v.item.iPrice + '</td><td>' + v.orDeNumber + '</td>';
                s1 += '</tr>';
            })
            // alert(s1);
            $("#orderDetail").first("tr").append(s1);
        },
        error: function () {
            var s = "订单详情加载失败";
            alert(s);

        }
    })

}


function Onload4(sellerId) {
    sellerId = getQueryString('sellerId');

    alert(sellerId);
    $.ajax({
        type: 'get',
        url: '/evaluate/sellerEvaluation?sellerId=' + sellerId,
        dataType: 'json',
        data: null,
        success: function (result) {
            var s3 = "<input type='hidden' name='sellerId' id='sellerId' value='" + sellerId + "'/>";
            $("#formTest").first("input").append(s3);
            // $("#formTest").html(s3);
            var s = "<tr >\n" +
                "        <td>商品</td>\n" +
                "        <td>商店</td>\n" +
                "        <td>买家</td>\n" +
                "        <td>评论</td>\n" +
                "        <td>评级</td>\n" +
                "        <td>图片</td>\n" +
                "        <td>时间</td>\n" +
                "        <td>详情(价格)</td>\n" +
                "        <td>详情(买家留言)</td>\n" +
                "    </tr>";
            $.each(result.data, function (i, v) {
                s += '<tr><td>' + v.evaluateVo.items.iName;
                s += '</td><td>' + v.store.stName + '</td><td>' + v.evaluateVo.user.uUserName;
                s += '</td><td>' + v.evaluateVo.evaluate.eDescription + '</td><td>' + v.evaluateVo.evaluate.eLevel;
                s += '</td><td>' + v.evaluateVo.evaluate.ePhotos + '</td><td>' + v.order.oDate;
                s += '</td><td>' + v.order.oPrice + '</td><td>' + v.order.oMessage + '</td></tr>';
            })
            // alert(s1);
            $("#show").first("tr").append(s);
        },
        error: function () {
            var s = "评论加载失败";
            alert(s);
        }
    })

}

