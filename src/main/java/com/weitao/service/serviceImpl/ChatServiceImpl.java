package com.weitao.service.serviceImpl;

import com.weitao.bean.message.ToUser;
import com.weitao.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;

//@Service
public class ChatServiceImpl implements ChatService {

    /**
     * 引入mongodb的bean
     */
//    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ToUser> getChatList(Long uId) {
        //查询目的id或者发送id为当前账号的记录
        Criteria criteria = Criteria.where("fromId").is(uId).orOperator(Criteria.where("toId").is(uId));
        return mongoTemplate.find(query(criteria), ToUser.class);
    }

    @Override
    public List<ToUser> getChatRecord(Long uId, Long targetId, int page) {
        return null;
    }

}