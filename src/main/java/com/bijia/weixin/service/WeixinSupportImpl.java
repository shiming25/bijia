package com.bijia.weixin.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.service.handle.ImgMessageHandle;
import com.bijia.weixin.service.handle.TextMessageHandle;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;

/**
 * 
 * <Description> <br> 
 *  
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class WeixinSupportImpl extends WeixinSupport{
    static final Logger log = LoggerFactory.getLogger(WeixinSupportImpl.class);
    static final String TOKEN = "bijia";
    //设置TOKEN，用于绑定微信服务器
    @Override
    protected String getToken() {
        return TOKEN;
    }
    //重写父类方法，处理对应的微信消息
//    @Override
//    protected BaseMsg handleTextMsg(TextReqMsg msg) {
//        String content = msg.getContent();
//        log.debug("用户发送到服务器的内容:{}", content);
//        return new TextMsg("机器人回复消息，您好!");
//    }
    
    @Override
    protected List<MessageHandle> initMessageHandles() {
            List<MessageHandle> handles = new ArrayList<MessageHandle>();
            handles.add(new TextMessageHandle());
            handles.add(new ImgMessageHandle());
            return handles;
    }
}
