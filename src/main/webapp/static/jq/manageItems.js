function selectAll(pageNum) {
    var iStatus;
    $.ajax({
        type:'get',
        data:"pageNum="+pageNum,
        dateType:'json',
        url:'selectAll',
        success:function (result) {
            /*解析并显示学生数据*/
            xianshi(result);
            /*解析并显示分页条信息*/
            fenye(result);
        }
    })
}

function  fenye(result) {
    var search=$("#search").val();
    var iStatus=$("#iStatus").val();
    alert(search+iStatus)
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
/*解析并显示*/
function xianshi(result) {

    var str="";
    $.each(result.data.list,function (index,items) {
        if(items['iExsit']&&items['iStatus']==0){
            iStatus="正常"
        }
        else {
            iStatus="异常"
        }
        str+="<tr>" +
            "<td>" + items['iId'] + "</td>" +
            "<td>" + items['iName'] + "</td>" +
            "<td><a class='b-goods__media js-zoom-images' href=" + 'static/images/' +
            items['iPhotos'] +
            ">" +
            "<img class='img-responsive' alt='img'  src=" + 'static/images/' +
            items['iPhotos'] +
            ">" +
            "</a></td>" +
            "<td>" + items['iIntroduction'] + "</td>" +
            "<td>" + items['iExsit'] + "</td>" +
            "<td>" + items['iSale'] + "</td>" +
            "<td>" + items['iPrice'] + "</td>" +
            "<td>" + iStatus + "</td>" +
            "<td><a href='items-amend.html'>修改 </a>/<a href='#'> 删 除 </a></td></tr>"
    })
    $("#selectAll").html(str);
    $("#selectAll").show(str);
    loadpicture();
}

function chaxun() {
   fenyechun(1)
}

function fenyechun(pageNum) {
    var search=$("#search").val();
    var iStatus=$("#iStatus").val();
    $.ajax({
        type:'get',
        data:{pageNum:pageNum,search:search,iStatus:iStatus},
        dateType:'json',
        url:'sellerItems',
        success:function (result) {
            /*解析并显示学生数据*/
            xianshi(result);
            /*解析并显示分页条信息*/
            fenye(result);
        }
    })
}
