/**
 * Created by Administrator on 2018/9/18.
 */
function order_detail(oId) {
    $.ajax({
        type: "get",
        url: "/detail/oId?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v)
            {
                s +='<tr class="cart_item"><td class="product-thumbnail"><a href="shop_single.html?iId='+v.item.iId+'"><img width="180px" height="180px" src="static/images/'+v.item.iPhotos+'"></td>';
                s +='<td data-title="Product">'+v.orderId+'</td>';
                s +='<td data-title="Product">'+v.item.iName+'</td>';
                s +='<td data-title="Product">'+v.item.iPrice+'</td>';
                s +='<td data-title="Product">'+v.orDeNumber+'</td>';
                s +='<td data-title="Product">'+v.store.stName+'</td></tr>';
            })
            $("#order_details").append(s);
            console.log(result);
        }
    });
}

function order_eva_detail(oId) {
    $.ajax({
        type: "get",
        url: "/detail/oId?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v)
            {
                s +='<tr class="cart_item"><td class="product-thumbnail"><a href="shop_single.html?iId='+v.item.iId+'"><img width="180px" height="180px" src="static/images/'+v.item.iPhotos+'"></a></td>';
                s +='<td data-title="Product">'+v.orderId+'</td>';
                s +='<td data-title="Product">'+v.item.iName+'</td>';
                s +='<td data-title="Product">'+v.item.iPrice+'</td>';
                s +='<td data-title="Product">'+v.orDeNumber+'</td>';
                s +='<td data-title="Product">'+v.store.stName+'</td>';
                s +='<td><a href="shop_single.html?iId='+v.item.iId+'">查看商品评价</a></td></tr>';
            })
            $("#order_eva_details").append(s);
            console.log(result);
        }
    });
}