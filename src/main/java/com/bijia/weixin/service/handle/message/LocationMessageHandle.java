package com.bijia.weixin.service.handle.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.MusicMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.LocationReqMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;
import com.mongodb.DBObject;
import com.shim.util.MongoUtil;
import com.weixin.gra.pojo.UserLocation;
import com.weixin.gra.util.BaiduMapUtil;

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
        MongoUtil mongoUtil = new MongoUtil();
        MusicMsg musicMsg = new MusicMsg("");

        if (message != null) {
            // 用户发送的经纬度

            String lng = String.valueOf(message.getLocationY());
            String lat = String.valueOf(message.getLocationX());
            // 坐标转换后的经纬度
            String bd09Lng = null;
            String bd09Lat = null;
            // 调用接口转换坐标
            UserLocation userLocation = BaiduMapUtil.convertCoord(lng, lat);
            if (null != userLocation) {
                bd09Lng = userLocation.getBd09Lng();
                bd09Lat = userLocation.getBd09Lat();
            }
            JSONObject jsonObj = new JSONObject();
            jsonObj =  JSONObject.parseObject(JSONObject.toJSONString(message));
            jsonObj.put("bd09Lng", bd09Lng);
            jsonObj.put("bd09Lat", bd09Lat);
         // 保存用户地理位置
            JSONObject retobj = mongoUtil.add(jsonObj, "userLocation");
            StringBuffer buffer = new StringBuffer();
            buffer.append("[愉快]").append("成功接收您的位置！").append("\n\n");
            buffer.append("您可以输入搜索关键词获取周边信息了，例如：").append("\n");
            buffer.append("        附近ATM").append("\n");
            buffer.append("        附近KTV").append("\n");
            buffer.append("        附近厕所").append("\n");
            buffer.append("必须以“附近”两个字开头！");
            return new TextMsg(buffer.toString());
        }

        if (message != null) {

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
