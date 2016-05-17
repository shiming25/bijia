package com.sou.tour.jsouptest;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;




public class JsoupLvMaMa {
	
	/**
	 *	http://www.lvmama.com/tuangou
	 * product
	 *  
	 */
	
	
	public static void test()  {
		Document doc;
		try {
			doc = Jsoup.connect("http://www.lvmama.com/tuangou/detail-116258").get();
			String title = doc.title();
				Elements links = doc.select(".titbox .tit"); 
//			String businessType = links.text();
			System.out.println("businessType:"+"线路");
			//title
			links = doc.select(".titbox .tit"); 
			String titleStr = links.text();
			System.out.println("titleStr:"+indexStr(titleStr));
			//price
			links = doc.select(".priceinfo dfn b"); 
			String price = links.text();
			System.out.println("price:"+price);
			//orgPrice
			links = doc.select(".priceinfo del i"); 
			String orgPrice = links.text();
			System.out.println("orgPrice:"+orgPrice.replaceAll("¥", ""));
			//departyCity
			links = doc.select(".con_4 .con_42 .con_53 .m_r54"); 
			String departyCity = "任意";
			System.out.println("departyCity:"+departyCity);			
			//destCity
//			links = doc.select(".top .f_lv a:eq(1)"); 
//			String destCity = links.text();
//			System.out.println("destCity:"+destCity.replaceAll("自由行团购", ""));
			
			links = doc.select(".scenery span,.dcontent .hd span"); 
			String destPoi = links.text();
			System.out.println("destPoi:"+destPoi);		
			
			//issue
			links = doc.select(".overview_l_text span.p_text"); 
			String issue = links.text();
			System.out.println("issue:"+issue);
			
			//content
			links = doc.select(".dest-main-l .dmain"); 
			String content = links.html();
			System.out.println("content:"+content);		
			
			//img
			links = doc.select(".img_box .img_list  img"); 
			String img = links.get(0).attr("src");
			System.out.println("img:"+img);	
			
			//peopleCou
			links = doc.select(".saleamount .score:eq(2) b"); 
			String peopleCou = links.text();
			System.out.println("peopleCou:"+peopleCou.replaceAll("人已购买","").replaceAll("团购数量有限，下单要快哦~", ""));	
			
			//peopeComment
			links = doc.select(".dcomment .tab-dcom ur li:eq(2)"); 
			String peopeComment = links.text();
			System.out.println("peopeComment:"+peopeComment.replaceAll("\\(", "").replaceAll("\\)", ""));	
			
			//statistion
			links = doc.select(".cominfo .dscore .comlevel dfn i"); 
			String stat1 = links.text();
			if(!stat1.equals(""))
				System.out.println("stat1:"+stat1+"%");	
			
			links = doc.select("#ulDaybox li a"); 
			String routeDay = links.last().text();
			if(!routeDay.equals(""))
				System.out.println("routeDay:"+routeDay);	
			
			links = doc.select(".scenery span,.dcontent .hd span"); 
			String poi = links.text();
			if(!poi.equals(""))
				System.out.println("poi:"+poi);
			
			
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
