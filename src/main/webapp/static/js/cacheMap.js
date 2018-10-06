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
        img.attr("src", "/static/images/" + msg.sIcon);
        var _content = $("<h3>");
        _content.append(img);
        _content.append(msg.sId);
        var li = $('<li>');
        li.attr("style", "padding: 20px 5px; border: thin #eeeeee; border-bottom-style: solid;");
        li.attr("onclick", "li_click(this)");
        ul.append(li);
        //添加头像到缓存中
        photoMap[msg.userId] = msg.path;
    }
}

function addChatListFromClient(msg) {
    var id = msg.toId;
    console.log('the id is ' + id);
    if (id in map) {
        console.log('the id is in the map >>> ' + id);
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
function getChatRecord(id, isNew) {
    $('#content_list').empty();
    if (!isNew && id in map) {
        append(map[id], false);
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
                for (var i in data) {
                    console.log(data[i]);
                    arr.push(data[i]);
                }
                map[id] = arr;
                append(map[id], false);
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
function append(list, isSingle) {
    //测试用
    // myPhoto = '<img src="static/images/logo-dark.png" style="width: 30px; height: 30px;">';
    var toId = $('#toId').val();
    var contentList = $('#content_list');
    for(var i in list) {
        var data;
        if (!isSingle) {
            //数组元素转为json
            var json = JSON.stringify(list[i]);
            // console.log(json);
            data = JSON.parse(json);
        } else {
            data = JSON.parse(list[i]);
        }
        var li = $("<div>");
        var div_img = $("<div>");
        var div_font = $("<div>");
        var font = $("<h4>");
        var img = $('<img>');
        if (data.toId === toId) {
            li.addClass("right_div");
            div_img.attr("style", "float: right; margin-left: 20px");
            img.attr("src", myPhoto);
            img.attr("style", "width: 30px; height: 30px; margin-right: 20px");
            div_img.append(img);
            div_font.addClass("right_font");
            div_font.append(font);
            font.append(data.message);
            li.append(div_img);
            li.append(div_font);
        } else {
            li.addClass("left_div");
            div_img.attr("style", "float: left; margin-right: 20px");
            img.attr("src",photoMap[toId]);
            img.attr("style", "width: 30px; height: 30px; margin-left: 20px");
            div_img.attr(img);
            div_font.addClass("left_font");
            div_font.append(font);
            font.append(data.message);
            li.append(div_img);
            li.append(div_font);
        }
        contentList.append(li);
        contentList.append('<br>')
    }
}
/*
 * 初始对话列表
 */
function initChatList(msg) {
    console.log(msg);
    var json = JSON.parse(JSON.stringify(msg));
    var id = json.sId;
    var arr = [];
    arr.push(json);
    map[id] = arr;
    //拼接会话列表中的li
    var ul = $('#talk_list');
    var img = $("<img>");
    img.attr("style", "width: 30px; height: 30px; margin-right:10px");
    img.attr("src", "/static/images/" + json.sIcon);
    var _content = $("<h3>");
    _content.append(img);
    _content.append(json.sId);
    var li = $('<li>');
    li.attr("style", "padding: 20px 5px; border: thin #ddd; border-bottom-style: solid;");
    li.attr("onclick", "li_click(this)");
    li.append(_content);
    ul.append(li);
    //添加头像到缓存中
    photoMap[msg.userId] = json.sIcon;
}