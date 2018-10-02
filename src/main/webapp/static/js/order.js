/**
 * Created by Administrator on 2018/9/18.
 */

//用户查看待发货订单
function order1(id) {
    $.ajax({
        type: "get",
        url: "/order/user/1?uId="+id,
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product"><div class="caption">';
                s += '待发货</div></td>';
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="order_detail.html?oId=' +v.oId + '">查看</a><br/><br/><a onclick="ordercancel('+v.oId+')">取消订单</a></td></tr>';
            });
            $("#order1").append(s);
            console.log(result);
        },
    });
}

//用户查看已发货订单
function order2(id) {
    $.ajax({
        type: "get",
        url: "/order/user/2?uId="+id,
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost==0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product"><div class="caption">';
                s += '配送中</div></td>';
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="order_detail.html?oId=' +v.oId + '">查看</a><br><br><a onclick="orderconfirm('+v.oId+')">到货</a></td></tr>';
            });
            $("#order2").html(s);
            console.log(result);
        }
    });
}

//用户查看已发货订单
function order3(id) {
    $.ajax({
        type: "get",
        url: "/order/user/3?uId="+id,
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost==0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product"><div class="caption">';
                s += '已到货</div></td>';
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="order_detail.html?oId=' +v.oId + '">查看</a><br><br><a href="evaluate.html?oId='+v.oId+'">评价</a><br/><br/><a onclick="orderrefund('+v.oId+')">申请退款</a></td></tr>';
            });
            $("#order3").html(s);
            console.log(result);
        }
    });
}

//用户查看已发货订单
function order9(id) {
    $.ajax({
        type: "get",
        url: "/order/user/9?uId="+id,
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost==0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product"><div class="caption">';
                s += '已评价</div></td>';
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="order_eva_detail.html?oId=' +v.oId + '">查看</a></td></tr>';
            });
            $("#order9").html(s);
            console.log(result);
        }
    });
}


//用户查看退款中订单
function order4(id) {
    $.ajax({
        type: "get",
        url: "/order/user/4?uId="+id,
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost==0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product"><div class="caption">';
                if(v.oStatus==4)
                    v.oStatus="申请退款中";
                else
                    v.oStatus="退款完成";
                s +=v.oStatus+'</div></td>';
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="order_detail.html?oId=' +v.oId + '">查看</a></td></tr>';
            });
            $("#order4").html(s);
            console.log(result);
        }
    });
}

//确定到货
function orderconfirm(oId) {
    $.ajax({
        type: "get",
        url: "/order/confirm?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            alert("确认到货成功");
            window.location.reload();
            console.log(result);
        }
    });
}

//取消订单
function ordercancel(oId) {
    $.ajax({
        type: "get",
        url: "/order/cancel?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            alert("取消订单成功");
            window.location.reload();
            console.log(result);
        }
    });
}

//退款
function orderrefund(oId) {
    $.ajax({
        type: "get",
        url: "/order/refund?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            alert("申请退款成功");
            window.location.reload();
            console.log(result);
        }
    });
}

//根据商户id查询待发货订单
function getorder1(pageNum) {
    $.ajax({
        type: "get",
        url: "/order/get/1",
        dataType: "json",
        data: "pageNum="+pageNum,
        success: function (result) {
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/><a onclick="ordersend('+v.oId+')">确定发货</a></td></tr>';
            });
            $("#order1").html(s);
            $("#order1").show(s);
            console.log(result);
            fenye1(result);
        },
    });
}

//分页查询待发货订单
function  fenye1(result) {
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
            getorder1(1);
        });
        prePageLi.click(function(){
            getorder1(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getorder1(v);
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
            getorder1(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getorder1(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

//确定发货
function ordersend(oId) {
    $.ajax({
        type: "get",
        url: "/order/send?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            alert("确认发货成功");
            window.location.reload();
            console.log(result);
        }
    });
}

//多条件查询待发货订单
function getcondition1(pageNum) {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/order/get/condition/1",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
                pageNum:pageNum,
            },
        success: function (result) {
            $("#order1").empty();
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/></td></tr>';
            });
            $("#order1").html(s);
            $("#order1").show(s);
            console.log(result);
            fenyecondition1(result);
        },
    });
}

