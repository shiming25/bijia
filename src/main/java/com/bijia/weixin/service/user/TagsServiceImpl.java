package com.bijia.weixin.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.TagAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.CreateTagResponse;
import com.github.sd4324530.fastweixin.api.response.GetAllTagsResponse;
import com.github.sd4324530.fastweixin.api.response.GetUsersResponse;

/**
 * <用户标签管理> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class TagsServiceImpl {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(TagsServiceImpl.class);

    /**
     * Description: 添加标签<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void createTagService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        TagAPI api = new TagAPI(config);

        CreateTagResponse response = api.create("购物狂");

        LOG.debug("添加结果:{}", response.toString());
    }

    /**
     * Description: 查询标签<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void getTagsService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        TagAPI api = new TagAPI(config);

        GetAllTagsResponse response = api.getAllTags();

        LOG.debug("查询结果:{}", response.toString());
    }

    /**
     * Description: 更新tag<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void updateTagService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        TagAPI api = new TagAPI(config);

        ResultType response = api.updateTag(101, "淘客");

        LOG.debug("更新结果:{}", response.toString());
    }

    /**
     * Description: 删除标签<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void deleteTagService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        TagAPI api = new TagAPI(config);

        ResultType response = api.deleteTag(101);

        LOG.debug("del结果:{}", response.toString());
    }

    /**
     * Description: 获取标签用户<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void getUsersByTagIdService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        TagAPI api = new TagAPI(config);

        GetUsersResponse response = api.getUsersByTagId(100, null);

        LOG.debug("获取标签用户结果:{}", response.toString());
    }

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        TagsServiceImpl serviceImpl = new TagsServiceImpl();

        // serviceImpl.createTagService();
        // serviceImpl.getTagsService();
        // serviceImpl.updateTagService();
        // serviceImpl.deleteTagService();
        serviceImpl.getUsersByTagIdService();
    }
}
