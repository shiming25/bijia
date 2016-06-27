package com.bijia.weixin.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.service.handle.event.LocationEventHandle;
import com.bijia.weixin.service.handle.event.MenuClickEventHandle;
import com.bijia.weixin.service.handle.event.MenuViewEventHandle;
import com.bijia.weixin.service.handle.event.SubscribeEventHandle;
import com.bijia.weixin.service.handle.event.UnsubscribeEventHandle;
import com.bijia.weixin.service.handle.message.ImgMessageHandle;
import com.bijia.weixin.service.handle.message.LinkMessageHandle;
import com.bijia.weixin.service.handle.message.LocationMessageHandle;
import com.bijia.weixin.service.handle.message.ShortVideoMessageHandle;
import com.bijia.weixin.service.handle.message.TextMessageHandle;
import com.bijia.weixin.service.handle.message.VideoMessageHandle;
import com.bijia.weixin.service.handle.message.VoiceMessageHandle;
import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;

/**
 * <Description> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class WeixinSupportImpl extends WeixinSupport {
    static final Logger log = LoggerFactory.getLogger(WeixinSupportImpl.class);

    static final String TOKEN = "bijia";

    // 设置TOKEN，用于绑定微信服务器
    @Override
    protected String getToken() {
        return TOKEN;
    }

    // 重写父类方法，处理对应的微信消息
    // @Override
    // protected BaseMsg handleTextMsg(TextReqMsg msg) {
    // String content = msg.getContent();
    // log.debug("用户发送到服务器的内容:{}", content);
    // return new TextMsg("机器人回复消息，您好!");
    // }

    @Override
    protected List<MessageHandle> initMessageHandles() {
        List<MessageHandle> handles = new ArrayList<MessageHandle>();
        handles.add(new TextMessageHandle());
        handles.add(new ImgMessageHandle());
        handles.add(new LinkMessageHandle());
        handles.add(new LocationMessageHandle());
        handles.add(new ShortVideoMessageHandle());
        handles.add(new VideoMessageHandle());
        handles.add(new VoiceMessageHandle());
        return handles;
    }

    @Override
    protected List<EventHandle> initEventHandles() {
        List<EventHandle> handles = new ArrayList<EventHandle>();
        handles.add(new SubscribeEventHandle());
        handles.add(new UnsubscribeEventHandle());
        handles.add(new LocationEventHandle());
        handles.add(new MenuClickEventHandle());
        handles.add(new MenuViewEventHandle());

        return handles;
    }

    @Override
    protected BaseMsg handleSubscribe(BaseEvent event) {
        return null;
    }
}
