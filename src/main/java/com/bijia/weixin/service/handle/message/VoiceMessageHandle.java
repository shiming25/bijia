package com.bijia.weixin.service.handle.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.VoiceMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;
import com.github.sd4324530.fastweixin.message.req.VoiceReqMsg;

/**
 * <语音消息处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @param <M>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class VoiceMessageHandle<M extends VoiceReqMsg> implements MessageHandle<M> {

    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(VoiceMessageHandle.class);
    
    @Override
    public BaseMsg handle(M message) {
        VoiceMsg voiceMsg = new VoiceMsg("");
        if(message !=null) {
             voiceMsg = new VoiceMsg(message.getMediaId());
        }
        
        return voiceMsg;
    }
    
    @Override
    public boolean beforeHandle(M message) {
        log.debug("VOICE: "+JSONObject.toJSONString(message));
        if (message != null && ReqType.VOICE.equalsIgnoreCase(message.getMsgType())) {
            return true;
        }
        return false;
    }

}
