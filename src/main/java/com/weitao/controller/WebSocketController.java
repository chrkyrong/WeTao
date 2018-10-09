package com.weitao.controller;

import com.weitao.bean.message.ToUser;
import com.weitao.service.ChatService;
import com.weitao.service.UserService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/socket")
public class WebSocketController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;

    /**
     * 获取聊天列表
     * @param uId 用户的id
     * @return 最近聊天列表
     */
    @GetMapping("/chat_list")
    public Result getChatList(@SessionAttribute(value = "uId", required = false)Long uId,
                              @SessionAttribute(value = "sId", required = false)Long sId) {
        Long id = uId == null ? sId : uId;
        Result<List<ToUser>> result = new Result<>();
        result.setData(chatService.getChatList(id));
        return result;
    }

    /**
     * 获取聊天记录
     * @param uId 用户id
     * @param targetId 目标用户id
     * @return
     */
    @GetMapping("/chat_record")
    public Result getChatRecord(@SessionAttribute(value = "uId", required = false)Long uId,
                                @SessionAttribute(value = "sId", required = false)Long sId,
                                @RequestParam("targetId")Long targetId) {
        Long id = uId == null ? sId : uId;
        Result<List<ToUser>> result = new Result<>();
        result.setData(chatService.getChatRecord(id, targetId));
        return result;
    }

    /**
     * 根据商品id获取商家id
     * @param iId
     * @return
     */
    @GetMapping("/getSellerId")
    public Result getSellerId(@RequestParam(value = "iId")Long iId) {
        return ResultUtil.success(chatService.getSellerId(iId));
    }

    /**
     *
     * @param iId
     * @return
     */
    @GetMapping("/getUserId")
    public Result getUserId(@RequestParam(value = "iId")Integer iId) {
        return ResultUtil.success(userService.look(iId));
    }
}
