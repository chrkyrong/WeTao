document.write("<script language='javascript' src='static/jq/jquery-2.1.4.min.js'></script>");
document.write("<script language='javascript' src='static/js/cacheMap.js'></script>");

/*
 * 发送消息的核心方法
 */
function send() {
    var toId = $('#toId').val();
    var message = $('#text').val();
    if (message === '') {
        layer.msg('不能发送空消息')
    } else {
        console.log(">>>" + toId + "<<<");
        console.log(">>>>" + message + "<<<<");
        var content = JSON.stringify({message : message, toId : toId.toString()});
        webSocket.send(content);
        $('#text').val("");
        addChatListFromClient(JSON.parse(content));
        //更新列表
        var arr = [];
        arr.push(content);
        append(arr, true);
    }
}
/*
 * 列表的点击事件,同时搜索聊天记录
 */
function li_click(id) {
    $('#talk_list').children().css('background', '#FFF');
    id.style.backgroundColor = '#ddd';
    //获取用户账号
    var toId = $('#toId');
    var uId = $(id).find("h3").text();
    if (toId.val() !== uId) {
        console.log('uId = ' + uId + ' ' + 'toId = ' + toId.val());
        toId.val(uId);
        var content_list = $('#content_list');
        content_list.empty();
        //设置对话框头部信息
        var head = $('#sell_name'); head.empty();
        var path = $(id).find("img").attr('src');
        var name = $(id).find("h3").text();
        var img = $('<img>');
        img.attr("src", path);
        img.attr("style", "width: 60px; height: 60px; margin-right: 10px");
        head.append(img);
        head.append(name);
    }
    getChatRecord(uId, false);
}
/*
 * 获取历史记录
 */
function showHistory() {
    var toId = $('#toId').val();
    getChatRecord(toId, true);
}
