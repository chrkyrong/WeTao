/**
 * Created by Administrator on 2018/9/18.
 */

//用户查看待发货订单
function order1(id) {
    $.ajax({
        type: "get",
        url: "/weitao/order/user/1?uId="+id,
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
        url: "/weitao/order/user/2?uId="+id,
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
        url: "/weitao/order/user/3?uId="+id,
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
                s += '<a href="order_detail.html?oId=' +v.oId + '">查看</a><br><br><a href="/">评价</a><br/><br/><a onclick="orderrefund('+v.oId+')">申请退款</a></td></tr>';
            });
            $("#order3").html(s);
            console.log(result);
        }
    });
}

//用户查看退款中订单
function order4(id) {
    $.ajax({
        type: "get",
        url: "/weitao/order/user/4?uId="+id,
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
        url: "/weitao/order/confirm?oId="+oId,
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
        url: "/weitao/order/cancel?oId="+oId,
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
        url: "/weitao/order/refund?oId="+oId,
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
function getorder1() {
    $.ajax({
        type: "get",
        url: "/weitao/order/get/1?sellerId=2",
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
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
            $("#order1").append(s);
            console.log(result);
        },
    });
}

//确定发货
function ordersend(oId) {
    $.ajax({
        type: "get",
        url: "/weitao/order/send?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            alert("确认发货成功");
            window.location.reload();
            console.log(result);
        }
    });
}

//根据商户id查询已发货订单
function getorder2() {
    $.ajax({
        type: "get",
        url: "/weitao/order/get/2?sellerId=2",
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
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
            $("#order2").append(s);
            console.log(result);
        },
    });
}

//多条件查询已发货订单
function getcondition2() {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/weitao/order/get/condition/2",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
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
            $("#order2").append(s);
            console.log(result);
        },
    });
}

//根据商户id查询已发货订单
function getorder3() {
    $.ajax({
        type: "get",
        url: "/weitao/order/get/3?sellerId=2",
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
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
            $("#order3").append(s);
            console.log(result);
        },
    });
}

//多条件查询已发货订单
function getcondition3() {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/weitao/order/get/condition/3",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
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
            $("#order3").append(s);
            console.log(result);
        },
    });
}

//根据商户id查询退款中订单
function getorder4() {
    $.ajax({
        type: "get",
        url: "/weitao/order/get/4?sellerId=2",
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
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
            $("#order4").append(s);
            console.log(result);
        },
    });
}

//多条件查询退款中订单
function getcondition4() {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/weitao/order/get/condition/4",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
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
            $("#order4").append(s);
            console.log(result);
        },
    });
}

//确认退款
function orderbacck(oId) {
    $.ajax({
        type: "get",
        url: "/weitao/order/cancel?oId="+oId,
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
function getorder5() {
    $.ajax({
        type: "get",
        url: "/weitao/order/get/5?sellerId=2",
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v) {
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
            $("#order5").append(s);
            console.log(result);
        },
    });
}

//多条件查询已退款订单
function getcondition5() {
    var sellerId=2;
    var oId=$("#oId").val();
    var userId=$("#userId").val();
    var oAddress=$("#oAddress").val();
    $.ajax({
        type: "post",
        url: "/weitao/order/get/condition/5",
        dataType: "json",
        data:
            {
                oId:oId,
                userId:userId,
                oAddress:oAddress,
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
            $("#order5").append(s);
            console.log(result);
        },
    });
}