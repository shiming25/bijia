package com.bijia.weixin.service.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;

/**
 * <文本消息处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @param <M>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class TextMessageHandle<M extends TextReqMsg> implements MessageHandle<M> {
    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(TextMessageHandle.class);

    /**
     * 发送帮助消息
     */
    public static final String helpMsgStr = "?,？，help,帮助";
    
    /**
     * 提示信息
     */
    public static final String helpStr = "?：帮助\n1：周边饭店\n2：周边宾馆\n3：周边停车场";
    
    /**
     * 查询周边饭店
     */
    public static final String oneMsgStr = "1,饭店";
    
    @Override
    public BaseMsg handle(M message) {
        //输入？ ? help 帮助 其他，查询提示
        if(message != null && helpMsgStr.contains(message.getContent())) {    
            return new TextMsg(helpStr);
        }
        
        if(message != null && oneMsgStr.contains(message.getContent())) {
            return new TextMsg("周边饭店");
        }
        
        return new TextMsg("看不懂！/::Q/::Q ，请输入机器语/:B-)/:B-)：\n"+helpStr);
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
