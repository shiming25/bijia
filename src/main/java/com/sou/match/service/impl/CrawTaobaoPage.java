package com.sou.match.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Service;

import com.sou.match.domain.vo.ImgVo;
import com.sou.match.service.ICrawTaobaoPage;

@Service
public class CrawTaobaoPage implements ICrawTaobaoPage {

	public JSONObject crawPage(JSONObject paramObj) {
		JSONObject taobaoJson = new JSONObject();
		try {
			String urlStr = "";
			if (null != paramObj && !paramObj.getString("urlStr").isEmpty()) {
				urlStr = paramObj.getString("urlStr");
			} else {
				return null;
			}

			// 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox40.0.3\\firefox.exe");
			// 创建一个 FireFox 的浏览器实例
			WebDriver driver = new FirefoxDriver();
			// WebDriver driver = new HtmlUnitDriver();
			driver.manage().window().maximize();
			// 让浏览器访问 Baidu
			// driver.get("https://item.taobao.com/item.htm?id=522862409133&ali_refid=a3_420432_1006:1102345190:N:%E7%94%B7%E7%A7%8B%E6%AC%BE%E5%A4%96%E5%A5%97:daf48c3bba96f6db859378b64f010d1f&ali_trackid=1_daf48c3bba96f6db859378b64f010d1f&spm=a230r.1.14.1.s2lTr4#detail");
			driver.get(urlStr);
			// 用下面代码也可以实现
			// driver.navigate().to("http://www.baidu.com");

			// 获取 网页的 title
			taobaoJson.put("title", driver.getTitle());

			// 通过 id 找到 input 的 DOM
			// WebElement element = driver.findElement(By.id("J_TabBar"));
			// WebElement element1 =
			// driver.findElement(By.id("J_PromoPriceNum"));
			WebElement element1 = null;
			taobaoJson.put("imgs", getSelImgElementById(driver, element1, "J_UlThumb"));
			taobaoJson.put("price", "价格  " + getSelElementHtmlByClass(driver, element1, "tb-property-cont") + "<br/>"
					+ getSelElementById(driver, element1, "J_PromoPrice"));

			taobaoJson.put("kuaidi", getSelElementById(driver, element1, "J_WlServiceInfo") + "<br/>"
					+ getSelElementById(driver, element1, "J_WlServiceTitleMark"));
			// 其他优惠
			taobaoJson.put("otherDiscount",
					getSelElementById(driver, element1, "J_GoldCoin")
							+ getSelElementById(driver, element1, "J_RedGift"));
			// 分期
			String htmlStr = getSelElementHtmlByClass(driver, element1, "J_TBMultiTerms");
			if (!htmlStr.isEmpty() && !htmlStr.equals("--")) {
				taobaoJson.put("multiTerm", "花呗分期<ul>" + getSelElementHtmlByClass(driver, element1, "J_TBMultiTerms")
						+ "</ul>");
			} else {
				taobaoJson.put("multiTerm", getSelElementHtmlByClass(driver, element1, "J_TBMultiTerms"));
			}

			// element1 = driver.findElement(By.id("J_RateCounter"));
			// 评论
			htmlStr = getSelElementById(driver, element1, "J_RateCounter");
			if (!htmlStr.isEmpty() && !htmlStr.equals("--")) {
				taobaoJson.put("peopleCommentary", htmlStr + "累计评论");
			} else {
				taobaoJson.put("peopleCommentary", htmlStr);
			}

			// 成交
			htmlStr = getSelElementById(driver, element1, "J_SellCounter");
			if (!htmlStr.isEmpty() && !htmlStr.equals("--")) {
				taobaoJson.put("peopleCou", "30天内交易成功" + htmlStr);
			} else {
				taobaoJson.put("peopleCou", htmlStr);
			}

			// 规格
			htmlStr = getSelElementsByClass(driver, element1, "J_isku", "J_Prop");
			if (!htmlStr.isEmpty() && !htmlStr.equals("--")) {
				taobaoJson.put("jProp", htmlStr);
			} else {
				taobaoJson.put("jProp", htmlStr);
			}

			// 人气
			taobaoJson.put("peopleView", getSelElementByClass(driver, element1, "J_TDialogTrigger"));
			// 发货城市
			taobaoJson.put("departyCity", getSelElementById(driver, element1, "J-From"));

			// 产品详情
			taobaoJson.put("attributes", getSelElementHtmlById(driver, element1, "attributes"));

			// 产品desc
			taobaoJson.put("desc", getSelElementHtmlById(driver, element1, "J_DivItemDesc"));

			// 关闭浏览器
			driver.quit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return taobaoJson;
	}

	/**
	 * 获取text内容
	 * 
	 * @param driver
	 * @param element
	 * @param idStr
	 * @return
	 */
	public String getSelElementById(WebDriver driver, WebElement element, String idStr) {

		String eleStr = "--";
		try {
			element = driver.findElement(By.id(idStr));
			eleStr = element.getText();
			System.out.println(idStr + eleStr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eleStr;

	}

	public String getSelElementsByClass(WebDriver driver, WebElement element, String idStr, String className) {

		String eleStr = "--";
		StringBuffer tempSb = new StringBuffer();
		try {
			element = driver.findElement(By.id(idStr));
			java.util.List<WebElement> elems = element.findElements(By.className(className));
			eleStr = element.getText();

			if (null != elems && !elems.isEmpty()) {

				String tempStr = "";
				for (WebElement elementTemp : elems) {
					tempStr = elementTemp.getAttribute("outerHTML");
					tempSb.append(tempStr);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return eleStr;
		}
		return tempSb.toString();
	}

	public List<ImgVo> getSelImgElementById(WebDriver driver, WebElement element, String idStr) {

		String eleStr = "--";
		java.util.List<ImgVo> imgVoList = new ArrayList<ImgVo>();
		try {
			element = driver.findElement(By.id(idStr));
			java.util.List<WebElement> imgs = element.findElements(By.tagName("img"));
			eleStr = element.getText();

			if (null != imgs && !imgs.isEmpty()) {
				ImgVo imgVo = new ImgVo();
				String imgUrlStr = "";
				for (WebElement elementTemp : imgs) {
					imgVo = new ImgVo();
					imgUrlStr = elementTemp.getAttribute("src");
					imgVo.setImage(imgUrlStr.replaceAll("50x50.jpg", "400x400.jpg"));
					imgVo.setThumb(imgUrlStr);
					imgVoList.add(imgVo);
				}
			}

			System.out.println(idStr + eleStr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return imgVoList;

	}

	public String getSelElementByClass(WebDriver driver, WebElement element, String idStr) {

		String eleStr = "-";
		try {
			element = driver.findElement(By.className(idStr));
			eleStr = element.getText();
			System.out.println(idStr + eleStr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eleStr;

	}

	public String getSelElementHtmlByClass(WebDriver driver, WebElement element, String idStr) {

		String eleStr = "-";
		try {
			element = driver.findElement(By.className(idStr));
			eleStr = element.getAttribute("innerHTML");
			System.out.println(idStr + eleStr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eleStr;

	}

	public String getSelElementHtmlById(WebDriver driver, WebElement element, String idStr) {

		String eleStr = "-";
		try {
			element = driver.findElement(By.id(idStr));
			eleStr = element.getAttribute("innerHTML");
			System.out.println(idStr + eleStr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eleStr;

	}

}
