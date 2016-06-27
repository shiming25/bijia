/**************************************************************************************** 

 ****************************************************************************************/
package com.bijia.weixin.service.handle;

import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;

/** 
 * <订阅时间处理类> <br> 
 *  
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月27日 <br>
 */

public class SubscribeEventHandle<E extends BaseEvent> implements EventHandle<E> {

    @Override
    public BaseMsg handle(E event) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean beforeHandle(E event) {
        // TODO Auto-generated method stub
        return false;
    }

}
