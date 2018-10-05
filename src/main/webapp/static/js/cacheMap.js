var map = {};
//对方的头像
var photoMap = {};
//个人头像
var myPhoto;
function addChatListFromServer(content) {
    var msg = $.parseJSON(content.data);
    var id = msg.fromId;
    if (id in map) {
        var value = map[key];
        value.push(msg);
        //给列表添加通知
    } else {
        var arr = [];
        arr.push(msg);
        map[id] = arr;
        //拼接会话列表中的li
        var ul = $('#talk_list');
        var img = $("<img>");
        img.attr("style", "width: 30px; height: 30px;");
        img.attr("src", msg.path);
        var _content = $("<h3>");
        _content.append(img);
        _content.append(msg.userId);
        var li = $('<li>');
        li.attr("style", "padding: 20px 5px; border: thin #eeeeee; border-bottom-style: solid;");
        li.attr("onclick", "li_click(this)");
        ul.append(li);
        //添加头像到缓存中
        photoMap[msg.userId] = img;
    }
}

function addChatListFromClient(msg) {
    var id = msg.toId;
    if (id in map) {
        var value = map[id];
        value.push(msg);
    } else {
        var arr = [];
        arr.push(msg);
        map[id] = arr;
    }
}
/*
 * 获取聊天记录
 */
function getChatRecord(id) {
    if (id in map) {
        append(map[id]);
    } else {  //查询记录
        //获取对话历史记录
        $.ajax({
            url : '/socket/chat_record',
            dataType : 'json',
            data : {targetId: id},
            type : 'GET',
            success : function (result) {
                var arr = [];
                var data = result.data;
                for (var i in data)
                    arr.push(data[i]);
                map[id] = arr;
                append(map[id]);
            },
            error : function () {
                var error_li = $('<li>');
                error_li.html('出错啦！');
                error_li.attr("style", "color: red; font-size: 30px");
            }
        })
    }
}
//拼接对话框中的li
//list{fromId:xxx, content:xxx, toId:xxx}
function append(list) {
    //测试用
    myPhoto = '<img src="static/images/logo-dark.png" style="width: 30px; height: 30px;">';

    var toId = $('#toId').val();
    var contentList = $('#content_list');
    // contentList.empty();
    for(var i in list) {
        //数组元素转为json
        var data = JSON.parse(list[i]);
        var li = $("<span>");
        var div_img = $("<div>");
        var div_font = $("<div>");
        var font = $("<h4>");
        if (data.toId === toId) {
            li.attr("style", "text-align:right; font-size: 20px; margin-right: 1000px");
            div_img.attr("style", "float: right; margin-left: 20px");
            div_img.append(myPhoto);
            div_font.attr("style", "float: right; text-align: left; max-width: 40%");
            div_font.append(font);
            font.append(data.message);
            li.append(div_img);
            li.append(div_font);
        } else {
            li.attr("style", "text-align:left; font-size: 20px; margin-right: 20px");
            div_img.attr("style", "float: left; margin-right: 20px");
            div_img.attr(photoMap[toId]);
            div_font.attr("style", "text-align: left; width: 40%; padding-left: 50px");
            div_font.append(font);
            font.append(data.message);
            li.append(div_img);
            li.append(div_font);
        }
        contentList.append(li);
        contentList.append('<br>')
    }
}