package com.bijia.weixin.service.handle.message;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.NewsMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.ReqType;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.mongodb.DBObject;
import com.shim.util.MongoUtil;
import com.weixin.gra.pojo.Article;
import com.weixin.gra.pojo.BaiduPlace;
import com.weixin.gra.pojo.UserLocation;
import com.weixin.gra.util.BaiduMapUtil;

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

    public static final String fujinStr = "附近";

    /**
     * 提示信息
     */
    public static final String helpStr = "?：帮助\n1：附近饭店\n2：附近宾馆\n3：附近停车场";

    /**
     * 查询周边饭店
     */
    public static final String oneMsgStr = "1,饭店";

    private String emoji(int codePoint) {
        return String.valueOf(Character.toChars(codePoint));
    }

    @Override
    public BaseMsg handle(M message) {

        MongoUtil mongoUtil = new MongoUtil();
        String respContent = "";
        if (message != null && fujinStr.equals(message.getContent())) {
            return new TextMsg(getUsage());
        }
        String messageContent = "";
        if (message != null) {
            messageContent = message.getContent();
            if(messageContent.equals("1")) {
                messageContent = fujinStr+"饭店";
            }
            if(messageContent.equals("2")) {
                messageContent = fujinStr+"宾馆";
            }
            if(messageContent.equals("3")) {
                messageContent = fujinStr+"停车场";
            }
        }

        // 附近查询
        if (message != null && messageContent.startsWith(fujinStr)) {
            try {
                String keyWord = messageContent.replaceAll(fujinStr, "").trim();
                // 获取用户最后一次发送的地理位置
                // UserLocation location = MySQLUtil.getLastLocation(request, fromUserName);
                log.debug("begin 附近查询" + message.toString());
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("fromUserName", message.getFromUserName());
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

        // 输入？ ? help 帮助 其他，查询提示
        if (message != null && helpMsgStr.contains(message.getContent())) {
            return new TextMsg(helpStr);
        }
        // 输入1，显示图文消息
        if (message != null && oneMsgStr.contains(message.getContent())) {
            NewsMsg newsMsg = new NewsMsg();
            newsMsg.add("图文标题1，第一标题是大标题，其余是小标题，第一个大图片像素360*200，其余的小图片是200*200",
                    "图文消息测试", "http://gd.offcn.com/dl/2016/0504/20160504025719401.jpg", "http://www.baidu.com");
            newsMsg.add("图文标题2，小标题，图片像素是200*200，可以设置连接,最多10条图文。", "图文消息测试2",
                    "http://f.hiphotos.baidu.com/baike/w%3D268/sign=1c0897d6a244ad342ebf8081e8a20c08/cf1b9d16fdfaaf517ef5b4848f5494eef01f7af2.jpg",
                    "http://www.soso.com");
            newsMsg.add("图文标题3", "图文消息测试3",
                    "http://imgsrc.baidu.com/forum/w%3D580/sign=8ddfbab3632762d0803ea4b790ed0849/341a90096b63f6244f533c938744ebf81a4ca31d.jpg",
                    "http://www.sohu.com");
            newsMsg.add("图文标题4", "图文消息测试4", "http://wenwen.soso.com/p/20100427/20100427215230-159814054.jpg", "http://www.sina.com.cn");
            return newsMsg;
        }

        return new TextMsg("看不懂！/::Q/::Q ，请输入机器语/:B-)/:B-)：\n" + helpStr +getUsage()+ "\n"
                + emoji(0x1F388) + emoji(0x1F388) + emoji(0x1F388) + emoji(0x1F337) + emoji(0x1F337) + emoji(0x1F337)
                + "\n"
                + "<a href=\"http://www.baidu.com\">了解更多</a> [baci 表情雨]");
    }

    /**
     * 使用说明
     * 
     * @return
     */
    private static String getUsage() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n*********周边搜索使用说明*********").append("\n");
        buffer.append("1）发送地理位置").append("\n");
        buffer.append("点击窗口底部的“+”按钮，选择“位置”，点“发送”").append("\n");
        buffer.append("2）指定关键词搜索").append("\n");
        buffer.append("格式：附近+关键词\n例如：附近ATM、附近KTV、附近厕所");
        return buffer.toString();
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