//多条件分页查询待发货订单
function  fenyecondition1(result) {
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
            getcondition1(1);
        });
        prePageLi.click(function(){
            getcondition1(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getcondition1(v);
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
            getcondition1(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getcondition1(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}



//根据商户id查询已发货订单
function getorder2(pageNum) {
    $.ajax({
        type: "get",
        url: "/order/get/2",
        dataType: "json",
        data:"pageNum="+pageNum,
        success: function (result) {
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/></td></tr>';
            });
            $("#order2").html(s);
            $("#order2").show(s);
            console.log(result);
            fenye2(result)
        },
    });
}

//分页查询已发货订单
function  fenye2(result) {
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
            getorder2(1);
        });
        prePageLi.click(function(){
            getorder2(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getorder2(v);
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
            getorder2(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getorder2(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

//多条件查询已发货订单
function getcondition2(pageNum) {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/order/get/condition/2",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
                pageNum:pageNum,
            },
        success: function (result) {
            $("#order2").empty();
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/></td></tr>';
            });
            $("#order2").html(s);
            $("#order2").show(s);
            console.log(result);
            fenyecondition2(result);
        },
    });
}

//多条件分页查询已发货订单
function  fenyecondition2(result) {
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
            getcondition2(1);
        });
        prePageLi.click(function(){
            getcondition2(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getcondition2(v);
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
            getcondition2(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getcondition2(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}



//根据商户id查询已到货订单
function getorder3(pageNum) {
    $.ajax({
        type: "get",
        url: "/order/get/3",
        dataType: "json",
        data: "pageNum="+pageNum,
        success: function (result) {
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/></td></tr>';
            });
            $("#order3").html(s);
            $("#order3").show(s);
            console.log(result);
            fenye3(result);
        },
    });
}

//分页查询已到货订单
function  fenye3(result) {
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
            getorder3(1);
        });
        prePageLi.click(function(){
            getorder3(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getorder3(v);
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
            getorder3(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getorder3(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

//多条件查询已到货订单
function getcondition3(pageNum) {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/order/get/condition/3",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
                pageNum:pageNum,
            },
        success: function (result) {
            $("#order3").empty();
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/></td></tr>';
            });
            $("#order3").html(s);
            $("#order3").show(s);
            console.log(result);
            fenyecondition3(result);
        },
    });
}

//多条件分页查询已到货订单
function  fenyecondition3(result) {
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
            getcondition3(1);
        });
        prePageLi.click(function(){
            getcondition3(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getcondition3(v);
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
            getcondition3(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getcondition3(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}


//根据商户id查询退款中订单
function getorder4(pageNum) {
    $.ajax({
        type: "get",
        url: "/order/get/4",
        dataType: "json",
        data: "pageNum="+pageNum,
        success: function (result) {
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/><a onclick="orderbacck('+v.oId+')">确认退款</a></td></tr>';
            });
            $("#order4").html(s);
            $("#order4").show(s);
            console.log(result);
            fenye4(result);
        },
    });
}

//分页查询已退款订单
function  fenye4(result) {
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
            getorder4(1);
        });
        prePageLi.click(function(){
            getorder4(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getorder4(v);
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
            getorder4(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getorder4(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

//多条件查询退款中订单
function getcondition4(pageNum) {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/order/get/condition/4",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
                pageNum:pageNum,
            },
        success: function (result) {
            $("#order4").empty();
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/><a onclick="orderbacck('+v.oId+')">确认退款</a></td></tr>';
            });
            $("#order4").html(s);
            $("#order4").show(s);
            console.log(result);
            fenyecondition4(result);
        },
    });
}

//多条件分页查询退款中订单
function  fenyecondition4(result) {
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
            getcondition4(1);
        });
        prePageLi.click(function(){
            getcondition4(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getcondition4(v);
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
            getcondition4(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getcondition4(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}



//确认退款
function orderbacck(oId) {
    $.ajax({
        type: "get",
        url: "/order/cancel?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            alert("确认退款成功");
            window.location.reload();
            console.log(result);
        }
    });
}

//根据商户id查询已退款订单
function getorder5(pageNum) {
    $.ajax({
        type:'get',
        data:"pageNum="+pageNum,
        dateType:'json',
        url: "/order/get/5",
        success: function (result) {
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/></td></tr>';
            });
            $("#order5").html(s);
            $("#order5").show(s);
            console.log(result);
            fenye5(result);
        },
    });
}

//分页查询已退款订单
function  fenye5(result) {
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
            getorder5(1);
        });
        prePageLi.click(function(){
            getorder5(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getorder5(v);
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
            getorder5(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getorder5(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

//多条件查询已退款订单
function getcondition5(pageNum) {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/order/get/condition/5",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
                pageNum:pageNum,
            },
        success: function (result) {
            $("#order5").empty();
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.oId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.userId + '</div></td>';
                s += '<td data-title="Product"><div class="caption">' + v.oDate + '</div></td>';
                s += ' <td class="product-price" data-title="Price"> <span class="product-price total-price">';
                s += '<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">¥</span>' + v.oPrice + '</span></span></td>';
                s += '<td data-title="Product"><div class="caption">';
                if (v.oPost == 0)
                    v.oPost = "平邮";
                else
                    v.oPost = "快递";
                s +=v.oPost + '</div></td>';
                s += '<td data-title="Product"><div class="caption">';
                s +=v.oAddress;
                s += '<td data-title="Product" width="300"><div class="caption">' + v.oMessage + '</div></td>';
                s += '<td class="product-remove" width="100"><div class="caption">';
                s += '<a href="Detail-Order.html?oId=' +v.oId + '">查看</a><br/><br/></td></tr>';
            });
            $("#order5").html(s);
            $("#order5").show(s);
            console.log(result);
            fenyecondition5(result);
        },
    });
}

//多条件分页查询已退款订单
function  fenyecondition5(result) {
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
            getcondition5(1);
        });
        prePageLi.click(function(){
            getcondition5(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getcondition5(v);
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
            getcondition5(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getcondition5(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

