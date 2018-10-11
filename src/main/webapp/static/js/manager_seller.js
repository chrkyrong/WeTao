/**
 * Created by Administrator on 2018/10/10.
 */
//分页查询所有卖家
function getsellers(pageNum) {
    $.ajax({
        type: "get",
        url: "/seller/all",
        dataType: "json",
        data: "pageNum="+pageNum,
        success: function (result) {
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.sId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.sAccount + '</div></td>';
                s += '<td><img width="180px" height="180px" src="static/images/seller/'+v.sIcon+'"></td>';
                s += '<td data-title="Product"><div class="caption">' + v.sSex + '</div></td>';
                s += '<td data-title="Product">'+v.sTel+'</td>';
                s += '<td data-title="Product">'+v.sAddress+'</td>';
                if (v.sStutas == 0)
                    v.sStutas = "正常";
                else
                    v.sStutas = "被封";
                s += '<td data-title="Product">'+v.sStutas+'</td>';
                s += '<td><a onclick="lockSellers('+v.sId+')">封号</a><br/><br/><a onclick="unlockSellers('+v.sId+')">解封</a></td></tr>';
            });
            $("#sellers").html(s);
            $("#sellers").show(s);
            console.log(result);
            fenyeBySellers(result);
        },
    });
}

//分页查询所有卖家
function  fenyeBySellers(result) {
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
            getsellers(1);
        });
        prePageLi.click(function(){
            getsellers(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getsellers(v);
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
            getsellers(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getsellers(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

//封号
function lockSellers(sId) {
    $.ajax({
        type: "get",
        url: "/seller/lock?sId="+sId,
        dataType: "json",
        data: null,
        success: function (result) {
            if(result.code==0) {
                alert("成功封了该卖家");
                window.location.reload();
            }
            if(result.code==109)
            {
                alert("该卖家已被封");
            }
            console.log(result);
        }
    });
}

//解封
function unlockSellers(sId) {
    $.ajax({
        type: "get",
        url: "/seller/unlock?sId="+sId,
        dataType: "json",
        data: null,
        success: function (result) {
            if(result.code==0) {
                alert("成功解封该卖家");
                window.location.reload();
            }
            if(result.code==112)
            {
                alert("该卖家状态正常");
            }
            console.log(result);
        }
    });
}

//多条件查询卖家
function getSellersConditions(pageNum) {
    var sId=$("#sId").val();
    var sAccount=$("#sAccount").val();
    var sTel=$("#sTel").val();
    $.ajax({
        type: "post",
        url: "/seller/get/conditions",
        dataType: "json",
        data:
            {
                sId:sId,
                sAccount:sAccount,
                sTel:sTel,
                pageNum:pageNum,
            },
        success: function (result) {
            $("#sellers").empty();
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.sId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.sAccount + '</div></td>';
                s += '<td><img width="180px" height="180px" src="static/images/seller/'+v.sIcon+'"></td>';
                s += '<td data-title="Product"><div class="caption">' + v.sSex + '</div></td>';
                s += '<td data-title="Product">'+v.sTel+'</td>';
                s += '<td data-title="Product">'+v.sAddress+'</td>';
                if (v.sStutas == 0)
                    v.sStutas = "正常";
                else
                    v.sStutas = "被封";
                s += '<td data-title="Product">'+v.sStutas+'</td>';
                s += '<td><a onclick="lockSellers('+v.sId+')">封号</a><br/><br/><a onclick="unlockSellers('+v.sId+')">解封</a></td></tr>';
            });
            $("#sellers").html(s);
            $("#sellers").show(s);
            console.log(result);
            fenyeBySellersConditions(result);
        },
    });
}

//分页多条件查询卖家
function  fenyeBySellersConditions(result) {
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
            getSellersConditions(1);
        });
        prePageLi.click(function(){
            getSellersConditions(result.data.pageNum-1);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    //遍历navigatepageNums页码提示
    $.each(result.data.navigatepageNums, function (i, v) {
        var numLi = $("<li></li>").append($("<a></a>").append(v));
        if (result.data.pageNum == v) {
            numLi.addClass("active");
        }
        //添加条目单击事件
        numLi.click(function(){
            getSellersConditions(v);
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
            getSellersConditions(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getSellersConditions(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}