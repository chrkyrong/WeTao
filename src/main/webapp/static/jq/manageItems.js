function selectAll(pageNum) {
    var storeId=getQueryString("stId");
    var iStatus;
    $.ajax({
        type:'get',
        data:{pageNum:pageNum,storeId:storeId},
        dateType:'json',
        url:'selectAll',
        success:function (result) {
            /*解析并显示商品数据*/
            xianshi(result);
            /*解析并显示分页条信息*/
            fenye(result);
        }
    })
}
/*解析并显示*/
function xianshi(result) {
    var str="";
    var hr="";
    $.each(result.data.list,function (index,items) {

        if(items['iExsit']>0&&items['iStatus']==0){
            iStatus="正常"
            hr="<a href='items-update.html?iId="+items['iId']+"' >修改 </a>/<a onclick='delItems("+items['iId']+")'> 下架 </a>";

        }
        else if(items['iStatus']==2) {
            iStatus="强制下架"
            hr="没良心商家，已被强制下架，无法进行操作"
        }
        else if(items['iExsit']>0&&items['iStatus']==1){
            iStatus="暂时下架"
            hr="<a href='items-update.html?iId="+items['iId']+"'>修改 </a>/<a onclick='delItems("+items['iId']+")'> 上架 </a>"
        }
/*
        (items['iExsit']<=0&&items['iStatus']==1)
*/
        else{
            iStatus="售完"
             hr="<a href='items-update.html?iId="+items['iId']+"'>修改</a>/<a onclick='delItems("+items['iId']+")'> 上架 </a>"
        }

        str+="<tr>" +
            "<td>" + items['iId'] + "</td>" +
            "<td>" + items['iName'] + "</td>" +
            "<td><a class='b-goods__media js-zoom-images' href=" + 'static/images/' +
            items['iPhotos'] +
            ">" +
            "<img  class='img-responsive' alt='img'  src=" + 'static/images/' +
            items['iPhotos'] +
            ">" +
            "</a></td>" +
            "<td>" + items['iIntroduction'] + "</td>" +
            "<td>" + items['iExsit'] + "</td>" +
            "<td>" + items['iSale'] + "</td>" +
            "<td>" + items['iPrice'] + "</td>" +
            "<td>" + iStatus + "</td>" +
            "<td>"+hr+"</td></tr>"
    })
    $("#selectAll").html(str);
    $("#selectAll").show(str);
    loadpicture();
}
/*首页分页*/
function  fenye(result) {
    var search=$("#search").val();
    var iStatus=$("#iStatus").val();
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
            selectAll(1);
        });
        prePageLi.click(function(){
            selectAll(result.data.pageNum-1);
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
            selectAll(item);
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
            selectAll(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            selectAll(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

function chaxun() {
   fenyechun(1)
}


function fenyechun(pageNum) {
    var storeId=getQueryString("stId");
    var search=$("#search").val();
    var iStatus=$("#iStatus").val();
    $.ajax({
        type:'get',
        data:{pageNum:pageNum,search:search,iStatus:iStatus,storeId:storeId},
        dateType:'json',
        url:'sellerItems',
        success:function (result) {
            /*解析并显示学生数据*/
            xianshi(result);
            /*解析并显示分页条信息*/
            fenye1(result);
        }
    })
}

/*查询后分页*/
function  fenye1(result) {
    var search=$("#search").val();
    var iStatus=$("#iStatus").val();
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
            fenyechun(1);
        });
        prePageLi.click(function(){
            fenyechun(result.data.pageNum-1);
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
            fenyechun(item);
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
            fenyechun(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            fenyechun(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}
function delItems(iId) {
    var storeId=iId;
    $.ajax({
        type:'get',
        dataType:'json',
        url:'/deleteItems/'+iId,
        data:null,
        success: function (result) {
            if(result.code==0) {
                var txt=  "操作成功";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
                //alert("操作成功");
                setTimeout("window.location.reload()",1300);
            }
            else {
                window.wxc.xcConfirm(result.msg, window.wxc.xcConfirm.typeEnum.error);
                setTimeout("window.location.reload()",1300);
           /*     alert(result.msg)*/
            }
        },
    })
}
/*修改商品信息*/
function updateItems(iId) {
    var id=iId;
    $.ajax({
        type:'get',
        url: "queryOneItems?iId="+id,
        data:'json',
        success:function (result) {
            $.each(result.data,function (index,items) {
                $("#iId").val(items['iId']);
                $("#name").val(items['iName']);
                $("#iPrice").val(items['iPrice']);
                $("#iExsit").val(items['iExsit']);
                $("#photo").val(items['iPhotos'])
                $("#order_comments").val(items['iIntroduction'])
                $("#second").val(items['catagoryId'])
                $("#storeId").val(items['storeId'])
            })
        }
    })
}