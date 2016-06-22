package com.bijia.weixin.service.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.NewsMsg;
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
    
    
    private String emoji(int codePoint) {
        return String.valueOf(Character.toChars(codePoint));
    }
    
    @Override
    public BaseMsg handle(M message) {
        //输入？ ? help 帮助 其他，查询提示
        if(message != null && helpMsgStr.contains(message.getContent())) {    
            return new TextMsg(helpStr);
        }
        
        if(message != null && oneMsgStr.contains(message.getContent())) {
            NewsMsg newsMsg = new NewsMsg();
            newsMsg.add("图文标题1，第一标题是大标题，其余是小标题，第一个大图片像素360*200，其余的小图片是200*200",
                    "图文消息测试", "http://gd.offcn.com/dl/2016/0504/20160504025719401.jpg", "http://www.baidu.com");
            newsMsg.add("图文标题2，小标题，图片像素是200*200，可以设置连接,最多10条图文。", "图文消息测试2", "http://f.hiphotos.baidu.com/baike/w%3D268/sign=1c0897d6a244ad342ebf8081e8a20c08/cf1b9d16fdfaaf517ef5b4848f5494eef01f7af2.jpg", "http://www.soso.com");
            newsMsg.add("图文标题3", "图文消息测试3", "http://imgsrc.baidu.com/forum/w%3D580/sign=8ddfbab3632762d0803ea4b790ed0849/341a90096b63f6244f533c938744ebf81a4ca31d.jpg", "http://www.sohu.com");
            newsMsg.add("图文标题4", "图文消息测试4", "http://wenwen.soso.com/p/20100427/20100427215230-159814054.jpg", "http://www.sina.com.cn");
            return newsMsg;
        }
        
       return new TextMsg("看不懂！/::Q/::Q ，请输入机器语/:B-)/:B-)：\n"+helpStr+"\n"
               +emoji(0x1F388) +emoji(0x1F388) +emoji(0x1F388)+emoji(0x1F337)+emoji(0x1F337)+emoji(0x1F337)
               +"\n"
               +"<a href=\"http://www.baidu.com\">了解更多</a> [baci 表情雨]");
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
