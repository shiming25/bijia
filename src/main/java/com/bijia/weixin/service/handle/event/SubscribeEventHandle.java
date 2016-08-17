/**************************************************************************************** 

 ****************************************************************************************/
package com.bijia.weixin.service.handle.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.message.req.EventType;

/** 
 * <关注事件处理类> <br> 
 *  
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月27日 <br>
 */

public class SubscribeEventHandle<E extends BaseEvent> implements EventHandle<E> {
    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(SubscribeEventHandle.class);
    /**
     * 提示信息
     */
    public static final String helpStr = "?：帮助\n1：周边饭店\n2：周边宾馆\n3：周边停车场";
    @Override
    public BaseMsg handle(E event) {
        return new TextMsg("欢迎关注/:B-)/:B-)：\n"+helpStr+getUsage()+"\n"
                +emoji(0x1F388) +emoji(0x1F388) +emoji(0x1F388)+emoji(0x1F337)+emoji(0x1F337)+emoji(0x1F337)
                +"\n"
                +"<a href=\"http://www.baidu.com\">了解更多</a> [baci 表情雨]");
    }

    /**
     * 
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
        if (event != null && EventType.SUBSCRIBE.equalsIgnoreCase(event.getEvent())) {
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
        buffer.append("指定关键词搜索").append("\n");
        buffer.append("格式：附近+关键词\n例如：附近ATM、附近KTV、附近厕所");
        return buffer.toString();
    }

}
