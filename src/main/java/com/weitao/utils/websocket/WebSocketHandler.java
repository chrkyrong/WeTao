package com.weitao.utils.websocket;


import com.weitao.bean.message.ToUser;
import com.weitao.utils.websocket.config.SystemConfig;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消息收发类
 */
/*@Service*/
public final class WebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private WebSocketService webSocketService;

    /**
     * 建立连接
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketService.addSession(session);
    }

    /**
     * 处理消息
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("进入了handleMessage方法");
        ToUser user = (ToUser) JSONObject.toBean(JSONObject.fromObject(message.getPayload()), ToUser.class);
        user.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        user.setFromId((String)session.getAttributes().get("userId"));
        System.out.println("user对象内容为：" + user.toString());
        if (String.valueOf(user.getFromId()).equals(SystemConfig.adminId)) {    //管理员推送系统消息
            webSocketService.sendToAllUsers(user);
        } else {
            webSocketService.sendToUser(user, session);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println(exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        webSocketService.removeSession(session);
    }

}
