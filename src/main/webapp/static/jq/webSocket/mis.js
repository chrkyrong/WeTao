/*
 * $.ajax()函数
 *
*/

var u1 = "/coll/find";
var u2 = "/coll/delete/";
/*
var u3 = "/stu/save";
var u4 = "/coll/delete/";
*/

//查询全部
function select() {
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: u1,
        data: null,
        success: function (r) {
            var s = "";
            $.each(r.data,function (i,v) {
                s+='<tr class="cart_item"><td class="product-thumbnail" width="300"><a href="catalog-product.html">';
                s+='<img width="180" height="180" src="../images/1.jpg" class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image">'+'</td><td data-title="Product" width="500"><div class="caption"><a class="product-name" href="/">'+v.iName+'</a></div></td><td  class="product-price" data-title="Price"><span class="product-price total-price"><span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol">£</span>'+v.iPrice+'</span></span></td>';
                s+='<td class="product-remove"><a onclick="del('+v.cId+')" class="btn btn-remove" title="Remove this item"><i class="fa fa-trash fa-lg"></i></a></td>';
                s+='</tr>';
            })
            $("#coll").first("tr").append(s);
        },
        error: function () {

        }
    })
}

//删除
function del(cId) {
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: u2+cId,     // /ssm/stu/delete/2
        data:null,
        success: function (r) {
            alert("删除成功！");
            location.reload();
        },
        error: function () {
            alert("删除失败！");
        }
    })
}

//保存
function save() {
    $.ajax({
        contentType: 'application/json;charset=UTF-8',   //定义编码
        type: 'post',     //post
        dataType: 'json',
        url: u3,
        data:JSON.stringify({                              //用 js将参数序列化成json
            "id":$("#id").val(),        //更新id有值，添加id为null
            "name":$("#name").val(),
            "age":$("#age").val(),
            "score":$("#score").val()
        }),

        success: function (r) {
            alert(r.msg)
        },
        error: function () {
            alert("保存失败！");
        }
    })
}



//更新
function update(id) {
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: u2+id,      //  /stu/get/2
        data:null,
        success: function (r) {
            $("#id").val(r.data.id);
            $("#name").val(r.data.name);
            $("#age").val(r.data.age);
            $("#score").val(r.data.score);
        },
        error: function () {
            alert("更新失败");
        }
    })

}


