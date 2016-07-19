/**************************************************************************************** 

 ****************************************************************************************/
package com.bijia.weixin.service.menu;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Menu;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.GetMenuResponse;

/**
 * <菜单操作> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月23日 <br>
 */

public class MenuService {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(MenuService.class);

    /**
     * Description: 获取菜单服务<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void createMenuService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 创建菜单
        createMenu(config);
    }

    /**
     * Description: 获取菜单<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void getMenuService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 查询菜单
        MenuAPI api = new MenuAPI(config);
        GetMenuResponse response = api.getMenu();
        LOG.debug("菜单:{}", response.toJsonString());
    }

    /**
     * Description: 创建菜单<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param config <br>
     */
    private void createMenu(ApiConfig config) {
        MenuAPI menuAPI = new MenuAPI(config);

        // 先删除之前的菜单
        menuAPI.deleteMenu();
        Menu request = new Menu();
        // 准备一级主菜单

        MenuButton mainBijia = new MenuButton();
        mainBijia.setType(MenuType.CLICK);
        mainBijia.setKey("bijiaMenu");
        mainBijia.setName("比价");

        MenuButton mainHot = new MenuButton();
        mainHot.setType(MenuType.CLICK);
        mainHot.setKey("hotMenu");
        mainHot.setName("热门");

        MenuButton mainAround = new MenuButton();
        mainAround.setType(MenuType.CLICK);
        mainAround.setKey("aroundMenu");
        mainAround.setName("周边生活");

        // 准备bijia子菜单
        MenuButton sub0 = new MenuButton();
        sub0.setKey("bijiaSubMain");
        sub0.setName("首页");
        sub0.setType(MenuType.VIEW);
        sub0.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0702bf3d53619c62&redirect_uri=http://www.xuntj.com/test/index2.html&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
        
        MenuButton sub1 = new MenuButton();
        sub1.setKey("bijiaSubTaobao");
        sub1.setName("阿里vs京东vs苏宁");
        sub1.setType(MenuType.VIEW);
        sub1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0702bf3d53619c62&redirect_uri=http://www.xuntj.com/test/index2.html&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
        MenuButton sub2 = new MenuButton();
        sub2.setKey("bijiaSubTel");
        sub2.setName("移动vs电信vs联通");
        sub2.setType(MenuType.CLICK);
        MenuButton sub3 = new MenuButton();
        sub3.setKey("bijiaSubScanCodePush");
        sub3.setName("扫码推事件");
        sub3.setType(MenuType.CLICK);

        List<MenuButton> listBijia = new ArrayList<MenuButton>();
        listBijia.add(sub0);
        listBijia.add(sub1);
        listBijia.add(sub2);
        listBijia.add(sub3);
        // 将子菜单放入主菜单里
        mainBijia.setSubButton(listBijia);

        // 准备hot子菜单
        MenuButton subHotSub = new MenuButton();
        subHotSub.setKey("hotSubTop");
        subHotSub.setName("热门比");
        subHotSub.setType(MenuType.VIEW);
        subHotSub
                .setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxafb7b8f9457b5d50&redirect_uri=http://121.40.140.41/erhuluanzi/app/testGet&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
        MenuButton subHotTalk = new MenuButton();
        subHotTalk.setKey("hotSubTalk");
        subHotTalk.setName("最火讨论");
        subHotTalk.setType(MenuType.CLICK);

        List<MenuButton> listHot = new ArrayList<MenuButton>();
        listHot.add(subHotSub);
        listHot.add(subHotTalk);
        // 将子菜单放入主菜单里
        mainHot.setSubButton(listHot);

        // 准备around子菜单
        MenuButton subAroundHotel = new MenuButton();
        subAroundHotel.setKey("aroundSubHotel");
        subAroundHotel.setName("周边宾馆");
        subAroundHotel.setType(MenuType.VIEW);
        subAroundHotel
                .setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxafb7b8f9457b5d50&redirect_uri=http://121.40.140.41/erhuluanzi/app/testGet&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
        MenuButton subAroundFandian = new MenuButton();
        subAroundFandian.setKey("arroundSubFandian");
        subAroundFandian.setName("周边饭店");
        subAroundFandian.setType(MenuType.CLICK);
        MenuButton subAroundTingche = new MenuButton();
        subAroundTingche.setKey("arroundSubTingche");
        subAroundTingche.setName("周边停车场");
        subAroundTingche.setType(MenuType.CLICK);
        MenuButton subAroundSpot = new MenuButton();
        subAroundSpot.setKey("arroundSubSpot");
        subAroundSpot.setName("周边景点");
        subAroundSpot.setType(MenuType.CLICK);
        MenuButton subAroundJianshen = new MenuButton();
        subAroundJianshen.setKey("arroundSubJianshen");
        subAroundJianshen.setName("周边KTV");
        subAroundJianshen.setType(MenuType.CLICK);

        List<MenuButton> listArround = new ArrayList<MenuButton>();
        listArround.add(subAroundHotel);
        listArround.add(subAroundFandian);
        listArround.add(subAroundTingche);
        listArround.add(subAroundSpot);
        listArround.add(subAroundJianshen);

        // 将子菜单放入主菜单里
        mainAround.setSubButton(listArround);

        // 加入主菜单
        List<MenuButton> mainList = new ArrayList<MenuButton>();
        mainList.add(mainBijia);
        mainList.add(mainHot);
        mainList.add(mainAround);
        // 将主菜单加入请求对象
        request.setButton(mainList);
        LOG.debug(request.toJsonString());
        // 创建菜单
        ResultType resultType = menuAPI.createMenu(request);
        LOG.debug(resultType.toString());
    }

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
         menuService.createMenuService();
        // menuService.getMenuService();
    }

}
