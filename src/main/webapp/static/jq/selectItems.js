/*搜索显示*/
function selectItems(pageNum) {
    var search=decodeURI(getQueryString("search"));
    $.ajax({
        type:"post",
        data:{pageNum:pageNum,search:search},
        url:"queryItemsSearch",
        dataType:"json",
        success:function (result){
            showItems(result);
            selectItemsfenye(result);
        }
    });
}
/*搜索显示分页条*/
/*首页分页*/
function  selectItemsfenye(result) {
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
            selectItems(1);
        });
        prePageLi.click(function(){
            selectItems(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (index, item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if (result.data.pageNum == item) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            selectItems(item);
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
            selectItems(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            selectItems(result.data.pages);
        });
    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

/*点击下拉框分页*/
function  afenye(result) {
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
            a(1);
        });
        prePageLi.click(function(){
            a(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (index, item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if (result.data.pageNum == item) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            a(item);
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
            a(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            a(result.data.pages);
        });
    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

function  updownfenye(result) {
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
            updown(1);
        });
        prePageLi.click(function(){
            updown(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (index, item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if (result.data.pageNum == item) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            updown(item);
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
            updown(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            updown(result.data.pages);
        });
    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}
/*显示商品信息*/
function showItems(result) {
    var str=""
    $("#show").html("");
    $.each(result.data.list,function(index,items){
            $("#show").append( "<div class='b-goods b-goods-4 b-goods_5-col '>" +
            "<a class='b-goods__media js-zoom-images' id='img' href=" + 'static/images/' +
            items['iPhotos'] +
            ">" +
            "<img class='img-responsive' alt='img'  src=" + 'static/images/' +
            items['iPhotos'] +
            ">" + "</a>" + "<span class='b-goods__main'><span class='b-goods__inner'><span  class='b-goods__categorie'>" +
            items['iName'] +
            "</span>" +
            "<a class='b-goods__title' href=" +
            'shop_single.html?iId=' + items['iId'] +
            ">" +
            items['iIntroduction'] +
            "</a></span><span class='b-goods__wrap'>" +
            "<span class='b-goods__price'>" +
            items['iPrice'] +
            "</span>" +
            "<a class='b-goods__cart' onclick='cart("+items['iId']+") '>" +
            ">add to cart</a></span></span>");
    });
    loadpicture();
}
/*升序*/
function a(pageNum) {
    $("#show").html("");
    var search=decodeURI(getQueryString("search"));
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
    $.post("queryItemsUp", {pageNum:pageNum,caFather: caFather, type: type, caId: caId,iName:search}, function (result) {
        showItems(result);
        afenye(result);
    })
}
/*点击子类升降序*/
function caSon() {
    a();
}
/*降序*/
function updown(pageNum) {
    $("#show").html("");
    var search=decodeURI(getQueryString("search"));
    var caFather = $("#caFather").val();
    var type = $("#type").val();
    var caId = $("#second").val();
    if (type == "i_price1") {
        var h = "i_price";
        $.post("queryItemsDown", {pageNum:pageNum, caFather: caFather, type: h, caId: caId ,iName:search}, function (result) {
            showItems(result);
            updownfenye(result);
        })
    }
    else {
        a();
    }
}
/*获得url id*/
function  search1() {
    var search=$("#search").val();
    window.location.href=encodeURI(encodeURI('shop.html?search='+search));
    /*        open("shop.html?search="+search);*/

}