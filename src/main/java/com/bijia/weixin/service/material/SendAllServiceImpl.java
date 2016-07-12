package com.bijia.weixin.service.material;

import java.io.File;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.MessageAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Article;
import com.github.sd4324530.fastweixin.api.enums.MediaType;
import com.github.sd4324530.fastweixin.api.response.GetSendMessageResponse;
import com.github.sd4324530.fastweixin.api.response.UploadImgResponse;
import com.github.sd4324530.fastweixin.api.response.UploadMediaResponse;
import com.github.sd4324530.fastweixin.message.MpNewsMsg;

/**
 * <永久素材接口> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class SendAllServiceImpl {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(SendAllServiceImpl.class);

    /**
     * Description: 上传图文消息内的图片获取URL 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void uploadImgService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MediaAPI api = new MediaAPI(config);
        File file = new File("e:/temp/test/p1.png");
        UploadImgResponse response = api.uploadImg(file);
        LOG.debug("上传图文消息内的图片接口:{}", response.toJsonString());
    }

    /**
     * 
     * Description: 群发消息<br> 
     *  
     * @author shi.ming<br>
     * @taskId <br> <br>
     */
    public void sendAllMessage() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MediaAPI api = new MediaAPI(config);
        UploadMediaResponse response = api.uploadMedia(MediaType.IMAGE, new File("e:/temp/test/p1.png"));
        String media_id = response.getMediaId();
        Article article = new Article(media_id, "测试用户", "群发测试标题", "http://www.baidu.com", "群发测试内容", "群发测试描述", Article.ShowConverPic.NO);
        UploadMediaResponse uploadMediaResponse = api.uploadNews(Arrays.asList(article));
        MpNewsMsg mpNewsMsg = new MpNewsMsg();
        mpNewsMsg.setMediaId(uploadMediaResponse.getMediaId());
        MessageAPI messageAPI = new MessageAPI(config);
        GetSendMessageResponse messageResponse = messageAPI.sendMessageToUser(mpNewsMsg, true, 0);
        LOG.info("Send Message Id is " + messageResponse.getMsgId());
    }

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        SendAllServiceImpl serviceImpl = new SendAllServiceImpl();

//        serviceImpl.uploadImgService();
        serviceImpl.sendAllMessage();
    }
}
