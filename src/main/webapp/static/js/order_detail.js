/**
 * Created by Administrator on 2018/9/18.
 */
function order_detail(oId) {
    $.ajax({
        type: "get",
        url: "/detail/orderId?oId="+oId,
        dataType: "json",
        data: null,
        success: function (result) {
            var s="";
            $.each(result.data,function (i,v)
            {
                s +='<tr class="cart_item"><td class="product-thumbnail"><a href="/"><img width="180px" height="180px" src="static/wt/images/'+v.item.iPhotos+'"></a></td>';
                s +='<td data-title="Product">'+v.item.iId+'</td>';
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