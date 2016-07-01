/**************************************************************************************** 

 ****************************************************************************************/
package com.bijia.weixin.service.handle.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.EventType;
import com.github.sd4324530.fastweixin.message.req.LocationEvent;

/**
 * <上报地理位置事件处理类> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月27日 <br>
 */

public class LocationEventHandle<E extends LocationEvent> implements EventHandle<E> {
    /**
     * 日志
     */
    public static final Logger log = LoggerFactory.getLogger(LocationEventHandle.class);

    /**
     * 提示信息
     */
    public static final String helpStr = "?：帮助\n1：周边饭店\n2：周边宾馆\n3：周边停车场";

    @Override
    public BaseMsg handle(E event) {
        return new TextMsg("地理位置信息/:B-)/:B-)：\n"
                + "纬度：" + event.getLatitude() + "经度：" + event.getLongitude() + "精度：" + event.getPrecision()+ "\n"
                + helpStr + "\n"
                + emoji(0x1F388) + emoji(0x1F388) + emoji(0x1F388) + emoji(0x1F337) + emoji(0x1F337) + emoji(0x1F337)
                + "\n"
                + "<a href=\"http://www.baidu.com\">了解更多</a>");
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
        if (event != null && EventType.LOCATION.equalsIgnoreCase(event.getEvent())) {
            return true;
        }
        return false;
    }

}
