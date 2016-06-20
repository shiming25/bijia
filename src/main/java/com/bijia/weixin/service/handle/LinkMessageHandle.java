package com.bijia.weixin.service.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;

/**
 * <链接消息处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @param <M>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class LinkMessageHandle<M extends BaseReqMsg> implements MessageHandle<M> {

    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(LinkMessageHandle.class);

    @Override
    public BaseMsg handle(M message) {
        return new TextMsg("handle回复链接消息，您好!");
    }

    @Override
    public boolean beforeHandle(M message) {
        log.debug("LINK: " + JSONObject.toJSONString(message));
        if (message != null && ReqType.LINK.equalsIgnoreCase(message.getMsgType())) {
            return true;
        }
        return false;
    }

}
