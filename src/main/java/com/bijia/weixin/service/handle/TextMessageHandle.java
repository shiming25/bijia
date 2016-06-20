package com.bijia.weixin.service.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.bijia.weixin.service.WeixinSupportImpl;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;

/**
 * <文本消息处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @param <M>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class TextMessageHandle<M extends BaseReqMsg> implements MessageHandle<M> {

    public static final Logger log = LoggerFactory.getLogger(TextMessageHandle.class);
    
    @Override
    public BaseMsg handle(M message) {
        return new TextMsg("handle回复文本消息，您好!");
    }
    
    @Override
    public boolean beforeHandle(M message) {
        log.debug(JSONObject.toJSONString(message));
        if (message != null && ReqType.TEXT.equalsIgnoreCase(message.getMsgType())) {
            return true;
        }
        return false;
    }

}
