package com.weitao.service;

import com.weitao.bean.message.ToUser;

import java.util.List;

public interface ChatService {

    List<ToUser> getChatList(Long uId);

    List<ToUser> getChatRecord(Long uId, Long targetId, int page);
}
