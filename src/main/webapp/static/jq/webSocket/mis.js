/**
 * Created by hzb on 2018/10/01.
 */

var u1 = "/coll/find";
var u2 = "/coll/delete/";

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
            $.each(r.data,function (i,v) {
                s+='<tr class="cart_item"><td class="product-thumbnail" width="300"><a href="shop_single.html?iId='+v.itemsId+'">';
                s+='<img width="80" height="80" src="static/images/'+v.iPhotos+'" class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image"></a>'+'</td><td data-title="Product" width="500"><div class="caption"><a class="product-name" href="shop_single.html?iId='+v.itemsId+'">'+v.iName+'</a></div></td><td  class="product-price" data-title="Price"><span class="product-price total-price"><span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">£</span>'+v.iPrice+'</span></span></td>';
                s+='<td class="product-remove"><a onclick="del('+v.cId+',this)" class="btn btn-remove" title="Remove this item"><i class="fa fa-trash fa-lg"></i></a></td>';
                s+='</tr>';
            })
            $("#coll").first("tr").append(s);
        },
        error: function () {
        }
    })
}

/**
 **************************
 **         删除         **
 **************************
 **/
function del(cId, inputobj) {
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: u2+cId,     // /ssm/stu/delete/2
        data:null,
        success: function (r) {
            alert("取消收藏成功！");
            var parentTD = inputobj.parentNode;
            var parentTR = parentTD.parentNode;
            var parentTBODY = parentTR.parentNode;
            parentTBODY.removeChild(parentTR);
        },
        error: function () {
            alert("取消收藏失败！");
        }
    })
}