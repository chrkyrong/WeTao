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
                    s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>&nbsp;&nbsp;OR&nbsp;&nbsp;';
                    s += '<a href = "" class="button-btn" onclick="return false,onChange3(' + v.stId + ',1); ">封锁商店</a></td></tr>';
                } else {
                    s += '</td><td><p style="color: #ac2925">违规</p>';
                    s += '</td><td>';
                    s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>&nbsp;&nbsp;OR&nbsp;&nbsp;';
                    s += '<a href = "" class="button-btn" style="color: #ac2925" onclick="return false,onChange3(' + v.stId + ',0) ">解封商店</a></td></tr>';
                }
            })
            $("#storeList").html(s);
        },
        error: function (result) {
            alert(result.message())
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
                } else {
                    s += '</td><td><p style="color: #ac2925">违规</p>';
                    s += '</td><td>';
                    s += '<a href = "seller_message.html?sellerId=' + v.sellerId + '">查看商家</a>&nbsp;&nbsp;OR&nbsp;&nbsp;';
                    s += '<a href = "" class="button-btn" style="color: #ac2925" onclick="return false,onChange3(' + v.stId + ',0) ">解封商店</a></td></tr>';
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
    var stName = $("#stName").val();
//        怎么获得stId(找老姚沟通)
    var stId;
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
function onChange2() {
//        从url中获得stId(找老姚沟通)
    var stId = getQueryString('stId');
    // 店铺状态为1
    var stStatus = 1;
    // 默认店铺名字为空
    var stName;
    $.ajax({
        url: '/store/sellerChangeStore',
        type: 'POST',
        dataType: 'json',
        data: {stName: stName, stId: stId, stStatus: stStatus},
        success: function (result) {
            alert("关闭店铺成功！");
            // 刷新当前页面
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
            alert("关闭店铺成功！");
            // 刷新当前页面
        }, error: function (result) {
            alert(result.message());
        }
    })
}


// 卖家添加店铺
function onAdd1() {
    var stName = $("#stName").val();
    var sellerId = "";
    $.ajax({
        url: '/store/addNewStore',
        type: 'POST',
        dataType: 'json',
        data: {stName: stName, sellerId: sellerId},
        success: function (result) {
            alert("添加店铺成功");
            // result.data.sellerId
//                跳转回商家的店铺管理页面
        },
        error: function (result) {
            alert(result.message())
        }
    })
}