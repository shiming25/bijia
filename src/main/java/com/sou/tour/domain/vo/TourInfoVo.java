package com.sou.tour.domain.vo;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;

public class TourInfoVo {

	// 原始url
	public String orgUrl;
	// 价格TourInfoVo
	public String orgPrice;
	// 优惠后价格
	public String price;
	// 标题
	public String title;
	// 出发城市
	public String departyCity;
	// 目的城市
	public String destCity;
	// 行程描述
	public String content;
	// 团购结束日期
	public String endDate;
	// 1-跟团 2--自由行
	public String businessType;
	// 满意度
	public String satisfaction;
	// 简介
	public String issue;
	// 出游人数
	public String couPeople;
	// 评论数
	public String couReview;
	// 图片地址，用；分割
	public String picUrl;
	//
	public String updateTime;

	// 分页用
	/** The score of this document for the query. */
	public float score;

	/**
	 * A hit document's number.
	 * 
	 * @see IndexSearcher#doc(int)
	 */
	public int doc;

	/** Only set by {@link TopDocs#merge} */
	public int shardIndex;
	
	public int pageIndex;
	
	//特价 团购
	public String priceType;
	
	public String hostName;
	
	//几天几晚
	public String routeDay;
	//景点
	public String routePoi;
	//赞
	public String goodCou;
	//渣
	public String badCou;

	public String getGoodCou() {
		return goodCou;
	}

	public void setGoodCou(String goodCou) {
		this.goodCou = goodCou;
	}

	public String getBadCou() {
		return badCou;
	}

	public void setBadCou(String badCou) {
		this.badCou = badCou;
	}

	public String getOrgUrl() {
		return orgUrl;
	}

	public void setOrgUrl(String orgUrl) {
		this.orgUrl = orgUrl;
	}

	public String getOrgPrice() {
		return orgPrice;
	}

	public void setOrgPrice(String orgPrice) {
		this.orgPrice = orgPrice;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartyCity() {
		return departyCity;
	}

	public void setDepartyCity(String departyCity) {
		this.departyCity = departyCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String toString() {
		String ret = orgUrl + " title:" + title + " price:" + price + "  orgPrice:" + orgPrice + "  destCity:"
				+ destCity + "  departyCity:" + departyCity + "  endDate:" + endDate
				+" doc:"+doc+" score:"+score+" shardIndex:"+shardIndex+" pageIndex:"+pageIndex;
		return ret;

	}

	public String getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getCouPeople() {
		return couPeople;
	}

	public void setCouPeople(String couPeople) {
		this.couPeople = couPeople;
	}

	public String getCouReview() {
		return couReview;
	}

	public void setCouReview(String couReview) {
		this.couReview = couReview;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public int getDoc() {
		return doc;
	}

	public void setDoc(int doc) {
		this.doc = doc;
	}

	public int getShardIndex() {
		return shardIndex;
	}

	public void setShardIndex(int shardIndex) {
		this.shardIndex = shardIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getRouteDay() {
		return routeDay;
	}

	public void setRouteDay(String routeDay) {
		this.routeDay = routeDay;
	}

	public String getRoutePoi() {
		return routePoi;
	}

	public void setRoutePoi(String routePoi) {
		this.routePoi = routePoi;
	}

}
