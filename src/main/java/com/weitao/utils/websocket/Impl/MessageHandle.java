package com.weitao.utils.websocket.Impl;


import com.weitao.bean.message.ToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

@Component
public class MessageHandle {

    //@Autowired
    private MongoTemplate template;

    /**
     * 异步调用消息存储
     * @param user
     */
    @Async
    void saveMsg(ToUser user) {
        template.save(user);
    }

    /**
     * 获取未读消息
     * @param userId 用户的id
     * @return 未读消息集
     */
    List<ToUser> getUnReadMsg(String userId) {
        Criteria criteria = Criteria.where("isRead").is(false).and("toId").is(userId);
        List<ToUser> list =  template.find(query(criteria), ToUser.class);
        //更新状态
        template.updateMulti(query(criteria), update("isRead", true), ToUser.class);
        return list;
    }

}
