package com.bijia.weixin.service.handle.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.MusicMsg;
import com.github.sd4324530.fastweixin.message.req.LocationReqMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;

/**
 * <小视频消息处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @param <M>
 * @taskId <br>
 * @CreateDate 2016年6月17日 <br>
 */
public class LocationMessageHandle<M extends LocationReqMsg> implements MessageHandle<M> {

    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(LocationMessageHandle.class);

    @Override
    public BaseMsg handle(M message) {
        MusicMsg musicMsg = new MusicMsg("");
        if(message !=null) {

            musicMsg.setHqMusicUrl("http://wwww.baidu.com");
            musicMsg.setMusicUrl("http://www.baidu.com");
            musicMsg.setThumbMediaId("XjZ8UCsM5r3D3hMyxfo7kNtaa_L21QvCCo1YQLTbsPrn_jcBecyGgIvxjArONTZr");
            musicMsg.setTitle("testTitle");
            musicMsg.setDescription("testDesc");
        }
        
        return musicMsg;
    }

    @Override
    public boolean beforeHandle(M message) {
        log.debug("LOCATION: " + JSONObject.toJSONString(message));
        if (message != null && ReqType.LOCATION.equalsIgnoreCase(message.getMsgType())) {
            return true;
        }
        return false;
    }

}
