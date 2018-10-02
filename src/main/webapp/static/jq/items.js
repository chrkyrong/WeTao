/*查询3个条件完升降显示*/
function a() {
    $("#box1").html("");
    var caFather = $("#caFather").val();
    var type = $("#type").val();
    var caId = $("#second").val();
    if (type == "i_price1")/*如果点了价格降序，则要将下拉框的值改为i_price，否则他将以i_price1值去找*/
    {
        type = "i_price";
    }
    if (caFather == "") {/*如果将父类的下拉框标为不选择，则子类也要赋值为空*/
        caId = ""
    }
    $.post("queryItemsUp", {caFather: caFather, type: type, caId: caId}, function (result) {
        var str;
        $.each(result.data, function (index, items) {
            str += "<div class='product'>" +//获得图片地址
                "<div><img class='img' src=" + 'images/' + items['iPhotos'] + "></div>" +
                //获得商品名
                "<div class='p1 p'>" + items['iName'] + "</div>" +
                //获得价格
                "<div class='p2 p'>" + items['iPrice'] + "</div>" +
                //商品时间
                "<div class='p2 p'>" + items['iDate'] + "</div>" +
                //获得介绍
                "<div class='p3 p'>" + items['iIntroduction'] + "</div>" +
                "</div>";
        });

        $("#box1").html(str);
        $("#box1").show();
    })
}

function updowm() {
    var caFather = $("#caFather").val();
    var type = $("#type").val();
    var caId = $("#second").val();
    if (type == "i_price1") {
        var h = "i_price";
        $.post("queryItemsDown", {caFather: caFather, type: h, caId: caId}, function (result) {
            var str;
            $.each(result.data, function (index, items) {
                str += "<div class='product'>" +//获得图片地址
                    "<div><img class='img' src=" + 'images/' + items['iPhotos'] + "></div>" +
                    //获得商品名
                    "<div class='p1 p'>" + items['iName'] + "</div>" +
                    //获得价格
                    "<div class='p2 p'>" + items['iPrice'] + "</div>" +
                    //商品时间
                    "<div class='p2 p'>" + items['iDate'] + "</div>" +
                    //获得介绍
                    "<div class='p3 p'>" + items['iIntroduction'] + "</div>" +
                    "</div>";
            });

            $("#box1").html(str);
            $("#box1").show();
        })
    }
    else {
        a();
    }
}

function cafather() {
    a();
}

function caSon() {
    a();
}
/*通过父类查子类*/
function sonSel() {//第一个下拉框调用此方法
    var second = $("#second");
    var cafather = $("#caFather").val();//获得第一个下拉框的值
    /*  alert(cafather);//测试是否获得*/
    if (cafather != null && cafather != "" && cafather != -1) {
        //通过ajax将cafather传入后台处理
        $.post("findCafather", {cafather: cafather}, function (data) {
            var option = "<option value=''>请选择 </option>";
            for (var i = 0; i < data.length; i++) {
                var catagoryId = data[i].caId;//获取它的id值
                /* alert(data.length);//测试*/
                option += "<option value='" + catagoryId + "'>" + data[i].caName + " </option>";
            }
            second.html(option);
            second.show();
        })
    }
    else {
        $("#second").hide();
    }
}
/*首页加入购物车*/


