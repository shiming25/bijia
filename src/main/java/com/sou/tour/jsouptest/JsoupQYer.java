package com.sou.tour.jsouptest;

import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class JsoupQYer {
	
	/**
	 *	http://www.lvmama.com/tuangou
	 * product
	 *  
	 *  http://www.lvmama.com/tuangou/all/all-all-all-2
	 */
	
	
	public static void test()  {
		Document doc;
		try {
			doc = Jsoup.connect("http://z.qyer.com/deal/5854/").get();
			String title = doc.title();
				Elements links = doc.select(".titbox .tit"); 
			
			    
			    String s = title;
			    int a = title.indexOf("】");
			    title = title.substring(1, a);
			    title = title.replaceAll("穷游", "").replaceAll("折扣", "");
							
//			String businessType = links.text();
			System.out.println("businessType:"+title);
			//title
			links = doc.select(".lmDetailTitle"); 
			String titleStr = links.text();
			System.out.println("titleStr:"+indexStr(titleStr));
			//System.out.println(doc.toString());
			//price
			links = doc.select(".price em"); 
			String price = links.text();
			System.out.println("price:"+price);
			//orgPrice
			links = doc.select(".marktprice em "); 
			String orgPrice = links.text();
			System.out.println("orgPrice:"+orgPrice.replaceAll("¥", ""));
			//departyCity
			links = doc.select(".lmbox ul li:eq(0)"); 
			String departyCity = links.text();
			System.out.println("departyCity:"+departyCity.replaceAll("出发地：", ""));			
			//destCity
			links = doc.select(".lmbox ul li:eq(1)"); 
			String destCity = links.text();
			System.out.println("destCity:"+destCity.replaceAll("目的地：", ""));
			
//			links = doc.select(".scenery span,.dcontent .hd span"); 
//			String destPoi = links.text();
//			System.out.println("destPoi:"+destPoi);		
			
			//issue
			links = doc.select(".lmbox .cnt div:eq(0)"); 
			String issue = links.text();
			System.out.println("issue:"+issue);
			
			//content
			links = doc.select(".lmbox .cnt"); 
			String content = links.html();
			System.out.println("content:"+content);		
			
			//img
			links = doc.select(".lmbox .cnt  img"); 
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
						if(null != styleStr && !styleStr.equals("")) {
							if(styleStr.contains("74px")) {
								continue;
							}
						}
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
//			links = doc.select(".saleamount .score:eq(2) b"); 
//			String peopleCou = links.text();
//			System.out.println("peopleCou:"+peopleCou.replaceAll("人已购买","").replaceAll("团购数量有限，下单要快哦~", ""));	
			
			//peopeComment
//			links = doc.select(".mod_talk_list li"); 
//			String peopeComment = ""+links.size();
//			System.out.println("peopeComment:"+peopeComment.replaceAll("\\(", "").replaceAll("\\)", ""));	
//			
			//statistion
//			links = doc.select(".cominfo .dscore .comlevel dfn i"); 
//			String stat1 = links.text();
//			if(!stat1.equals(""))
//				System.out.println("stat1:"+stat1+"%");	
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static  String indexStr(String str) {
		int pos = str.indexOf("：");
		if(pos >0) {
			String temp = str.substring(pos+1);			
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
