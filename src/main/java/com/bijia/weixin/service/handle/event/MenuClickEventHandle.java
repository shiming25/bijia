/**************************************************************************************** 

 ****************************************************************************************/
package com.bijia.weixin.service.handle.event;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.NewsMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.EventType;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.mongodb.DBObject;
import com.shim.util.MongoUtil;
import com.weixin.gra.pojo.Article;
import com.weixin.gra.pojo.BaiduPlace;
import com.weixin.gra.pojo.UserLocation;
import com.weixin.gra.util.BaiduMapUtil;

/**
 * <菜单点击事件处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月27日 <br>
 */

public class MenuClickEventHandle<E extends MenuEvent> implements EventHandle<E> {
    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(MenuClickEventHandle.class);

    /**
     * 提示信息
     */
    public static final String helpStr = "?：帮助\n1：周边饭店\n2：周边宾馆\n3：周边停车场";

    @Override
    public BaseMsg handle(E event) {
        String menuKey = event.getEventKey();
        String keyWord = "";
        String respContent = "";
        MongoUtil mongoUtil = new MongoUtil();
        if (null != menuKey && !menuKey.isEmpty()) {
            if (menuKey.equals("aroundSubHotel")) {
                keyWord = "宾馆";
            }
            if (menuKey.equals("arroundSubFandian")) {
                keyWord = "饭店";
            }
            if (menuKey.equals("arroundSubTingche")) {
                keyWord = "停车场";
            }
            if (menuKey.equals("arroundSubSpot")) {
                keyWord = "厕所";
            }
            if (menuKey.equals("arroundSubJianshen")) {
                keyWord = "ktv";
            }

            try {
                // 获取用户最后一次发送的地理位置
                // UserLocation location = MySQLUtil.getLastLocation(request, fromUserName);
                log.debug("begin 附近查询" + event.toString());
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("fromUserName", event.getFromUserName());
                DBObject dbobj = mongoUtil.queryLastDetail(jsonObj, "userLocation");
                log.debug("begin11 dbobj" + dbobj);
                UserLocation location = JSONObject.parseObject(dbobj.toString(), UserLocation.class);
                if (null == location) {
                    return new TextMsg(getUsage());
                }
                log.debug("begin2 附近查询");
                // 根据转换后（纠偏）的坐标搜索周边POI

                List<BaiduPlace> placeList = BaiduMapUtil.searchPlace(keyWord, location.getBd09Lng(), location.getBd09Lat());
                if (null == placeList || 0 == placeList.size()) {
                    respContent = String.format("/难过，您发送的位置附近未搜索到“%s”信息！", keyWord);
                    return new TextMsg(respContent);
                }
                log.debug("begin3 附近查询");
                List<Article> articleList = BaiduMapUtil.makeArticleList(placeList, location.getBd09Lng(), location.getBd09Lat());
                NewsMsg newsMsg = new NewsMsg();
                for (Article art : articleList) {
                    newsMsg.add(art.getTitle(), art.getDescription(), art.getPicUrl(), art.getUrl());
                }
                log.debug("begin4 附近查询");
                return newsMsg;

            } catch (Exception e) {
                log.error("arround query " + ExceptionUtils.getFullStackTrace(e));

            }
            // 未搜索到POI

            return new TextMsg(getUsage());

        }

        return new TextMsg("菜单点击事件/:B-)/:B-)：\n"
                + "点击菜单key：" + event.getEventKey()
                + emoji(0x1F388) + emoji(0x1F388) + emoji(0x1F388) + emoji(0x1F337) + emoji(0x1F337) + emoji(0x1F337));
    }

    /**
     * Description: emoji表情<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param codePoint
     * @return <br>
     */
    private String emoji(int codePoint) {
        return String.valueOf(Character.toChars(codePoint));
    }

    @Override
    public boolean beforeHandle(E event) {
        log.debug(JSONObject.toJSONString(event));
        if (event != null && EventType.CLICK.equalsIgnoreCase(event.getEvent())) {
            return true;
        }
        return false;
    }

    /**
     * 使用说明
     * 
     * @return
     */
    private static String getUsage() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n**周边搜索使用说明**").append("\n");
        buffer.append("1）发送地理位置").append("\n");
        buffer.append("点击窗口底部的“+”按钮，选择“位置”，点“发送”").append("\n");
        buffer.append("2）指定关键词搜索").append("\n");
        buffer.append("格式：附近+关键词\n例如：附近ATM、附近KTV、附近厕所");
        return buffer.toString();
    }

}
