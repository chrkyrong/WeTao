/**
 * Created by Administrator on 2018/9/18.
 */
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