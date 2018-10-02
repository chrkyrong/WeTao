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
        value.append(content);
        //给列表添加通知
    } else {
        map[id] = content;
        //列表添加该信息

    }
}

function addChatListFromClient(msg) {
    var id = msg.toId;
    if (id in map) {
        var value = map[key];
        value.append(content);
    } else {
        map[id] = content;
    }
}

function getChatRecord(id) {
    if (id in map) {
        append(map[id]);
    } else {  //查询记录
        //获取对话历史记录
        $.ajax({
            url : '/socket/chat_record',
            dataType : 'json',
            data : {userId:id},
            type : 'GET',
            success : function (result) {
                map[id] = result.data;
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
//拼接li
//list{fromId:xxx, content:xxx, toId:xxx}
function append(list) {
    var toId = $('#toId').val();
    var contentList = $('#content_list');
    contentList.empty();
    for(var i in list) {
        var li = $('<li>');
        var h3 = $('<h3>');
        if (list.toId === toId) {
            li.attr("style", "float: right; font-size: 30px");
            h3.append(list[i].content);
            h3.append(photoMap[toId]);
            li.append(h3);
        } else {
            li.attr("style", "float: left; font-size: 30px");
            h3.append(list[i].content);
            h3.append(myPhoto);
            li.append(h3);
        }
        contentList.append(li);
        contentList.append('<br>')
    }

}