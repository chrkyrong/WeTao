package com.weitao.service.serviceImpl;

import com.weitao.bean.Seller;
import com.weitao.bean.message.ToUser;
import com.weitao.service.ChatService;
import com.weitao.service.SellerService;
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

    @Autowired
    private SellerService sellerService;

    @Override
    public List<ToUser> getChatList(Long uId) {
        //查询目的id或者发送id为当前账号的记录
        Criteria criteria = new Criteria().orOperator(Criteria.where("toId").is(uId), Criteria.where("fromId").is(uId));
        return mongoTemplate.find(query(criteria), ToUser.class);
    }

    /**
     * 聊天记录
     * @param uId 用户自身
     * @param targetId 对话的另一方
     * @return
     */
    @Override
    public List<ToUser> getChatRecord(Long uId, Long targetId) {
        Criteria criteria = new Criteria().orOperator(Criteria.where("fromId").is(String.valueOf(targetId)).and("toId").is(String.valueOf(uId))
                                                    ,Criteria.where("fromId").is(String.valueOf(uId)).and("toId").is(String.valueOf(targetId)));
        return mongoTemplate.find(query(criteria), ToUser.class);
    }

    @Override
    public Seller getSellerId(Long iId) {
        return sellerService.getSellerId(iId);
    }

}
