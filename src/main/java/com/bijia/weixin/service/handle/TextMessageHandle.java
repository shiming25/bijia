package com.bijia.weixin.service.handle;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;

/**
 * 
 * <文本消息处理类> <br> 
 *  
 * @author shi.ming<br>
 * @version 1.0<br>
 * @param <M>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class TextMessageHandle<M extends BaseReqMsg> implements MessageHandle<M> {

    public BaseMsg handle(M message) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean beforeHandle(M message) {
        // TODO Auto-generated method stub
        return false;
    }



    
}
