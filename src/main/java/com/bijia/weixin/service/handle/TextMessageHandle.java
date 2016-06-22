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
            newsMsg.add("图文标题1", "图文消息测试", "http://gd.offcn.com/dl/2016/0504/20160504025719401.jpg", "http://www.baidu.com");
            newsMsg.add("图文标题2", "图文消息测试2", "http://p14.qhimg.com/dr/360_210_/t01704a8872a1a3c92f.jpg", "http://www.baidu.com");
            newsMsg.add("图文标题3", "图文消息测试3", "http://www.mercedes-benz.com.cn/content/media_library/china/mpc_china/Passenger_Cars/AMG/Philosophy/360_200_Philosophy.object-Single-MEDIA.tmp/360_200_Philosophy.jpg", "http://www.baidu.com");
            newsMsg.add("图文标题4", "图文消息测试4", "http://t-1.tuzhan.com/0875f27fe929/p-2/l/2014/02/27/17/88769d8639464ea4861378846029b774.jpg", "http://www.baidu.com");
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
