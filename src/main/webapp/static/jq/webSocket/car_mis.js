/*
 * $.ajax()函数
 *
*/

var u1 = "/car/find";
var u2 = "/car/delete/";
var u3 = "/car/addNum/";
var u4 = "/car/cutNum/";

/**
 **************************
 **       查询全部       **
 **************************
 **/
function select() {
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: u1,
        data: null,
        success: function (r) {
            var s = "";
            var money = 0.000;
            $.each(r.data,function (i,v) {
                s+='<tr class="cart_item"><td class="product-thumbnail"><a href="shop_single.html?iId='+v.itemsId+'">';
                s+='<img src="static/images/'+v.iPhotos+'" class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image"></a></td>';
                s+='<td data-title="Product"><div class="caption"><a class="product-name" href="shop_single.html?iId='+v.itemsId+'">'+v.iName+'</a></div></td>';
                s+='<td class="product-price" data-title="Price"><span class="product-price total-price"><span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">£</span>'+v.iPrice+'</span></span></td>';
                s+='<td class="product-quantity" data-title="Quantity"><div class="enumerator"><span class="enumerator__btn enumerator__btn_minus js-minus_btn" onclick="cutNum('+v.itemsId+','+v.number+')"></span><input class="enumerator__input" type="text" value="'+v.number+'" size="3"><span class="enumerator__btn enumerator__btn_plus js-plus_btn" onclick="addNum('+v.itemsId+')"></span></div></td>';
                s+='<td class="product-subtotal" data-title="Total"><span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">£</span>'+v.totalPrice+'</span></td>';
                s+='<td class="product-remove"><a onclick="del('+v.itemsId+')" class="btn btn-remove" title="Remove this item"><i class="fa fa-trash fa-lg"></i></a></td>';
                s+='</tr>';
                money+=(v.totalPrice)*1;
            })
            $("#car").first("tr").append(s);
            var s2='<div class="cart-collaterals"><div class="cart_totals calculated_shipping"><h2>购 物 车 总 计：</h2>';
            s2+= '<table cellspacing="0" class="shop_table shop_table_responsive"><tr class="order-total"><th>总 计</th><td data-title="Total"><strong>';
            s2+='<span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">£</span>'+money.toFixed(3)+'</span></strong>';
            s2+='</td></tr></table>';
            s2+='<div class="wc-proceed-to-checkout"><a href="order_confirm.html" class="checkout-button button alt wc-forward">下 单(Proceed to Checkout)</a>';
            s2+='</div></div></div>'
            $("#from").append(s2);
        },
        error: function () {
        }
    })
}

/**
 **************************
 **      删除单个商品    **
 **************************
 **/
function del(iId) {
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: u2+iId,
        data:null,
        success: function (r) {
            alert("删除成功！");
            location.reload();
        },
        error: function () {
            alert("删除失败！");
            location.reload();
        }
    })
}

/**
 **************************
 **   增加单个商品数量   **
 **************************
 **/
function addNum(iId) {
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: u3+iId,
        data:null,
        success: function (r) {
            location.reload();
        },
        error:function (r) {
            location.reload();
        }
    })
}

/**
 **************************
 **   减少单个商品数量   **
 **************************
 **/
function cutNum(iId, number) {
    if (number > 1){
        $.ajax({
            type: 'get',
            dataType: 'json',
            url: u4+iId,
            data:null,
            success: function (r) {
                location.reload();
            },
            error:function (r) {
                location.reload();
            }
        })
    }
}