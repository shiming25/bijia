package com.bijia.weixin.service.qrcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bijia.weixin.constants.WeixinConstants;
import com.github.sd4324530.fastweixin.api.MaterialAPI;
import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Article;
import com.github.sd4324530.fastweixin.api.enums.MaterialType;
import com.github.sd4324530.fastweixin.api.enums.MediaType;
import com.github.sd4324530.fastweixin.api.response.DownloadMaterialResponse;
import com.github.sd4324530.fastweixin.api.response.GetMaterialListResponse;
import com.github.sd4324530.fastweixin.api.response.GetMaterialTotalCountResponse;
import com.github.sd4324530.fastweixin.api.response.UploadMaterialResponse;
import com.github.sd4324530.fastweixin.api.response.UploadMediaResponse;

/**
 * <永久素材接口> <br>
 * 
 * @author shi.ming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月1日 <br>
 */
public class MaterialServiceImpl {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(MaterialServiceImpl.class);

    /**
     * Description: 新建图片素材接口<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void uploadMaterialFileService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MaterialAPI api = new MaterialAPI(config);
        File file = new File("e:/temp/test.jpg");
        UploadMaterialResponse response = api.uploadMaterialFile(file);
        LOG.debug("永久素材接口:{}", response.toJsonString());
    }

    /**
     * Description: 新建语音素材接口<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void uploadMaterialVoiceService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MaterialAPI api = new MaterialAPI(config);
        File file = new File("e:/temp/1.wav");
        UploadMaterialResponse response = api.uploadMaterialFile(file);
        LOG.debug("永久素材语音接口:{}", response.toJsonString());
    }

    /**
     * Description: 新建视频素材接口<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void uploadMaterialVedioService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MaterialAPI api = new MaterialAPI(config);
        File file = new File("e:/temp/t1.mp4");
        UploadMaterialResponse response = api.uploadMaterialFile(file, "title", "introduction");
        LOG.debug("永久素材视频接口:{}", response.toJsonString());
    }

    public void uploadMaterialNewsService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MaterialAPI api = new MaterialAPI(config);
        List<Article> articles = new ArrayList<Article>();
        Article article = new Article("6sIrAqzl3InCfFuuk2lfsP0hfEtGQuCVPVEMs8evnJg", "测试作者",
                "测试标题", "http://www.baidu.com", "测试内容。无意义", "测试摘要，单图文。无意义", Article.ShowConverPic.NO);
        Article articleT = new Article("6sIrAqzl3InCfFuuk2lfsP0hfEtGQuCVPVEMs8evnJg", "测试作者",
                "测试标题", "http://www.baidu.com", "测试内容。无意义<a href=\"http://www.baidu.com\">test</a><b>testb</b>",
                "测试摘要，单图文。无意义", Article.ShowConverPic.NO);
        // Article article2 = new Article("6sIrAqzl3InCfFuuk2lfsP0hfEtGQuCVPVEMs8evnJg", "测试作者2",
        // "测试标题2", "http://www.baidu.com", "测试内容2。无意义", "测试摘要2，单图文。无意义", Article.ShowConverPic.YES);
        articles.add(articleT);
        // articles.add(article2);
        UploadMaterialResponse response = api.uploadMaterialNews(articles);
        LOG.debug("永久素材图文接口:{}", response.toJsonString());
    }

    /**
     * Description: 下在素材<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void downloadMaterialService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MaterialAPI api = new MaterialAPI(config);

        DownloadMaterialResponse response = api.downloadMaterial("6sIrAqzl3InCfFuuk2lfsP0hfEtGQuCVPVEMs8evnJg", MaterialType.IMAGE);
        // System.out.println("File name is " + response.toJsonString());
        try {
            FileOutputStream fos = new FileOutputStream(new File("e:/temp/test/2.jpg"));
            response.writeTo(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: 素材数量<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void countMaterialService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MaterialAPI api = new MaterialAPI(config);
        GetMaterialTotalCountResponse response = api.countMaterial();
        System.out.println("video count : " + response.getVideo());
        System.out.println("voice count : " + response.getVoice());
        System.out.println("image count : " + response.getImage());
        System.out.println("news count : " + response.getNews());
    }

    /**
     * Description: 批量获取素材<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void batchGetMaterialService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MaterialAPI api = new MaterialAPI(config);
        GetMaterialListResponse response = api.batchGetMaterial(MaterialType.IMAGE, 0, 10);
        System.out.println("Total Count : " + response.getTotalCount());
        System.out.println("Item Count : " + response.getItemCount());
        for (Map<String, Object> item : response.getItems()) {
            System.out.println("name : " + item.get("name"));
            System.out.println("media_id : " + item.get("media_id"));
        }
    }

    /**
     * Description: 删除素材<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * <br>
     */
    public void deleteMaterialService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MaterialAPI api = new MaterialAPI(config);
        api.deleteMaterial("6sIrAqzl3InCfFuuk2lfsPWa0nSLTknUjOYKrll40yY");
        batchGetMaterialService();
    }

    /**
     * 
     * Description: 新建临时素材<br> 
     *  
     * @author shi.ming<br>
     * @taskId <br> <br>
     */
    public void uploadMediaService() {
        // 获取accesssTocken
        ApiConfig config = new ApiConfig(WeixinConstants.APPID, WeixinConstants.SECRET);
        // 上传
        MediaAPI api = new MediaAPI(config);
        UploadMediaResponse response = api.uploadMedia(MediaType.IMAGE, new File("E:/temp/m1.png"));
        LOG.debug(response.toJsonString());
    }

    /**
     * Description: main<br>
     * 
     * @author shi.ming<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        MaterialServiceImpl serviceImpl = new MaterialServiceImpl();
        // serviceImpl.uploadMaterialFileService();
        // serviceImpl.uploadMaterialVoiceService();
        // serviceImpl.uploadMaterialVedioService();
        // serviceImpl.uploadMaterialNewsService();
        // serviceImpl.downloadMaterialService();
        // serviceImpl.countMaterialService();
        // serviceImpl.batchGetMaterialService();
        serviceImpl.deleteMaterialService();
    }
}
