// 管理员店铺管理界面的预加载
function storeOnload1() {
    var research = "";
    var condition = "商店";
    var stStatus = 0;
    // alert(search + "-" + condition + "-" + stStatus);
    $.ajax({
        url: '/store/researchStoreByCondition',
        type: 'post',
        dataType: 'json',
        data: {research: research, condition: condition, stStatus: stStatus},
        success: function (result) {
            var s = '';
            $.each(result.data, function (i, v) {
                s += '<tr><td>' + v.stId;
                s += '</td><td>' + v.stName;
                s += '</td><td>' + v.sAccount;
                if (v.stStatus == 0) {
                    s += '</td><td>正常';
                    s += '</td><td>';
              //      s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>&nbsp;&nbsp;OR&nbsp;&nbsp;';
                    s += '<a href = "" class="button-btn" onclick="return false,onChange3(' + v.stId + ',1); ">封锁商店</a></td></tr>';
                } else if(v.stStatus == 1){
                    s += '</td><td><p style="color: #ac2925">违规</p>';
                    s += '</td><td>';
             //       s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>&nbsp;&nbsp;OR&nbsp;&nbsp;';
                    s += '<a href = "" class="button-btn" style="color: #ac2925" onclick="return false,onChange3(' + v.stId + ',0) ">解封商店</a></td></tr>';
                }else {
                    s += '</td><td><p style="color: #ac2925">停业中</p>';
                    s += '</td><td>';
             //       s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>';
                    s += '</td></tr>';
                }
            })
            $("#storeList").html(s);
        },
        error: function (result) {
            alert(result.message())
        }
    })
}

// 商家店铺管理主页预加载
function storeOnload2() {
    var stStatus = 0;
    $.ajax({
        url: '/store/sellerSearchStore',
        type: 'post',
        dataType: 'json',
        data: {stStatus: stStatus},
        success: function (result) {
            var s = '';
            $.each(result.data, function (i, v) {
                s += "<tr><td>" + v.stId;
                s += "</td><td>" + v.stName;
                s += "</td><td>正常";
                s += "</td><td><a href='StoreDetails.html?stId=" + v.stId + "&stName=" + v.stName + "'>进 入 店 铺</a>/";
                s += "<a href='' onclick='return false,onChange2(" + v.stId + ")'> 关 闭 店 铺</a></td></tr>";
            })
            $("#tableOne").html(s);
        },
        error: function (result) {
            alert(result.message);
        }
    })
}


// 管理员店铺按条件搜索
function onSearch1() {
    var research = $("#research").val();
    var condition = $('#condition').val();
    var stStatus = $('#stStatus').val();
    $.ajax({
        url: '/store/researchStoreByCondition',
        type: 'POST',
        dataType: 'json',
        data: {research: research, condition: condition, stStatus: stStatus},
        success: function (result) {
            var s = '';
            $.each(result.data, function (i, v) {
                s += '<tr><td>' + v.stId;
                s += '</td><td>' + v.stName;
                s += '</td><td>' + v.sAccount;
                if (v.stStatus == 0) {
                    s += '</td><td>正常';
                    s += '</td><td>';
                    s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>&nbsp;&nbsp;OR&nbsp;&nbsp;';
                    s += '<a href = "" class="button-btn" onclick="return false,onChange3(' + v.stId + ',1); ">封锁商店</a></td></tr>';
                }else if(v.stStatus == 1){
                    s += '</td><td><p style="color: #ac2925">违规</p>';
                    s += '</td><td>';
                    s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>&nbsp;&nbsp;OR&nbsp;&nbsp;';
                    s += '<a href = "" class="button-btn" style="color: #ac2925" onclick="return false,onChange3(' + v.stId + ',0) ">解封商店</a></td></tr>';
                }else {
                    s += '</td><td><p style="color: #ac2925">停业中</p>';
                    s += '</td><td>';
                    s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>';
                    s += '</td></tr>';
                }
            })
            $("#storeList").html(s);
        },
        error: function (result) {
            alert(result.message())
        }
    })
}


// 卖家修改店铺名字
function onChange1() {
//        从url后面获取stId
    var stId = getQueryString("stId");
    var stName = $("#stName").val();

    var stStatus = 0;
    // alert(stName);
    $.ajax({
        url: '/store/sellerChangeStore',
        type: 'POST',
        dataType: 'json',
        data: {stName: stName, stId: stId, stStatus: stStatus},
        success: function (result) {
            alert("修改店铺名成功！");
        }, error: function (result) {
            alert(result.message());
        }
    })
}


//卖家关闭该店铺
function onChange2(stId) {
    // 店铺状态为1
    var stStatus = 2;
    // 默认店铺名字为空
    var stName = null;
    $.ajax({
        url: '/store/sellerChangeStore',
        type: 'POST',
        dataType: 'json',
        data: {stName: stName, stId: stId, stStatus: stStatus},
        success: function (result) {
            alert("关闭店铺成功！");
        }, error: function (result) {
            alert(result.message());
        }
    })
}


// 管理员改变店铺状态
function onChange3(stId, stStatus) {
    $.ajax({
        url: '/store/managerChangeStore',
        type: 'POST',
        dataType: 'json',
        data: {stId: stId, stStatus: stStatus},
        success: function (result) {
            // alert("店铺状态更改成功！");
            刷新当前页面
        }, error: function (result) {
            // alert(result.message());
        }
    })
}


//卖家重开该店铺
function onChange4(stId) {
    // 店铺状态为1
    var stStatus = 0;
    // 默认店铺名字为空
    var stName = null;
    $.ajax({
        url: '/store/sellerChangeStore',
        type: 'POST',
        dataType: 'json',
        data: {stName: stName, stId: stId, stStatus: stStatus},
        success: function (result) {
            alert("重开店铺成功！");
        }, error: function (result) {
            alert(result.message());
        }
    })
}



// 卖家添加店铺
function storeOnAdd1() {
    var stName = $("#stName").val();
    $.ajax({
        url: '/store/addNewStore',
        type: 'POST',
        dataType: 'json',
        data: {stName: stName},
        success: function (result) {
            alert("添加店铺成功");
            window.history.back(-1);
            // result.data.sellerId
//                跳转回商家的店铺管理页面
        },
        error: function (result) {
            alert(result.message())
        }
    })
}