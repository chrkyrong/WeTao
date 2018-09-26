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
/*function Onload3(orderId) {
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

}*/


function Onload4(sellerId) {
    sellerId = getQueryString('sellerId');

    // alert(sellerId);
    $.ajax({
        type: 'get',
        url: '/evaluate/sellerEvaluation?sellerId=' + sellerId,
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
                    s += "<img alt = 'img' src = 'static/images/" + v.evaluateVo.evaluate.ePhotos + "'class ='img-responsive'></a>";
                }
                s += "</td><td>" + v.order.oDate;
                s += "</td><td><div class = 'dropdown'><span style ='color:#FFC125'>详情</span><div class = 'dropdown-content'><p>总价：" + v.order.oPrice + "</p>";
                s += "<p>留言：" + v.order.oMessage + "</p></div></div></td></tr>";

            })
            // bigger();
            // alert(s);
            $("#show").first("tr").append(s);
        },
        error: function () {
            var s = "评论加载失败";
            alert(s);
        }
    })

}

/*function onSearch() {
    var search = $('#search').val();
    var condition = $('#condition').val();
    var date = $('#date').val();
    var sellerId = $('#sellerId').val();
    $.ajax({
        url: '/evaluate/formTest',
        type: 'post',
        data: {search: search, condition: condition, date: date, sellerId: sellerId},
        success: function (result) {
            alert("成功");

            $.each(result.data, function (i, v) {
                s += '<tr><td>' + v.evaluateVo.items.iName;
                s += '</td><td>' + v.store.stName + '</td><td>' + v.evaluateVo.user.uUserName;
                s += '</td><td>' + v.evaluateVo.evaluate.eDescription + '</td><td>' + v.evaluateVo.evaluate.eLevel;
                s += '</td><td><a class="b-goods__media js-zoom-images" href="static/wt/images/' + v.evaluateVo.evaluate.ePhotos + '">' +
                    '<img alt="img" src="static/wt/images/' + v.evaluateVo.evaluate.ePhotos + '">';
                s += '</td><td>' + v.order.oDate;
                s += '</td><td>' + v.order.oPrice + '</td><td>' + v.order.oMessage + '</td></tr>';
            })
            alert(s);
            $("#show").html(s);

//                $("#show").first("tr").append(s);
        },
        error: function (result) {
            alert("失败了")
        }
    })
}*/
/*function bigger() {
    $('.js-zoom-images').magnificPopup({
        type: 'image',
        mainClass: 'mfp-with-zoom', // this class is for CSS animation below

        zoom: {
            enabled: true, // By default it's false, so don't forget to enable it

            duration: 300, // duration of the effect, in milliseconds
            easing: 'ease-in-out', // CSS transition easing function

            // The "opener" function should return the element from which popup will be zoomed in
            // and to which popup will be scaled down
            // By defailt it looks for an image tag:
            opener: function(openerElement) {
                // openerElement is the element on which popup was initialized, in this case its <a> tag
                // you don't need to add "opener" option if this code matches your needs, it's defailt one.
                return openerElement.is('img') ? openerElement : openerElement.find('img');
            }
        }
    });
}*/

