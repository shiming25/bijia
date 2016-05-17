package com.sou.tour.jsouptest;

import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class JsoupMaFengWo {
	
	/**
	 *	http://www.lvmama.com/tuangou
	 * product
	 *  
	 *  http://www.lvmama.com/tuangou/all/all-all-all-2
	 */
	
	
	public static void test()  {
		Document doc;
		try {
			doc = Jsoup.connect("http://www.mafengwo.cn/sales/307173.html").get();
			String title = doc.title();
				Elements links = doc.select(".titbox .tit"); 
			
			    
//			    String s = title;
//			    int a = title.indexOf("】");
//			    title = title.substring(1, a);
//			    title = title.replaceAll("穷游", "").replaceAll("折扣", "");
							
//			String businessType = links.text();
//			System.out.println("businessType:"+title);
			//title
			links = doc.select(".tj-title"); 
			String titleStr = links.text();
			System.out.println("titleStr:"+(titleStr));
			
			String businessType = indexStr(titleStr);
			System.out.println("businessType:"+businessType.replaceAll("特价", ""));
			
			//System.out.println(doc.toString());
			//price
			links = doc.select("#pnl_single_price"); 
			String price = links.text();
			System.out.println("price:"+price.replaceAll("¥", ""));
			//orgPrice
//			links = doc.select(".marktprice em "); 
//			String orgPrice = links.text();
//			System.out.println("orgPrice:"+orgPrice.replaceAll("¥", ""));
			//departyCity
			links = doc.select("#target_费用说明,#target_特价详情"); 
			String infoStr = links.text();
			String departyCity = getInfoStrArr(infoStr,"出发地：");
			                                            
			System.out.println("departyCity:"+departyCity);	
			
			//destCity
			links = doc.select(".lmbox ul li:eq(1)"); 
			String destCity = getInfoStrArr(infoStr,"目的地：");			                                         
			System.out.println("destCity:"+destCity);
			
//			links = doc.select(".scenery span,.dcontent .hd span"); 
//			String destPoi = links.text();
//			System.out.println("destPoi:"+destPoi);		
			
			//issue
//			links = doc.select(".lmbox .cnt div:eq(0)"); 
			String issue =infoStr;
			System.out.println("issue:"+issue);
			
			//content
			links = doc.select("#target_特价详情"); 
			String content = links.html();
			System.out.println("content:"+content);		
			
			//img
			links = doc.select("#slide_panel img"); 
			String img = links.get(0).attr("src");
			System.out.println("img:"+img);	
			
			Elements eles = links;
			// String picUrl = doc.select(selecter.getPicUrl()).text();
			if (null != eles) {
				Iterator<Element> ite = eles.iterator();
				StringBuffer imgSb = new StringBuffer("");
				while (ite.hasNext()) {
					Element ele = ite.next();
					String imgUrl = ele.attr("src");
					String styleStr = ele.attr("style");
					if (null != imgUrl && !imgUrl.equals("")) {
						
						if (imgSb.toString().equals("")) {
							imgSb.append(imgUrl);
						} else {
							imgSb.append(";").append(imgUrl);
						}

					}
				}
				System.out.println("img2:"+imgSb);	
			}
			
			//peopleCou
			links = doc.select(".tj-count a[href=#target_成交记录]"); 
			String peopleCou = links.text();
			System.out.println("peopleCou:"+peopleCou.replaceAll("人已购买","").replaceAll("团购数量有限，下单要快哦~", ""));	
			
			//peopeComment
			links = doc.select(".tj-count a[href=#target_评论专区]"); 
			String peopeComment = ""+links.text();
			System.out.println("peopeComment:"+peopeComment.replaceAll("\\(", "").replaceAll("\\)", ""));	
			
			//statistion
//			links = doc.select(".cominfo .dscore .comlevel dfn i"); 
//			String stat1 = links.text();
//			if(!stat1.equals(""))
//				System.out.println("stat1:"+stat1+"%");	
			
			links = doc.select(".tj-count em"); 
			String peopeView = ""+links.text();
			System.out.println("peopeView:"+peopeView);	

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getInfoStrArr(String infoStr,String keyStr) {
		String[] strArr = infoStr.split("※");
		if(null != strArr && strArr.length>0) {
			for(int i=0;i<strArr.length;i++) {
				if(strArr[i].contains(keyStr)) {
					return strArr[i].replaceAll(keyStr, "");
				}
			}
		}
		return "";
	}
	
	public static  String indexStr(String str) {
		int pos = str.indexOf("】");
		int be = str.indexOf("【");
		if(pos >0) {
			String temp = str.substring(be+1, pos);		
			
			return temp;
		}
		return str;
		
		
	}
	
	public static void main(String args[]) {
		String sss = "test1";
		String[] dd =sss.split(" ");
		
		test();
		
		indexStr("自由行 米胖：昆明直飞苏梅岛自由行3999元——现在去，还免签证费！");
		
		/**
		 *  起点： http://tuan.mangocity.com/zhuanti/zyx.html
		 *  
		 */
	}
}
