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
function Onload4(pageNum) {
    $.ajax({
        type: 'post',
        url: '/evaluate/sellerEvaluation' ,
        dataType: 'json',
        data: {pageNum:pageNum},
        success: function (result) {
            xianshiEva(result);
            fenyeEva(result);
        },
        error: function () {
            var s = "评论加载失败";
            alert(s);
        }
    })
}
/*显示模块公用*/
function xianshiEva(result) {
    var s = "";
    $.each(result.data.list, function (i, v) {
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
    $("#show").first("tr").html(s);
    $("#show").first("tr").show(s);
    loadpicture();
}
/*主页显示评论查询*/
function fenyeEva(result) {
        var search=$("#search").val();
        var iStatus=$("#iStatus").val();
        $("#fenye").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"))
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        //如果没有下一页，则这两个按钮不能点
        if (result.data.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            firstPageLi.click(function(){
                Onload4(1);
            });
            prePageLi.click(function(){
                Onload4(result.data.pageNum-1);
            });
        }
        ul.append(firstPageLi).append(prePageLi);
        //遍历navigatepageNums页码提示
        $.each(result.data.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.data.pageNum == item) {
                numLi.addClass("active");
            }
            //添加条目单击事件
            numLi.click(function(){
                Onload4(item);
            });
            ul.append(numLi);
        })
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"))
        if (result.data.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            //为元素添加翻页事件
            nextPageLi.click(function(){
                Onload4(result.data.pageNum+1);
            });
            lastPageLi.click(function(){
                Onload4(result.data.pages);
            });

        }
        //添加下一页和末页的提示
        ul.append(nextPageLi).append(lastPageLi);
        //把ul添加到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#fenye");

}
/*评论查询*/
function onSearch(pageNum) {
    var search = $('#searchgo').val();
    var condition = $('#condition').val();
    var date = $('#date').val();
//        alert(search+""+condition+""+date);
    $.ajax({
        url: '/evaluate/formTest',
        type: 'post',
        data: {search: search, condition: condition, date: date,pageNum:pageNum },
        success: function (result) {
           xianshiEva(result);
           fenyeSearchEva(result);
        },
        error: function () {
            alert("搜索评论失败")
        }
    })
}
/*查询分页显示*/
function fenyeSearchEva(result) {
    var search=$("#search").val();
    var iStatus=$("#iStatus").val();
    $("#fenye").empty();
    var ul = $("<ul></ul>").addClass("pagination");
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"))
    var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
    //如果没有下一页，则这两个按钮不能点
    if (result.data.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    }else{
        //为元素添加翻页事件
        firstPageLi.click(function(){
            onSearch(1);
        });
        prePageLi.click(function(){
            onSearch(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (index, item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if (result.data.pageNum == item) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            onSearch(item);
        });
        ul.append(numLi);
    })
    var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"))
    if (result.data.hasNextPage == false) {
        nextPageLi.addClass("disabled");
        lastPageLi.addClass("disabled");
    }else{
        //为元素添加翻页事件
        nextPageLi.click(function(){
            onSearch(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            onSearch(result.data.pages);
        });
    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}
