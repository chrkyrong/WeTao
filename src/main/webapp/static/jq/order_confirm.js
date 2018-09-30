//    预加载,查找出用户购物车的所有东西
function orderOnload1() {
    var userId = getId();
    var address = $("#address");
    $.ajax({
        url: '/car/find',
        type: 'get',
        data: null,
        success: function (result) {
            var s1 = "";
            var s2 = "";
            var money = 0.000;
            $.each(result.data, function (i, v) {
                s1 += '<tr class="cart_item"><td class="product-thumbnail"><a href="shop_single.html?iId=' + v.itemsId + '">';
                s1 += '<img src="static/images/' + v.iPhotos + '" class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image"></a></td>';
                s1 += '<td data-title="Product"><div class="caption"><a class="product-name" href="shop_single.html?iId=' + v.itemsId + '">' + v.iName + '</a></div></td>';
                s1 += '<td class="product-price" >' + v.iPrice + '</td>';
                s1 += '<td class="product-quantity" >' + v.number + '</td>';
                s1 += '<td class="product-subtotal" data-title="Total"><span class="woocommerce-Price-amount amount">' + v.totalPrice + '</span></td>';
                s1 += '</tr>';
                money += (v.totalPrice) * 1;
            })
            s1 += '<tr><td colspan="6" class="actions"><strong>留 言：</strong><input type="text"';
            s1 += 'placeholder="有什么留言想对卖家说嘛?（要顺丰加急？易碎物品）"';
            s1 += 'style="width: 500px" id="oMessage" name="oMessage"></td></tr>';

            $("#car").first("strong").append(s1);
            s2 += '<strong><span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">总价：</span>';
            s2 += money.toFixed(3);
            s2 += '</span></strong>';
            $("#totalPrice").first("tr").append(s2);


        }, error: function () {
        }
    })
}


// 确认下单按钮事件
function orderConfirm() {
    var address = $("#address").val();
    var oPost = $("#oPost").val();
    var oMessage = $("#oMessage").val();
    $.ajax({
        url: '/order/addOrders',
        type: 'post',
        dataType: 'json',
        data: {oPost: oPost, oAddress: address, oMessage: oMessage},
        success: function (result) {
            var count = result.data.length;
//                alert(count);
//                    判断返回的oId是否为空，为空则库存不足，下单失败
            $.each(result.data, function (i, v) {
                if (v.oId == null) {
                    alert(v.oMessage);
                    location.href="cart.html";
                }
                else {
                    alert("下单成功");
//                            跳转到我的订单页面
                    location.href="order.html";
                }
            })
        }
    })
}