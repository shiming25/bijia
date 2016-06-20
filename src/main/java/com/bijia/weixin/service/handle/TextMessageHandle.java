package com.bijia.weixin.service.handle;

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

    @Override
    public BaseMsg handle(M message) {
        return new TextMsg("handle回复消息，您好!");
    }
    
    @Override
    public boolean beforeHandle(M message) {
        if (message != null && ReqType.TEXT.equalsIgnoreCase(message.getMsgType())) {
            return true;
        }
        return false;
    }

}
