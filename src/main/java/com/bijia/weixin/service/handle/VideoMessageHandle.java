package com.bijia.weixin.service.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.VideoMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;
import com.github.sd4324530.fastweixin.message.req.VideoReqMsg;

/**
 * <视频消息处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @param <M>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class VideoMessageHandle<M extends VideoReqMsg> implements MessageHandle<M> {

    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(VideoMessageHandle.class);

    @Override
    public BaseMsg handle(M message) {
        VideoMsg videoMsg = new VideoMsg("");
        if(message !=null) {
            videoMsg.setMediaId(message.getMediaId());
            videoMsg.setTitle("视频标题");
            videoMsg.setDescription("视频描述");
        }
        
        return videoMsg;
    }

    @Override
    public boolean beforeHandle(M message) {
        log.debug("VIDEO: " + JSONObject.toJSONString(message));
        if (message != null && ReqType.VIDEO.equalsIgnoreCase(message.getMsgType())) {
            return true;
        }
        return false;
    }

}
