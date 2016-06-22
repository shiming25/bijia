package com.bijia.weixin.service.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.MusicMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;
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
public class LocationMessageHandle<M extends BaseReqMsg> implements MessageHandle<M> {

    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(LocationMessageHandle.class);

    @Override
    public BaseMsg handle(M message) {
        MusicMsg musicMsg = new MusicMsg("");
        if(message !=null) {

            musicMsg.setHqMusicUrl("http://so1.111ttt.com:8282/2016/1/06/22/199221054197.mp3?tflag=1466564077&pin=38ba17d361b9d967d631cda406ba5cff&ip=180.100.223.13#.mp3");
            musicMsg.setMusicUrl("http://so1.111ttt.com:8282/2016/1/06/22/199221054197.mp3?tflag=1466564077&pin=38ba17d361b9d967d631cda406ba5cff&ip=180.100.223.13#.mp3");
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
