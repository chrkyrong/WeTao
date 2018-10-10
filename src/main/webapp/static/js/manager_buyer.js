/**
 * Created by Administrator on 2018/10/9.
 */

//分页查询所有用户
function getusers(pageNum) {
    $.ajax({
        type: "get",
        url: "/user/all",
        dataType: "json",
        data: "pageNum="+pageNum,
        success: function (result) {
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.uId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.uUserName + '</div></td>';
                s += '<td><img width="180px" height="180px" src="static/images/user/'+v.uIcon+'"></td>';
                s += '<td data-title="Product"><div class="caption">' + v.uSex + '</div></td>';
                s += '<td data-title="Product">'+v.uTel+'</td>';
                s += '<td data-title="Product">'+v.uAddress1+'</td>';
                if(v.uAddress2==null||v.uAddress2=='')
                    v.uAddress2="无";
                s += '<td data-title="Product">'+v.uAddress2+'</td>';
                if(v.uAddress3==null||v.uAddress3=='')
                    v.uAddress3="无";
                s += '<td data-title="Product">'+v.uAddress3+'</td>';
                if (v.uStatus == 0)
                    v.uStatus = "正常";
                else
                    v.uStatus = "被封";
                s += '<td data-title="Product">'+v.uStatus+'</td>';
                s += '<td><a onclick="lockUser('+v.uId+')">封号</a><br/><br/><a onclick="unlockUser('+v.uId+')">解封</a></td></tr>';
            });
            $("#users").html(s);
            $("#users").show(s);
            console.log(result);
            fenyeByUsers(result);
        },
    });
}

//分页查询所有用户
function  fenyeByUsers(result) {
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
            getusers(1);
        });
        prePageLi.click(function(){
            getusers(result.data.pageNum-1);
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
            getusers(v);
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
            getusers(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getusers(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}

//封号
function lockUser(uId) {
    $.ajax({
        type: "get",
        url: "/user/lock?uId="+uId,
        dataType: "json",
        data: null,
        success: function (result) {
            if(result.code==0) {
                alert("成功封了该用户");
                window.location.reload();
            }
            if(result.code==109)
            {
                alert("该用户已被封");
            }
            console.log(result);
        }
    });
}

//封号
function unlockUser(uId) {
    $.ajax({
        type: "get",
        url: "/user/unlock?uId="+uId,
        dataType: "json",
        data: null,
        success: function (result) {
            if(result.code==0) {
                alert("成功解封该用户");
                window.location.reload();
            }
            if(result.code==112)
            {
                alert("该用户状态正常");
            }
            console.log(result);
        }
    });
}

//多条件查询用户
function getUsersConditions(pageNum) {
    var uId=$("#uId").val();
    var uUserName=$("#uUserName").val();
    var uTel=$("#uTel").val();
    var uAddress1=$("#uAddress1").val();
    $.ajax({
        type: "post",
        url: "/user/get/conditions",
        dataType: "json",
        data:
            {
                uId:uId,
                uUserName:uUserName,
                uAddress1:uAddress1,
                uTel:uTel,
                pageNum:pageNum,
            },
        success: function (result) {
            $("#users").empty();
            var s="";
            $.each(result.data.list,function (i,v) {
                s += '<tr class="cart_item"><td class="product-thumbnail">' + v.uId + '</td>';
                s += '<td data-title="Product"><div class="caption">' + v.uUserName + '</div></td>';
                s += '<td><img width="180px" height="180px" src="static/images/user/'+v.uIcon+'"></td>';
                s += '<td data-title="Product"><div class="caption">' + v.uSex + '</div></td>';
                s += '<td data-title="Product">'+v.uTel+'</td>';
                s += '<td data-title="Product">'+v.uAddress1+'</td>';
                if(v.uAddress2==null||v.uAddress2=='')
                    v.uAddress2="无";
                s += '<td data-title="Product">'+v.uAddress2+'</td>';
                if(v.uAddress3==null||v.uAddress3=='')
                    v.uAddress3="无";
                s += '<td data-title="Product">'+v.uAddress3+'</td>';
                if (v.uStatus == 0)
                    v.uStatus = "正常";
                else
                    v.uStatus = "被封";
                s += '<td data-title="Product">'+v.uStatus+'</td>';
                s += '<td><a onclick="lockUser('+v.uId+')">封号</a><br/><br/><a onclick="unlockUser('+v.uId+')">解封</a></td></tr>';
            });
            $("#users").html(s);
            $("#users").show(s);
            console.log(result);
            fenyeByUsersConditions(result);
        },
    });
}

//分页多条件查询用户
function  fenyeByUsersConditions(result) {
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
            getUsersConditions(1);
        });
        prePageLi.click(function(){
            getUsersConditions(result.data.pageNum-1);
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
            getUsersConditions(v);
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
            getUsersConditions(result.data.pageNum+1);
        });
        lastPageLi.click(function(){
            getUsersConditions(result.data.pages);
        });

    }
    //添加下一页和末页的提示
    ul.append(nextPageLi).append(lastPageLi);
    //把ul添加到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#fenye");
}