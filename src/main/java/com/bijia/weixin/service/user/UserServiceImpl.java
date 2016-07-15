package com.bijia.weixin.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.UserAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.UserInfo;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoListResponse;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.GetUsersResponse;

/**
 * <用户标签管理> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class UserServiceImpl {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * Description: 添加标签<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void batchTagsToUserService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        UserAPI api = new UserAPI(config);

        List<String> openidList = new ArrayList<String>();
        openidList.add("o5cJLxCzHZpteK-xURp6_79YA-zY");
        openidList.add("o5cJLxL01KLrVxwlk2kVNV5T9zuU");

        Integer tagId = 102;

        ResultType response = api.batchTagsToUser(openidList, tagId);

        LOG.debug("输出结果:{}", response.toString());
    }

    /**
     * Description: 删除标签<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void batchDeleteTagsToUserService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        UserAPI api = new UserAPI(config);

        List<String> openidList = new ArrayList<String>();
        openidList.add("o5cJLxCzHZpteK-xURp6_79YA-zY");
        openidList.add("o5cJLxL01KLrVxwlk2kVNV5T9zuU");

        Integer tagId = 102;

        ResultType response = api.batchDeleteTagsToUser(openidList, tagId);

        LOG.debug("输出结果:{}", response.toString());
    }

    /**
     * Description: 为用户查询标签<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void getTagsIdListService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        UserAPI api = new UserAPI(config);

        String openid = "o5cJLxCzHZpteK-xURp6_79YA-zY";

        ResultType response = api.getTagsIdList(openid);

        LOG.debug("输出结果:{}", response.toString());
    }

    /**
     * Description: 给用户设置备注<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void setUserRemarkService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        UserAPI api = new UserAPI(config);

        String openid = "o5cJLxCzHZpteK-xURp6_79YA-zY";

        ResultType response = api.setUserRemark(openid, "李旭");

        LOG.debug("输出结果:{}", response.toString());
    }

    /**
     * Description: 获取关注者信息<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void getUserInfoService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        UserAPI api = new UserAPI(config);

        String openid = "o5cJLxCzHZpteK-xURp6_79YA-zY";

        GetUserInfoResponse response = api.getUserInfo(openid);

        LOG.debug("输出结果:{}", response.toString());
    }

    /**
     * Description:批量获取用户信息 <br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void getUserInfoListService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        UserAPI api = new UserAPI(config);

        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo("o5cJLxCzHZpteK-xURp6_79YA-zY", "zh-CN");
        userInfoList.add(userInfo);

        GetUserInfoListResponse response = api.getUserInfoList(userInfoList);

        LOG.debug("输出结果:{}", response.toString());
    }

    /**
     * 
     * Description: 获取用户列表<br> 
     *  
     * @author shi.ming<br>
     * @taskId <br> <br>
     */
    public void getUsersService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        UserAPI api = new UserAPI(config);

        GetUsersResponse response = api.getUsers(null);

        LOG.debug("输出结果:{}", response.toString());
    }

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        UserServiceImpl serviceImpl = new UserServiceImpl();

        // serviceImpl.batchTagsToUserService();
        // serviceImpl.batchDeleteTagsToUserService();
        // serviceImpl.getTagsIdListService();
        // serviceImpl.setUserRemarkService();
        // serviceImpl.getUserInfoService();
        // serviceImpl.getUserInfoListService();
        serviceImpl.getUsersService();
    }
}
