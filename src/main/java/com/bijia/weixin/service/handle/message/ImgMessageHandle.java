package com.bijia.weixin.service.handle.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.ImageMsg;
import com.github.sd4324530.fastweixin.message.req.ImageReqMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;

/**
 * <图片消息处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @param <M>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class ImgMessageHandle<M extends ImageReqMsg> implements MessageHandle<M> {

    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(ImgMessageHandle.class);
    
    @Override
    public BaseMsg handle(M message) {
        ImageMsg imageMsg = new ImageMsg();
//        imageMsg.setMediaId("oAzOSUUKtmhULIVR_jXBVrQEWyafe2XGEuqGw9cChC8jjHND1eGR9Y2a2wYa8ry8");
        if(message !=null) {
            imageMsg.setMediaId(message.getMediaId());
        }
        return imageMsg;
    }
    
    @Override
    public boolean beforeHandle(M message) {
        log.debug("Image: "+JSONObject.toJSONString(message));
        if (message != null && ReqType.IMAGE.equalsIgnoreCase(message.getMsgType())) {
            return true;
        }
        return false;
    }

}
