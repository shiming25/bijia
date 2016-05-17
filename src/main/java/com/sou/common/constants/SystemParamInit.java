/**
 * 项目名：agencySys
 * 包名：com.tuniu.ticket.init	
 * 文件名：SystomParamInit.java *
 * 日期：2011-6-20 上午11:20:17
 * Copyright 途牛科技有限公司 2011
 * 版权所有
 */
package com.sou.common.constants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 此类描述的是：
 * 
 * @author xujinfei
 */

public class SystemParamInit {
	/**
	 * 日志类
	 */
	private static final Log LOG = LogFactory.getLog(SystemParamInit.class);
	public static String xmlRpcServerUrl;
	public static String xmlRpcOrderFunction;
	public static String xmlRpcBatchFunction;
	public static String xmlRpcReplyFunction;
	public static String xmlRpcGroupSelfFunction;
	public static String xmlRpcFeedbackFunction;
	public static String xmlRpcAgencyMenuRoleFunction;
	public static String xmlRpcReplyDamageFunction;
	public static int xmlRpcClientId;
	public static String xmlRpcClientKey;
	public static String allowIp;
	public static String agencyURL;
	public static String pdfUrlScheme;
	public static String pdfUrlHost;
	public static int pdfPort;
	public static String pdfServiceUrlPath;
	public static String agencyFilePath;
	public static String agencyTouristStatisticServerUrl;
	public static String agencyTouristStatisticFunction;
	public static String routeOrderNumFunction;
	public static String routeOrderNumServerUrl;
	public static String routeOrderInfoFunction;
	public static String routeOrderInfoServerUrl;
	public static String bbSystemAccountUrl;
	public static String querySelfCharge;
	public static String updateSelfCharge;
	public static String queryImportantInfo;
	public static String updateImportantInfo;
	/* 供应商产品之日志接口URL */
	public static String queryProductActionLogUrl;
	public static String addProductActionLogUrl;
	public static String genPdfUrl;
	public static String genPdfServiceUrlPath;

	public static String getVisasUrl;

	/* 系统管理员用户分组 */
	public static String adminGroup;
	public static String adminVisitIpPrefix;

	public static String searchAttention;
	public static String updateAttention;

	/**
	 * 按资源类型列出库存实时数据
	 */
	public static String totalStoreUrl;

	/**
	 * 按资源列出库存实时数据
	 */
	public static String detailStoreUrl;

	/**
	 * 取酒店名称
	 */
	public static String hotelNameUrl;
	
	/**
	 * 第三方配送地址
	 */
	public static String dispatchingUrl;
	
    /**
     * unicornTab页状态查询
     */
    public static String tabStatusUrl;

	public String getSearchAttention() {
		return searchAttention;
	}

	public void setSearchAttention(String searchAttention) {
		SystemParamInit.searchAttention = unicornUrl + searchAttention;
	}

	public String getUpdateAttention() {
		return updateAttention;
	}

	public void setUpdateAttention(String updateAttention) {
		SystemParamInit.updateAttention = unicornUrl + updateAttention;
	}

	public static String getAdminGroup() {
		return adminGroup;
	}

	public void setAdminGroup(String adminGroup) {
		SystemParamInit.adminGroup = adminGroup;
	}

	public static String getAdminVisitIpPrefix() {
		return adminVisitIpPrefix;
	}

	public void setAdminVisitIpPrefix(String adminVisitIpPrefix) {
		SystemParamInit.adminVisitIpPrefix = adminVisitIpPrefix;
	}

	public static String getGetVisasUrl() {
		return getVisasUrl;
	}

	public void setGetVisasUrl(String getVisasUrl) {
		SystemParamInit.getVisasUrl = crmUrl + getVisasUrl;
	}

	public static String flightConfirm;

	public static String getFlightConfirm() {
		return flightConfirm;
	}

	public void setFlightConfirm(String flightConfirm) {
		SystemParamInit.flightConfirm = crmUrl + flightConfirm;
	}

	public static String visaDestiantions;

	public static String getVisaDestiantions() {
		return visaDestiantions;
	}

	public void setVisaDestiantions(String visaDestiantions) {
		SystemParamInit.visaDestiantions = crmUrl + visaDestiantions;
	}

	public static String visaQueryUrl;

	public String getVisaQueryUrl() {
		return visaQueryUrl;
	}

	public void setVisaQueryUrl(String visaQueryUrl) {
		SystemParamInit.visaQueryUrl = unicornUrl + visaQueryUrl;
	}

	/** 签证接口URL路径 */
	public static String visaInterfaceUrl;

	public static String systemIdOfFlight;

	public String getSystemIdOfFlight() {
		return systemIdOfFlight;
	}

	public void setSystemIdOfFlight(String systemIdOfFlight) {
		SystemParamInit.systemIdOfFlight = systemIdOfFlight;
	}

	/**
	 * 查询boss中的pnr机票信息
	 */
	public static String queryPnrFlightInfo;

	public String getQueryPnrFlightInfo() {
		return queryPnrFlightInfo;
	}

	public void setQueryPnrFlightInfo(String queryPnrFlightInfo) {
		SystemParamInit.queryPnrFlightInfo = queryPnrFlightInfo;
	}

	/**
	 * 查询航班信息接口
	 */
	public static String queryFlightDetail;

	/**
	 * 出团通知模块地址
	 */
	public static String ntcSystem;

	/**
	 * 通过航班号查询城市信息
	 */
	public static String queryCityByFlightNum;

	/**
	 * 通过城市查询名称
	 */
	public static String queryCityByName;

	/**
	 * 通过订单号查询机票申请单信息
	 */
	public static String queryFlightApply;

	/**
	 * 云存储文件地址
	 */
	public static String attachUrl;

	public static String touristInfoOrtouristContacterInfoOfBossServerUrl;

	public static String touristInfoOrtouristContacterInfoOfBossFunction;

	public static String seatInfoOfOutOfWarehouseServerUrl;

	public static String fmisRevertUrl;

	public static String fmisBillRevertFunction;
	public static String cfmInquriyReverUrl;
	public static String cfmAssessedLossRevertUrl;
	public static String cfmOccupationRevertUrl;
	public static String cfmCancelOccupationRevertUrl;
	public static String ticketOrderUrl;
	public static String ticketOrderCountUrl;
	public static String ticketOrderRevertUrl;
	public static String ticketOrderTicketPay;
	// 调用crm接口获取大分类和城市信息地址接口
	public static String destinationsAndCityUrl;
	// 调接口获取联系人
	public static String routeContactsUrl;

	// unicorn服务器地址
	public static String unicornUrl;
	// crm服务器地址
	public static String crmUrl;
	// NG-boss资源服务器地址
	public static String ngResUrl;
	// NG-boss产品服务器地址
	public static String ngPrdUrl;
	// NG-boss自助游确认
	public static String ngResConfirmUrl;
	//fmis服务器地址
	public static String fmisUrl;
	//酒店的团购卷
	public static String hotelVerifyUrl;

	public String getNgResConfirmUrl() {
		return ngResConfirmUrl;
	}

	public void setNgResConfirmUrl(String ngResConfirmUrl) {
		SystemParamInit.ngResConfirmUrl = ngResConfirmUrl;
	}

	public String getNgResUrl() {
		return ngResUrl;
	}

	public void setNgResUrl(String ngResUrl) {
		SystemParamInit.ngResUrl = ngResUrl;
	}

	public String getNgPrdUrl() {
		return ngPrdUrl;
	}

	public void setNgPrdUrl(String ngPrdUrl) {
		SystemParamInit.ngPrdUrl = ngPrdUrl;
	}

	// 行程编辑购物店
	public static String shopList;
	public static String addShop;
	// 行程编辑器图片
	public static String spotPictures;
	public static String sncPictures;
	public static String poiPictures;
	// 特殊人群
	public static String updateSpecialPeople;
	public static String searchSpecialpeople;
	// 产品管理 基本信息
	public static String searchProductBasicInfoFromBoss;
	public static String addProductBasicInfo;
	public static String searchProductBasicInfo;
	public static String updateProductBasicInfo;
	// 产品管理 线路行程
	public static String searchProductSchedule;
	public static String updateProductSchedule;
	public static String productSync;
	// 产品管理 基础数据
	public static String getProvice;
	public static String getCity;
	public static String getSpot;
	public static String agencyManager;
	public static String productManager;
	public static String multiCityInfo;

	// 费用不包含
	public static String searchBudgetExclude;
	public static String updateBudgetExclude;

	// 发车信息
	public static String searchDepartInfo;
	public static String searchDepartInfoBoss;
	public static String updateDepartInfo;

	// 费用包含
	public static String searchBudgetInclude;
	public static String updateBudgetInclude;

	// NB查看列表
	public static String stopRetail;
	public static String searchNBList;
	public static String countList;
	public static String submitReview;
	public static String cancelReview;
	public static String returnReview;
	public static String searchProductManager;
	public static String copyProduct;
	public static String deleteProduct;
	
	//add by p-hutangyong for quenstion NB-67
	public static String searchResourceOptLogs;

	/**
	 * 资源确认单反馈地址
	 */
	public static String cfmResRevertUrl;

	public static String querySpecialProfitList; // 特殊优惠查询
	public static String editSpecialProfit; // 特殊优惠编辑
	public static String groupDateList;// 查询团期列表
	public static String queryGroupDateInfo;// 查询单个团期信息
	public static String editGroupDateInfo; // 编辑/新增团期信息
	public static String deleteGroupDateInfo;// 删除团期信息

	/** 升级方案接口URL */
	public static String queryScheme;
	public static String saveScheme;
	public static String querySchemePlanList;
	public static String querySingleSchemePlan;
	public static String deleteSingleSchemePlan;
	public static String saveSchemePlan;
	/** 升级方案接口URL */

	/**
	 * 库存初始界面列表接口
	 */
	public static String queryStockList;
	/**
	 * 途牛总控位统计接口
	 */
	public static String queryStockStaData;
	/**
	 * 供应商NB维护的批次数据统计列表接口
	 */
	public static String queryStockBatchList;
	/**
	 * 入库新增接口
	 */
	public static String importStock;
	/**
	 * 出库接口
	 */
	public static String exportStockForNBooking;
	/**
	 * 更新供应商团期预警值设置
	 */
	public static String updateStockWarningForAgency;
	/**
	 * 查询供应商团期库存 预警
	 */
	public static String getStockWarningForAgency;
	/**
	 * 查询机票信息（南京）
	 */
	public static String queryFlightNewBj;
	/**
	 * 询位单列表查询
	 */
	public static String nbAskList;
	/**
	 * 询位单列表tab页数据条数查询
	 */
	public static String nbAskTabCount;
	/**
	 * 询位单详情查询
	 */
	public static String nbAskDetails;
	/**
	 * 询位单回复
	 */
	public static String nbAskReply;
	/**
	 * 询位单历史记录
	 */
	public static String nbAskHistory;

	/**
	 * 查询取票人信息
	 */
	public static String searchPersonInfo;

	/**
	 * 产品其他信息
	 */
	public static String queryProductOtherInfo;
	public static String updateProductOtherInfo;

	/**
	 * 查询出发城市名称
	 */
	public static String searchBeginCityName;

	/**
	 * 特别条款信息
	 */
	public static String searchSpecialAgreement;
	public static String updateSpecialAgreement;

	public static String rtxUrl;
	public static String rtxMethod;
	public static String edmEmail;
	public static String campaignId;
	public static String mailId;
	public static String sendMessage;
	public static Integer smsTaskId;
	public static Integer opId;
	
	

	public static String queryFlightTicketList;
	public static String queryBossFlightTicketList;
	public static String queryHotelRoomList;
	public static String queryBossHotelRoomList;
	public static String queryPackageResourceList;
	public static String queryBossPackageResourceList;

	public static String removeResourceDraft;
	public static String queryReturnView;
	public static String countResourceList;

	public static String addResourceDraft;

	public static String submitReviewForRes;
	public static String cancelReviewForRes;

	public static String searchResourceActionLog;

	public static String searchResourceConfirmation;
	public static String searchResourceConfirmationDetail;
	public static String feedbackResourceConfirmation;
	
	public static String oaApi;

	public String getSearchPersonInfo() {
		return searchPersonInfo;
	}

	public void setSearchPersonInfo(String searchPersonInfo) {
		SystemParamInit.searchPersonInfo = searchPersonInfo;
	}

	public String getQueryFlightNewBj() {
		return queryFlightNewBj;
	}

	public void setQueryFlightNewBj(String queryFlightNewBj) {
		SystemParamInit.queryFlightNewBj = queryFlightNewBj;
	}

	/**
	 * 产品经理推荐内容
	 */
	public static String queryRoutesManagerRecommend;
	public static String updateRoutesManagerRecommend;

	public String getQueryRoutesManagerRecommend() {
		return queryRoutesManagerRecommend;
	}

	public void setQueryRoutesManagerRecommend(String queryRoutesManagerRecommend) {
		SystemParamInit.queryRoutesManagerRecommend = unicornUrl + queryRoutesManagerRecommend;
	}

	public String getUpdateRoutesManagerRecommend() {
		return updateRoutesManagerRecommend;
	}

	public void setUpdateRoutesManagerRecommend(String updateRoutesManagerRecommend) {
		SystemParamInit.updateRoutesManagerRecommend = unicornUrl + updateRoutesManagerRecommend;
	}

	public static String queryCityByNameNew;

	public String getQueryCityByNameNew() {
		return queryCityByNameNew;
	}

	public void setQueryCityByNameNew(String queryCityByNameNew) {
		SystemParamInit.queryCityByNameNew = queryCityByNameNew;
	}

	/**
	 * 目的地信息缓存在内存中
	 */
	public static String str;
	/**
	 * 日志监控级别 info 记录所有接口 error 记录success为false的接口
	 */
	public static String level = "ERROR";
	public static Integer agencyHierarchy;
	
	/**
	 * 查询收款签约列表
	 */
	public static String signList;
	/**
	 * 查询供应商各个状态下的订单数量
	 */
	public static String signListCount;
	/**
	 * 查询订单详情
	 */
	public static String signDetail;
	/**
	 * 新增收款
	 */
	public static String addAmt;
	/**
	 * 添加订单备注
	 */
	public static String noAmt;
	/**
	 * 新增编辑合同
	 */
	public static String contract;
	/**
	 * 提交签约
	 */
	public static String sign;
	/**
	 * 撤销审核
	 */
	public static String cancelSign;
	/**
	 * 删除合同
	 */
	public static String delContract;

	public void setLevel(String level) {
		SystemParamInit.level = level;
	}

	public void setLogLevel(String level) {
		SystemParamInit.level = level;
	}

	/**
	 * 供应商账号类型配置
	 * 
	 * 注：新增账号类型在此处添加配置即可
	 * 
	 * key：账号前缀标记（两位大写的英文字母） value：标记值（从1递增）
	 */
	public static String accountType = "{\"BS\": 1,\"FI\": 2}";

	/**
	 * the str to set
	 */
	public void setStr() {
		SystemParamInit.str = "[{\"id\": 7,\"name\": \"周边\",\"product_cat_info\": []},{\"id\": 8,\"name\": \"国内长线\",\"product_cat_info\": []},{\"id\": 9,\"name\": \"出境短线\",\"product_cat_info\": []},{\"id\": 10,\"name\": \"出境长线\",\"product_cat_info\": []}]";
	}

	/**
	 * @param str
	 *            the str to set
	 */
	public static void initValue() {

//		if (StringUtil.isEmptyStr(SystemParamInit.str)) {
//
//			try {
//				SystemParamInit.str = AgencyClient.getDestinations();
//			} catch (Exception e) {
//				// 接口不通时取默认值
//				setStr();
//				LOG.error("error in method setStr,SystemParamInit str:" + e);
//			}
//		}
	}

	/**
	 * @return the destinationsAndCityUrl
	 */
	public String getDestinationsAndCityUrl() {
		return destinationsAndCityUrl;
	}

	/**
	 * @param destinationsAndCityUrl
	 *            the destinationsAndCityUrl to set
	 */
	public void setDestinationsAndCityUrl(String destinationsAndCityUrl) {
		SystemParamInit.destinationsAndCityUrl = destinationsAndCityUrl;
	}

	public String getTicketOrderCountUrl() {
		return ticketOrderCountUrl;
	}

	public void setTicketOrderCountUrl(String ticketOrderCountUrl) {
		SystemParamInit.ticketOrderCountUrl = ticketOrderCountUrl;
	}

	public String getCfmOccupationRevertUrl() {
		return cfmOccupationRevertUrl;
	}

	public void setCfmOccupationRevertUrl(String cfmOccupationRevertUrl) {
		SystemParamInit.cfmOccupationRevertUrl = cfmOccupationRevertUrl;
	}

	public String getTicketOrderUrl() {
		return ticketOrderUrl;
	}

	public void setTicketOrderUrl(String ticketOrderUrl) {
		SystemParamInit.ticketOrderUrl = ticketOrderUrl;
	}

	public String getTicketOrderRevertUrl() {
		return ticketOrderRevertUrl;
	}

	public void setTicketOrderRevertUrl(String ticketOrderRevertUrl) {
		SystemParamInit.ticketOrderRevertUrl = ticketOrderRevertUrl;
	}

	public String getEditSpecialProfit() {
		return editSpecialProfit;
	}

	public void setEditSpecialProfit(String editSpecialProfit) {
		SystemParamInit.editSpecialProfit = unicornUrl + editSpecialProfit;
	}

	public String getGroupDateList() {
		return groupDateList;
	}

	public void setGroupDateList(String groupDateList) {
		SystemParamInit.groupDateList = unicornUrl + groupDateList;
	}

	public String getQueryGroupDateInfo() {
		return queryGroupDateInfo;
	}

	public void setQueryGroupDateInfo(String queryGroupDateInfo) {
		SystemParamInit.queryGroupDateInfo = unicornUrl + queryGroupDateInfo;
	}

	public String getEditGroupDateInfo() {
		return editGroupDateInfo;
	}

	public void setEditGroupDateInfo(String editGroupDateInfo) {
		SystemParamInit.editGroupDateInfo = unicornUrl + editGroupDateInfo;
	}

	public String getDeleteGroupDateInfo() {
		return deleteGroupDateInfo;
	}

	public void setDeleteGroupDateInfo(String deleteGroupDateInfo) {
		SystemParamInit.deleteGroupDateInfo = unicornUrl + deleteGroupDateInfo;
	}

	public String getQuerySpecialProfitList() {
		return querySpecialProfitList;
	}

	public void setQuerySpecialProfitList(String querySpecialProfitList) {
		SystemParamInit.querySpecialProfitList = unicornUrl + querySpecialProfitList;
	}

	public String getCfmAssessedLossRevertUrl() {
		return cfmAssessedLossRevertUrl;
	}

	public void setCfmAssessedLossRevertUrl(String cfmAssessedLossRevertUrl) {
		SystemParamInit.cfmAssessedLossRevertUrl = cfmAssessedLossRevertUrl;
	}

	public String getCfmInquriyReverUrl() {
		return cfmInquriyReverUrl;
	}

	public void setCfmInquriyReverUrl(String cfmInquriyReverUrl) {
		SystemParamInit.cfmInquriyReverUrl = cfmInquriyReverUrl;
	}

	public String getXmlRpcGroupSelfFunction() {
		return xmlRpcGroupSelfFunction;
	}

	public String getXmlRpcReplyDamageFunction() {
		return xmlRpcReplyDamageFunction;
	}

	public void setXmlRpcReplyDamageFunction(String xmlRpcReplyDamageFunction) {
		SystemParamInit.xmlRpcReplyDamageFunction = xmlRpcReplyDamageFunction;
	}

	public String getXmlRpcAgencyMenuRoleFunction() {
		return xmlRpcAgencyMenuRoleFunction;
	}

	public void setXmlRpcAgencyMenuRoleFunction(String xmlRpcAgencyMenuRoleFunction) {
		SystemParamInit.xmlRpcAgencyMenuRoleFunction = xmlRpcAgencyMenuRoleFunction;
	}

	public String getXmlRpcFeedbackFunction() {
		return xmlRpcFeedbackFunction;
	}

	public void setXmlRpcFeedbackFunction(String xmlRpcFeedbackFunction) {
		SystemParamInit.xmlRpcFeedbackFunction = xmlRpcFeedbackFunction;
	}

	public String getAgencyFilePath() {
		return agencyFilePath;
	}

	public void setAgencyFilePath(String agencyFilePath) {
		SystemParamInit.agencyFilePath = agencyFilePath;
	}

	public void setXmlRpcGroupSelfFunction(String xmlRpcGroupSelfFunction) {
		SystemParamInit.xmlRpcGroupSelfFunction = xmlRpcGroupSelfFunction;
	}

	public String getXmlRpcReplyFunction() {
		return xmlRpcReplyFunction;
	}

	public void setXmlRpcReplyFunction(String xmlRpcReplyFunction) {
		SystemParamInit.xmlRpcReplyFunction = xmlRpcReplyFunction;
	}

	public String getAgencyURL() {
		return agencyURL;
	}

	public void setAgencyURL(String agencyURL) {
		SystemParamInit.agencyURL = agencyURL;
	}

	public String getXmlRpcServerUrl() {
		return xmlRpcServerUrl;
	}

	public void setXmlRpcServerUrl(String xmlRpcServerUrl) {
		SystemParamInit.xmlRpcServerUrl = xmlRpcServerUrl;
	}

	public String getXmlRpcOrderFunction() {
		return xmlRpcOrderFunction;
	}

	public void setXmlRpcOrderFunction(String xmlRpcOrderFunction) {
		SystemParamInit.xmlRpcOrderFunction = xmlRpcOrderFunction;
	}

	public String getXmlRpcBatchFunction() {
		return xmlRpcBatchFunction;
	}

	public void setXmlRpcBatchFunction(String xmlRpcBatchFunction) {
		SystemParamInit.xmlRpcBatchFunction = xmlRpcBatchFunction;
	}

	public int getXmlRpcClientId() {
		return xmlRpcClientId;
	}

	public void setXmlRpcClientId(int xmlRpcClientId) {
		SystemParamInit.xmlRpcClientId = xmlRpcClientId;
	}

	public String getXmlRpcClientKey() {
		return xmlRpcClientKey;
	}

	public void setXmlRpcClientKey(String xmlRpcClientKey) {
		SystemParamInit.xmlRpcClientKey = xmlRpcClientKey;
	}

	public String getAllowIp() {
		return allowIp;
	}

	public void setAllowIp(String allowIp) {
		SystemParamInit.allowIp = allowIp;
	}

	public String getPdfUrlScheme() {
		return pdfUrlScheme;
	}

	public void setPdfUrlScheme(String pdfUrlScheme) {
		SystemParamInit.pdfUrlScheme = pdfUrlScheme;
	}

	public String getPdfUrlHost() {
		return pdfUrlHost;
	}

	public void setPdfUrlHost(String pdfUrlHost) {
		SystemParamInit.pdfUrlHost = pdfUrlHost;
	}

	public String getGenPdfUrl() {
		return genPdfUrl;
	}

	public void setGenPdfUrl(String genPdfUrl) {
		SystemParamInit.genPdfUrl = genPdfUrl;
	}

	public String getGenPdfServiceUrlPath() {
		return genPdfServiceUrlPath;
	}

	public void setGenPdfServiceUrlPath(String genPdfServiceUrlPath) {
		SystemParamInit.genPdfServiceUrlPath = genPdfServiceUrlPath;
	}

	public int getPdfPort() {
		return pdfPort;
	}

	public void setPdfPort(int pdfPort) {
		SystemParamInit.pdfPort = pdfPort;
	}

	public String getPdfServiceUrlPath() {
		return pdfServiceUrlPath;
	}

	public void setPdfServiceUrlPath(String pdfServiceUrlPath) {
		SystemParamInit.pdfServiceUrlPath = pdfServiceUrlPath;
	}

	public String getVisaInterfaceUrl() {
		return visaInterfaceUrl;
	}

	public void setVisaInterfaceUrl(String visaInterfaceUrl) {
		SystemParamInit.visaInterfaceUrl = visaInterfaceUrl;
	}

	public String getAttachUrl() {
		return attachUrl;
	}

	public void setAttachUrl(String attachUrl) {
		SystemParamInit.attachUrl = attachUrl;
	}

	public String getTouristInfoOrtouristContacterInfoOfBossServerUrl() {
		return touristInfoOrtouristContacterInfoOfBossServerUrl;
	}

	public void setTouristInfoOrtouristContacterInfoOfBossServerUrl(String touristInfoOrtouristContacterInfoOfBossServerUrl) {
		SystemParamInit.touristInfoOrtouristContacterInfoOfBossServerUrl = touristInfoOrtouristContacterInfoOfBossServerUrl;
	}

	public String getTouristInfoOrtouristContacterInfoOfBossFunction() {
		return touristInfoOrtouristContacterInfoOfBossFunction;
	}

	public void setTouristInfoOrtouristContacterInfoOfBossFunction(String touristInfoOrtouristContacterInfoOfBossFunction) {
		SystemParamInit.touristInfoOrtouristContacterInfoOfBossFunction = touristInfoOrtouristContacterInfoOfBossFunction;
	}

	public String getSeatInfoOfOutOfWarehouseServerUrl() {
		return seatInfoOfOutOfWarehouseServerUrl;
	}

	public void setSeatInfoOfOutOfWarehouseServerUrl(String seatInfoOfOutOfWarehouseServerUrl) {
		SystemParamInit.seatInfoOfOutOfWarehouseServerUrl = seatInfoOfOutOfWarehouseServerUrl;
	}

	/**
	 * @return the fmisRevertUrl
	 */
	public String getFmisRevertUrl() {
		return fmisRevertUrl;
	}

	/**
	 * @param fmisRevertUrl
	 *            the fmisRevertUrl to set
	 */
	public void setFmisRevertUrl(String fmisRevertUrl) {
		SystemParamInit.fmisRevertUrl = fmisRevertUrl;
	}

	/**
	 * @return the fmisBillRevertFunction
	 */
	public String getFmisBillRevertFunction() {
		return fmisBillRevertFunction;
	}

	/**
	 * @param fmisBillRevertFunction
	 *            the fmisBillRevertFunction to set
	 */
	public void setFmisBillRevertFunction(String fmisBillRevertFunction) {
		SystemParamInit.fmisBillRevertFunction = fmisBillRevertFunction;
	}

	public String getAgencyTouristStatisticServerUrl() {
		return agencyTouristStatisticServerUrl;
	}

	public void setAgencyTouristStatisticServerUrl(String agencyTouristStatisticServerUrl) {
		SystemParamInit.agencyTouristStatisticServerUrl = agencyTouristStatisticServerUrl;
	}

	public String getAgencyTouristStatisticFunction() {
		return agencyTouristStatisticFunction;
	}

	public void setAgencyTouristStatisticFunction(String agencyTouristStatisticFunction) {
		SystemParamInit.agencyTouristStatisticFunction = agencyTouristStatisticFunction;
	}

	public String getRouteOrderNumFunction() {
		return routeOrderNumFunction;
	}

	public void setRouteOrderNumFunction(String routeOrderNumFunction) {
		SystemParamInit.routeOrderNumFunction = routeOrderNumFunction;
	}

	public String getRouteOrderNumServerUrl() {
		return routeOrderNumServerUrl;
	}

	public void setRouteOrderNumServerUrl(String routeOrderNumServerUrl) {
		SystemParamInit.routeOrderNumServerUrl = routeOrderNumServerUrl;
	}

	public String getRouteOrderInfoFunction() {
		return routeOrderInfoFunction;
	}

	public void setRouteOrderInfoFunction(String routeOrderInfoFunction) {
		SystemParamInit.routeOrderInfoFunction = routeOrderInfoFunction;
	}

	public String getRouteOrderInfoServerUrl() {
		return routeOrderInfoServerUrl;
	}

	public void setRouteOrderInfoServerUrl(String routeOrderInfoServerUrl) {
		SystemParamInit.routeOrderInfoServerUrl = routeOrderInfoServerUrl;
	}

	public String getCfmResRevertUrl() {
		return cfmResRevertUrl;
	}

	public void setCfmResRevertUrl(String cfmResRevertUrl) {
		SystemParamInit.cfmResRevertUrl = cfmResRevertUrl;
	}

	public String getQueryFlightDetail() {
		return queryFlightDetail;
	}

	public void setQueryFlightDetail(String queryFlightDetail) {
		SystemParamInit.queryFlightDetail = queryFlightDetail;
	}

	public String getNtcSystem() {
		return ntcSystem;
	}

	public void setNtcSystem(String ntcSystem) {
		SystemParamInit.ntcSystem = ntcSystem;
	}

	public String getQueryCityByFlightNum() {
		return queryCityByFlightNum;
	}

	public void setQueryCityByFlightNum(String queryCityByFlightNum) {
		SystemParamInit.queryCityByFlightNum = queryCityByFlightNum;
	}

	public String getQueryCityByName() {
		return queryCityByName;
	}

	public void setQueryFlightApply(String queryFlightApply) {
		SystemParamInit.queryFlightApply = queryFlightApply;
	}

	public String getQueryFlightApply() {
		return queryFlightApply;
	}

	public void setQueryCityByName(String queryCityByName) {
		SystemParamInit.queryCityByName = queryCityByName;
	}

	public String getTicketOrderTicketPay() {
		return ticketOrderTicketPay;
	}

	public void setTicketOrderTicketPay(String ticketOrderTicketPay) {
		SystemParamInit.ticketOrderTicketPay = ticketOrderTicketPay;
	}

	/**
	 * @return the cfmCancelOccupationRevertUrl
	 */
	public String getCfmCancelOccupationRevertUrl() {
		return cfmCancelOccupationRevertUrl;
	}

	/**
	 * @param cfmCancelOccupationRevertUrl
	 *            the cfmCancelOccupationRevertUrl to set
	 */
	public void setCfmCancelOccupationRevertUrl(String cfmCancelOccupationRevertUrl) {
		SystemParamInit.cfmCancelOccupationRevertUrl = cfmCancelOccupationRevertUrl;
	}

	public String getBbSystemAccountUrl() {
		return bbSystemAccountUrl;
	}

	public void setBbSystemAccountUrl(String bbSystemAccountUrl) {
		SystemParamInit.bbSystemAccountUrl = bbSystemAccountUrl;
	}

	public String getRouteContactsUrl() {
		return routeContactsUrl;
	}

	public void setRouteContactsUrl(String routeContactsUrl) {
		SystemParamInit.routeContactsUrl = routeContactsUrl;
	}

	public String getSearchProductBasicInfoFromBoss() {
		return searchProductBasicInfoFromBoss;
	}

	public void setSearchProductBasicInfoFromBoss(String searchProductBasicInfoFromBoss) {
		SystemParamInit.searchProductBasicInfoFromBoss = crmUrl + searchProductBasicInfoFromBoss;
	}

	public String getAddProductBasicInfo() {
		return addProductBasicInfo;
	}

	public void setAddProductBasicInfo(String addProductBasicInfo) {
		SystemParamInit.addProductBasicInfo = unicornUrl + addProductBasicInfo;
	}

	public String getSearchProductBasicInfo() {
		return searchProductBasicInfo;
	}

	public void setSearchProductBasicInfo(String searchProductBasicInfo) {
		SystemParamInit.searchProductBasicInfo = unicornUrl + searchProductBasicInfo;
	}

	public String getUpdateProductBasicInfo() {
		return updateProductBasicInfo;
	}

	public void setUpdateProductBasicInfo(String updateProductBasicInfo) {
		SystemParamInit.updateProductBasicInfo = unicornUrl + updateProductBasicInfo;
	}

	public String getShopList() {
		return shopList;
	}

	public void setShopList(String shopList) {
		SystemParamInit.shopList = crmUrl + shopList;
	}

	public String getAddShop() {
		return addShop;
	}

	public void setAddShop(String addShop) {
		SystemParamInit.addShop = crmUrl + addShop;
	}

	public String getSearchProductSchedule() {
		return searchProductSchedule;
	}

	public void setSearchProductSchedule(String searchProductSchedule) {
		SystemParamInit.searchProductSchedule = unicornUrl + searchProductSchedule;
	}

	public String getUpdateProductSchedule() {
		return updateProductSchedule;
	}

	public void setUpdateProductSchedule(String updateProductSchedule) {
		SystemParamInit.updateProductSchedule = unicornUrl + updateProductSchedule;
	}

	public String getProductSync() {
		return productSync;
	}

	public void setProductSync(String productSync) {
		SystemParamInit.productSync = unicornUrl + productSync;
	}

	public String getSpotPictures() {
		return spotPictures;
	}

	public void setSpotPictures(String spotPictures) {
		SystemParamInit.spotPictures = crmUrl + spotPictures;
	}

	public String getSncPictures() {
		return sncPictures;
	}

	public void setSncPictures(String sncPictures) {
		SystemParamInit.sncPictures = sncPictures;
	}
	
	public  String getMultiCityInfo() {
		return multiCityInfo;
	}

	public  void setMultiCityInfo(String multiCityInfo) {
		SystemParamInit.multiCityInfo = multiCityInfo;
	}

	public String getGetProvice() {
		return getProvice;
	}

	public void setGetProvice(String getProvice) {
		SystemParamInit.getProvice = crmUrl + getProvice;
	}

	public String getGetCity() {
		return getCity;
	}

	public void setGetCity(String getCity) {
		SystemParamInit.getCity = crmUrl + getCity;
	}

	public String getGetSpot() {
		return getSpot;
	}

	public void setGetSpot(String getSpot) {
		SystemParamInit.getSpot = getSpot;
	}

	public String getAgencyManager() {
		return agencyManager;
	}

	public void setAgencyManager(String agencyManager) {
		SystemParamInit.agencyManager = agencyManager;
	}

	public String getProductManager() {
		return productManager;
	}

	public void setProductManager(String productManager) {
		SystemParamInit.productManager = crmUrl + productManager;
	}

	public String getSearchDepartInfo() {
		return searchDepartInfo;
	}

	public void setSearchDepartInfo(String searchDepartInfo) {
		SystemParamInit.searchDepartInfo = unicornUrl + searchDepartInfo;
	}

	public String getUpdateDepartInfo() {
		return updateDepartInfo;
	}

	public void setUpdateDepartInfo(String updateDepartInfo) {
		SystemParamInit.updateDepartInfo = unicornUrl + updateDepartInfo;
	}

	public String getSearchBudgetInclude() {
		return searchBudgetInclude;
	}

	public void setSearchBudgetInclude(String searchBudgetInclude) {
		SystemParamInit.searchBudgetInclude = unicornUrl + searchBudgetInclude;
	}

	public String getUpdateBudgetInclude() {
		return updateBudgetInclude;
	}

	public void setUpdateBudgetInclude(String updateBudgetInclude) {
		SystemParamInit.updateBudgetInclude = unicornUrl + updateBudgetInclude;
	}

	public String getSearchBudgetExclude() {
		return searchBudgetExclude;
	}

	public void setSearchBudgetExclude(String searchBudgetExclude) {
		SystemParamInit.searchBudgetExclude = unicornUrl + searchBudgetExclude;
	}

	public String getUpdateBudgetExclude() {
		return updateBudgetExclude;
	}

	public void setUpdateBudgetExclude(String updateBudgetExclude) {
		SystemParamInit.updateBudgetExclude = unicornUrl + updateBudgetExclude;
	}

	public String getQuerySelfCharge() {
		return querySelfCharge;
	}

	public void setQuerySelfCharge(String querySelfCharge) {
		SystemParamInit.querySelfCharge = unicornUrl + querySelfCharge;
	}

	public String getUpdateSelfCharge() {
		return updateSelfCharge;
	}

	public void setUpdateSelfCharge(String updateSelfCharge) {
		SystemParamInit.updateSelfCharge = unicornUrl + updateSelfCharge;
	}

	public String getQueryImportantInfo() {
		return queryImportantInfo;
	}

	public void setQueryImportantInfo(String queryImportantInfo) {
		SystemParamInit.queryImportantInfo = unicornUrl + queryImportantInfo;
	}

	public String getUpdateImportantInfo() {
		return updateImportantInfo;
	}

	public void setUpdateImportantInfo(String updateImportantInfo) {
		SystemParamInit.updateImportantInfo = unicornUrl + updateImportantInfo;
	}

	public String getSearchNBList() {
		return searchNBList;
	}

	public void setSearchNBList(String searchNBList) {
		SystemParamInit.searchNBList = unicornUrl + searchNBList;
	}

	public String getCountList() {
		return countList;
	}

	public void setCountList(String countList) {
		SystemParamInit.countList = unicornUrl + countList;
	}

	public String getSubmitReview() {
		return submitReview;
	}

	public void setSubmitReview(String submitReview) {
		SystemParamInit.submitReview = unicornUrl + submitReview;
	}

	public String getCancelReview() {
		return cancelReview;
	}

	public void setCancelReview(String cancelReview) {
		SystemParamInit.cancelReview = unicornUrl + cancelReview;
	}

	public String getReturnReview() {
		return returnReview;
	}

	public void setReturnReview(String returnReview) {
		SystemParamInit.returnReview = unicornUrl + returnReview;
	}

	public String getSearchProductManager() {
		return searchProductManager;
	}

	public void setSearchProductManager(String searchProductManager) {
		SystemParamInit.searchProductManager = unicornUrl + searchProductManager;
	}

	public String getSearchDepartInfoBoss() {
		return searchDepartInfoBoss;
	}

	public void setSearchDepartInfoBoss(String searchDepartInfoBoss) {
		SystemParamInit.searchDepartInfoBoss = crmUrl + searchDepartInfoBoss;
	}

	public String getUnicornUrl() {
		return unicornUrl;
	}

	public void setUnicornUrl(String unicornUrl) {
		SystemParamInit.unicornUrl = unicornUrl;
	}

	public String getQueryProductActionLogUrl() {
		return queryProductActionLogUrl;
	}

	public void setQueryProductActionLogUrl(String queryProductActionLogUrl) {
		SystemParamInit.queryProductActionLogUrl = unicornUrl + queryProductActionLogUrl;
	}

	public String getAddProductActionLogUrl() {
		return addProductActionLogUrl;
	}

	public void setAddProductActionLogUrl(String addProductActionLogUrl) {
		SystemParamInit.addProductActionLogUrl = unicornUrl + addProductActionLogUrl;
	}

	public String getCrmUrl() {
		return crmUrl;
	}

	public void setCrmUrl(String crmUrl) {
		SystemParamInit.crmUrl = crmUrl;
	}

	public String getCopyProduct() {
		return copyProduct;
	}

	public void setCopyProduct(String copyProduct) {
		SystemParamInit.copyProduct = unicornUrl + copyProduct;
	}

	public String getQueryStockList() {
		return queryStockList;
	}

	public void setQueryStockList(String queryStockList) {
		SystemParamInit.queryStockList = crmUrl + queryStockList;
	}

	public String getQueryStockStaData() {
		return queryStockStaData;
	}

	public void setQueryStockStaData(String queryStockStaData) {
		SystemParamInit.queryStockStaData = crmUrl + queryStockStaData;
	}

	public String getQueryStockBatchList() {
		return queryStockBatchList;
	}

	public void setQueryStockBatchList(String queryStockBatchList) {
		SystemParamInit.queryStockBatchList = crmUrl + queryStockBatchList;
	}

	public String getImportStock() {
		return importStock;
	}

	public void setImportStock(String importStock) {
		SystemParamInit.importStock = crmUrl + importStock;
	}

	public String getExportStockForNBooking() {
		return exportStockForNBooking;
	}

	public void setExportStockForNBooking(String exportStockForNBooking) {
		SystemParamInit.exportStockForNBooking = crmUrl + exportStockForNBooking;
	}

	public String getDeleteProduct() {
		return deleteProduct;
	}

	public void setDeleteProduct(String deleteProduct) {
		SystemParamInit.deleteProduct = unicornUrl + deleteProduct;
	}

	public String getSearchResourceOptLogs()
	{
		return searchResourceOptLogs;
	}
	
	public void setSearchResourceOptLogs(String searchResourceOptLogs)
	{
		SystemParamInit.searchResourceOptLogs = unicornUrl + searchResourceOptLogs;
	}
	
	public String getUpdateStockWarningForAgency() {
		return updateStockWarningForAgency;
	}

	public void setUpdateStockWarningForAgency(String updateStockWarningForAgency) {
		SystemParamInit.updateStockWarningForAgency = crmUrl + updateStockWarningForAgency;
	}

	public String getGetStockWarningForAgency() {
		return getStockWarningForAgency;
	}

	public void setGetStockWarningForAgency(String getStockWarningForAgency) {
		SystemParamInit.getStockWarningForAgency = crmUrl + getStockWarningForAgency;
	}

	public String getQueryScheme() {
		return queryScheme;
	}

	public void setQueryScheme(String queryScheme) {
		SystemParamInit.queryScheme = unicornUrl + queryScheme;
	}

	public String getSaveScheme() {
		return saveScheme;
	}

	public void setSaveScheme(String saveScheme) {
		SystemParamInit.saveScheme = unicornUrl + saveScheme;
	}

	public String getQuerySchemePlanList() {
		return querySchemePlanList;
	}

	public void setQuerySchemePlanList(String querySchemePlanList) {
		SystemParamInit.querySchemePlanList = unicornUrl + querySchemePlanList;
	}

	public String getQuerySingleSchemePlan() {
		return querySingleSchemePlan;
	}

	public void setQuerySingleSchemePlan(String querySingleSchemePlan) {
		SystemParamInit.querySingleSchemePlan = unicornUrl + querySingleSchemePlan;
	}

	public String getSaveSchemePlan() {
		return saveSchemePlan;
	}

	public void setSaveSchemePlan(String saveSchemePlan) {
		SystemParamInit.saveSchemePlan = unicornUrl + saveSchemePlan;
	}

	public String getDeleteSingleSchemePlan() {
		return deleteSingleSchemePlan;
	}

	public void setDeleteSingleSchemePlan(String deleteSingleSchemePlan) {
		SystemParamInit.deleteSingleSchemePlan = unicornUrl + deleteSingleSchemePlan;
	}

	public String getPoiPictures() {
		return poiPictures;
	}

	public void setPoiPictures(String poiPictures) {
		SystemParamInit.poiPictures = poiPictures;
	}

	public String getNbAskList() {
		return nbAskList;
	}

	public void setNbAskList(String nbAskList) {
		SystemParamInit.nbAskList = crmUrl + nbAskList;
	}

	public String getNbAskTabCount() {
		return nbAskTabCount;
	}

	public void setNbAskTabCount(String nbAskTabCount) {
		SystemParamInit.nbAskTabCount = crmUrl + nbAskTabCount;
	}

	public String getNbAskDetails() {
		return nbAskDetails;
	}

	public void setNbAskDetails(String nbAskDetails) {
		SystemParamInit.nbAskDetails = crmUrl + nbAskDetails;
	}

	public String getNbAskReply() {
		return nbAskReply;
	}

	public void setNbAskReply(String nbAskReply) {
		SystemParamInit.nbAskReply = crmUrl + nbAskReply;
	}

	public String getNbAskHistory() {
		return nbAskHistory;
	}

	public void setNbAskHistory(String nbAskHistory) {
		SystemParamInit.nbAskHistory = crmUrl + nbAskHistory;
	}

	// 根据航班号查询机票接口
	public static String getFlightTicket;

	public String getGetFlightTicket() {
		return getFlightTicket;
	}

	public void setGetFlightTicket(String getFlightTicket) {
		SystemParamInit.getFlightTicket = getFlightTicket;
	}

	public String getRtxUrl() {
		return rtxUrl;
	}

	public void setRtxUrl(String rtxUrl) {
		SystemParamInit.rtxUrl = rtxUrl;
	}

	public String getRtxMethod() {
		return rtxMethod;
	}

	public void setRtxMethod(String rtxMethod) {
		SystemParamInit.rtxMethod = rtxMethod;
	}

	public String getEdmEmail() {
		return edmEmail;
	}

	public void setEdmEmail(String edmEmail) {
		SystemParamInit.edmEmail = edmEmail;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		SystemParamInit.campaignId = campaignId;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		SystemParamInit.mailId = mailId;
	}

	public String getQueryProductOtherInfo() {
		return queryProductOtherInfo;
	}

	public void setQueryProductOtherInfo(String queryProductOtherInfo) {
		SystemParamInit.queryProductOtherInfo = unicornUrl + queryProductOtherInfo;
	}

	public String getUpdateProductOtherInfo() {
		return updateProductOtherInfo;
	}

	public void setUpdateProductOtherInfo(String updateProductOtherInfo) {
		SystemParamInit.updateProductOtherInfo = unicornUrl + updateProductOtherInfo;
	}

	public String getSearchSpecialpeople() {
		return searchSpecialpeople;
	}

	public void setSearchSpecialpeople(String searchSpecialpeople) {
		SystemParamInit.searchSpecialpeople = unicornUrl + searchSpecialpeople;
	}

	public String getUpdateSpecialPeople() {
		return updateSpecialPeople;
	}

	public void setUpdateSpecialPeople(String updateSpecialPeople) {
		SystemParamInit.updateSpecialPeople = unicornUrl + updateSpecialPeople;
	}

	public String getQueryFlightTicketList() {
		return queryFlightTicketList;
	}

	public void setQueryFlightTicketList(String queryFlightTicketList) {
		SystemParamInit.queryFlightTicketList = unicornUrl + queryFlightTicketList;
	}

	public String getQueryBossFlightTicketList() {
		return queryBossFlightTicketList;
	}

	public void setQueryBossFlightTicketList(String queryBossFlightTicketList) {
		SystemParamInit.queryBossFlightTicketList = unicornUrl + queryBossFlightTicketList;
	}

	public String getQueryHotelRoomList() {
		return queryHotelRoomList;
	}

	public void setQueryHotelRoomList(String queryHotelRoomList) {
		SystemParamInit.queryHotelRoomList = unicornUrl + queryHotelRoomList;
	}

	public String getQueryBossHotelRoomList() {
		return queryBossHotelRoomList;
	}

	public void setQueryBossHotelRoomList(String queryBossHotelRoomList) {
		SystemParamInit.queryBossHotelRoomList = unicornUrl + queryBossHotelRoomList;
	}

	public String getQueryPackageResourceList() {
		return queryPackageResourceList;
	}

	public void setQueryPackageResourceList(String queryPackageResourceList) {
		SystemParamInit.queryPackageResourceList = unicornUrl + queryPackageResourceList;
	}

	public String getQueryBossPackageResourceList() {
		return queryBossPackageResourceList;
	}

	public void setQueryBossPackageResourceList(String queryBossPackageResourceList) {
		SystemParamInit.queryBossPackageResourceList = unicornUrl + queryBossPackageResourceList;
	}

	/**
	 * 资源日历看板列表接口地址
	 */
	public static String resourceCalendar;

	public String getResourceCalendar() {
		return resourceCalendar;
	}

	public void setResourceCalendar(String resourceCalendar) {
		SystemParamInit.resourceCalendar = unicornUrl + resourceCalendar;
	}

	/**
	 * 资源采购规则及其采购方式
	 */
	public static String resourcePurchaseRuleDetail;

	public String getResourcePurchaseRuleDetail() {
		return resourcePurchaseRuleDetail;
	}

	public void setResourcePurchaseRuleDetail(String resourcePurchaseRuleDetail) {
		SystemParamInit.resourcePurchaseRuleDetail = unicornUrl + resourcePurchaseRuleDetail;
	}

	/**
	 * 资源采购规则之审核内容列表
	 */
	public static String resourcePurchaseRuleDetailListUnderReview;

	public String getResourcePurchaseRuleDetailListUnderReview() {
		return resourcePurchaseRuleDetailListUnderReview;
	}

	public void setResourcePurchaseRuleDetailListUnderReview(String resourcePurchaseRuleDetailListUnderReview) {
		SystemParamInit.resourcePurchaseRuleDetailListUnderReview = unicornUrl + resourcePurchaseRuleDetailListUnderReview;
	}

	/**
	 * 资源库存-查某个团期批次列表
	 * 
	 * @author xiongyun
	 */
	public static String searchResourceStock;
	/**
	 * 资源库存-查某个批次详情
	 * 
	 * @author xiongyun
	 */
	public static String searchResourceStockDetail;
	/**
	 * 资源库存-新增编辑批次库存(新增入库,补库，编辑，调价)
	 * 
	 * @author xiongyun
	 */
	public static String inResourceRound;
	/**
	 * 资源库存-出库
	 * 
	 * @author xiongyun
	 */
	public static String outResourceRound;

	/**
	 * 资源库存-删除批次
	 * 
	 * @author xiongyun
	 */
	public static String delResourceRound;

	/**
	 * 查看资源关联产品
	 * 
	 * @author xiongyun
	 */
	public static String searchRelatedProduct;

	/**
	 * 查看资源详情
	 * 
	 * @param params
	 * @return
	 */
	public static String searchResourceInfo;

	public String getSearchResourceStock() {
		return searchResourceStock;
	}

	public void setSearchResourceStock(String searchResourceStock) {
		SystemParamInit.searchResourceStock = unicornUrl + searchResourceStock;
	}

	public String getSearchResourceStockDetail() {
		return searchResourceStockDetail;
	}

	public void setSearchResourceStockDetail(String searchResourceStockDetail) {
		SystemParamInit.searchResourceStockDetail = unicornUrl + searchResourceStockDetail;
	}

	public String getInResourceRound() {
		return inResourceRound;
	}

	public void setInResourceRound(String inResourceRound) {
		SystemParamInit.inResourceRound = unicornUrl + inResourceRound;
	}

	public String getOutResourceRound() {
		return outResourceRound;
	}

	public void setOutResourceRound(String outResourceRound) {
		SystemParamInit.outResourceRound = unicornUrl + outResourceRound;
	}

	public String getDelResourceRound() {
		return delResourceRound;
	}

	public void setDelResourceRound(String delResourceRound) {
		SystemParamInit.delResourceRound = unicornUrl + delResourceRound;
	}

	public String getSearchRelatedProduct() {
		return searchRelatedProduct;
	}

	public void setSearchRelatedProduct(String searchRelatedProduct) {
		SystemParamInit.searchRelatedProduct = ngPrdUrl + searchRelatedProduct;
	}

	public String getSearchResourceInfo() {
		return searchResourceInfo;
	}

	public void setSearchResourceInfo(String searchResourceInfo) {
		SystemParamInit.searchResourceInfo = ngResUrl + searchResourceInfo;
	}

	public String getSubmitReviewForRes() {
		return submitReviewForRes;
	}

	public void setSubmitReviewForRes(String submitReviewForRes) {
		SystemParamInit.submitReviewForRes = unicornUrl + submitReviewForRes;
	}

	public String getCancelReviewForRes() {
		return cancelReviewForRes;
	}

	public void setCancelReviewForRes(String cancelReviewForRes) {
		SystemParamInit.cancelReviewForRes = unicornUrl + cancelReviewForRes;
	}

	/**
	 * 草稿资源基本信息
	 */
	public static String resourceBasicInfo;

	public String getResourceBasicInfo() {
		return resourceBasicInfo;
	}

	public void setResourceBasicInfo(String resourceBasicInfo) {
		SystemParamInit.resourceBasicInfo = unicornUrl + resourceBasicInfo;
	}

	public String getRemoveResourceDraft() {
		return removeResourceDraft;
	}

	public void setRemoveResourceDraft(String removeResourceDraft) {
		SystemParamInit.removeResourceDraft = unicornUrl + removeResourceDraft;
	}

	public String getQueryReturnView() {
		return queryReturnView;
	}

	public void setQueryReturnView(String queryReturnView) {
		SystemParamInit.queryReturnView = unicornUrl + queryReturnView;
	}

	public String getCountResourceList() {
		return countResourceList;
	}

	public void setCountResourceList(String countResourceList) {
		SystemParamInit.countResourceList = unicornUrl + countResourceList;
	}

	/**
	 * 指定资源之库存批次审核内容列表
	 */
	public static String resourceRoundListUnderReview;

	/**
	 * 资源收藏夹
	 */
	public static String topFavorites;
	public static String getAllResource;
	public static String addFavorites;
	public static String getFavoritesList;
	public static String removeFavorites;
	public static String addDraft;
	public static String getFavoritesHotelBasicInfo;
	
	public String getGetFavoritesHotelBasicInfo() {
		return getFavoritesHotelBasicInfo;
	}

	public void setGetFavoritesHotelBasicInfo(
			String getFavoritesHotelBasicInfo) {
		SystemParamInit.getFavoritesHotelBasicInfo = unicornUrl+getFavoritesHotelBasicInfo;
	}

	public String getTopFavorites() {
		return topFavorites;
	}

	public void setTopFavorites(String topFavorites) {
		SystemParamInit.topFavorites = unicornUrl + topFavorites;
	}

	public String getGetAllResource() {
		return getAllResource;
	}

	public void setGetAllResource(String getAllResource) {
		SystemParamInit.getAllResource = unicornUrl + getAllResource;
		//SystemParamInit.getAllResource = "http://172.30.24.115:8080/unicorn/" + getAllResource;
	}

	public String getAddFavorites() {
		return addFavorites;
	}

	public void setAddFavorites(String addFavorites) {
		SystemParamInit.addFavorites = unicornUrl + addFavorites;
	}

	public String getGetFavoritesList() {
		return getFavoritesList;
	}

	public void setGetFavoritesList(String getFavoritesList) {
		SystemParamInit.getFavoritesList = unicornUrl + getFavoritesList;
	}

	public String getRemoveFavorites() {
		return removeFavorites;
	}

	public void setRemoveFavorites(String removeFavorites) {
		SystemParamInit.removeFavorites = unicornUrl + removeFavorites;
	}

	public String getAddDraft() {
		return addDraft;
	}

	public void setAddDraft(String addDraft) {
		SystemParamInit.addDraft = unicornUrl + addDraft;
	}

	public String getResourceRoundListUnderReview() {
		return resourceRoundListUnderReview;
	}

	public void setResourceRoundListUnderReview(String resourceRoundListUnderReview) {
		SystemParamInit.resourceRoundListUnderReview = unicornUrl + resourceRoundListUnderReview;
	}

	/**
	 * 特别条款信息
	 */
	public String getSearchSpecialAgreement() {
		return searchSpecialAgreement;
	}

	public void setSearchSpecialAgreement(String searchSpecialAgreement) {
		SystemParamInit.searchSpecialAgreement = unicornUrl + searchSpecialAgreement;
	}

	public String getUpdateSpecialAgreement() {
		return updateSpecialAgreement;
	}

	public void setUpdateSpecialAgreement(String updateSpecialAgreement) {
		SystemParamInit.updateSpecialAgreement = unicornUrl + updateSpecialAgreement;
	}

	public String getAddResourceDraft() {
		return addResourceDraft;
	}

	public void setAddResourceDraft(String addResourceDraft) {
		SystemParamInit.addResourceDraft = unicornUrl + addResourceDraft;
	}

	public String getSearchResourceActionLog() {
		return searchResourceActionLog;
	}

	public void setSearchResourceActionLog(String searchResourceActionLog) {
		SystemParamInit.searchResourceActionLog = unicornUrl + searchResourceActionLog;
	}

	public String getSearchBeginCityName() {
		return searchBeginCityName;
	}

	public void setSearchBeginCityName(String searchBeginCityName) {
		SystemParamInit.searchBeginCityName = crmUrl + searchBeginCityName;
	}

	public String getSearchResourceConfirmation() {
		return searchResourceConfirmation;
	}

	public void setSearchResourceConfirmation(String searchResourceConfirmation) {
		SystemParamInit.searchResourceConfirmation = ngResConfirmUrl + searchResourceConfirmation;
	}

	public String getSearchResourceConfirmationDetail() {
		return searchResourceConfirmationDetail;
	}

	public void setSearchResourceConfirmationDetail(String searchResourceConfirmationDetail) {
		SystemParamInit.searchResourceConfirmationDetail = ngResConfirmUrl + searchResourceConfirmationDetail;
	}

	public String getFeedbackResourceConfirmation() {
		return feedbackResourceConfirmation;
	}

	public void setFeedbackResourceConfirmation(String feedbackResourceConfirmation) {
		SystemParamInit.feedbackResourceConfirmation = ngResConfirmUrl + feedbackResourceConfirmation;
		//SystemParamInit.feedbackResourceConfirmation = "http://172.30.21.32:8080/" + feedbackResourceConfirmation;
	}

	/**
	 * @return the totalStoreUrl
	 */
	public String getTotalStoreUrl() {
		return totalStoreUrl;
	}

	/**
	 * @param totalStoreUrl
	 *            the totalStoreUrl to set
	 */
	public void setTotalStoreUrl(String totalStoreUrl) {
		SystemParamInit.totalStoreUrl = totalStoreUrl;
	}

	/**
	 * @return the detailStoreUrl
	 */
	public String getDetailStoreUrl() {
		return detailStoreUrl;
	}

	/**
	 * @param detailStoreUrl
	 *            the detailStoreUrl to set
	 */
	public void setDetailStoreUrl(String detailStoreUrl) {
		SystemParamInit.detailStoreUrl = detailStoreUrl;
	}

	/**
	 * @return the hotelNameUrl
	 */
	public String getHotelNameUrl() {
		return hotelNameUrl;
	}

	/**
	 * @param hotelNameUrl
	 *            the hotelNameUrl to set
	 */
	public void setHotelNameUrl(String hotelNameUrl) {
		SystemParamInit.hotelNameUrl = hotelNameUrl;
	}

	/**
	 * @return the dispatchingUrl
	 */
	public String getDispatchingUrl() {
		return dispatchingUrl;
	}

	/**
	 * @param dispatchingUrl the dispatchingUrl to set
	 */
	public void setDispatchingUrl(String dispatchingUrl) {
		SystemParamInit.dispatchingUrl = dispatchingUrl;
	}


	public String getOaApi() {
		return oaApi;
	}

	public void setOaApi(String oaApi) {
		SystemParamInit.oaApi = oaApi;
	}

	public String getStopRetail() {
		return stopRetail;
	}

	public void setStopRetail(String stopRetail) {
		SystemParamInit.stopRetail = crmUrl + stopRetail;
	}

	public String getSignList() {
		return signList;
	}

	public void setSignList(String signList) {
		SystemParamInit.signList = crmUrl + signList;
	}

	public String getSignListCount() {
		return signListCount;
	}

	public void setSignListCount(String signListCount) {
		SystemParamInit.signListCount = crmUrl + signListCount;
	}

	public String getSignDetail() {
		return signDetail;
	}

	public void setSignDetail(String signDetail) {
		SystemParamInit.signDetail = crmUrl + signDetail;
	}

	public String getAddAmt() {
		return addAmt;
	}

	public void setAddAmt(String addAmt) {
		SystemParamInit.addAmt = crmUrl + addAmt;
	}

	public String getNoAmt() {
		return noAmt;
	}

	public void setNoAmt(String noAmt) {
		SystemParamInit.noAmt = crmUrl + noAmt;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		SystemParamInit.contract = crmUrl + contract;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		SystemParamInit.sign = crmUrl + sign;
	}

	public String getCancelSign() {
		return cancelSign;
	}

	public void setCancelSign(String cancelSign) {
		SystemParamInit.cancelSign = crmUrl + cancelSign;
	}

	public String getDelContract() {
		return delContract;
	}

	public void setDelContract(String delContract) {
		SystemParamInit.delContract = crmUrl + delContract;
	}
	
    public static String vendorContract;

    public String getVendorContract() {
        return vendorContract;
    }

    public  void setVendorContract(String vendorContract) {
        SystemParamInit.vendorContract = crmUrl + vendorContract;
    }
	//产品多行程查询url
	public static String queryMutiRouteUrl;
	//产品多行程更新url
	public static String updateMutiRouteUrl;
	//
	public static String mutiRouteFlags;

	public  String getQueryMutiRouteUrl() {
		return queryMutiRouteUrl;
	}

	public  void setQueryMutiRouteUrl(String queryMutiRouteUrl) {
		SystemParamInit.queryMutiRouteUrl = unicornUrl + queryMutiRouteUrl;
	}

	public  String getUpdateMutiRouteUrl() {
		return updateMutiRouteUrl;
	}

	public  void setUpdateMutiRouteUrl(String updateMutiRouteUrl) {
		SystemParamInit.updateMutiRouteUrl = unicornUrl + updateMutiRouteUrl;
	}

	public  String getMutiRouteFlags() {
		return mutiRouteFlags;
	}

	public  void setMutiRouteFlags(String mutiRouteFlags) {
		SystemParamInit.mutiRouteFlags =unicornUrl +  mutiRouteFlags;
	}

	public String getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(String sendMessage) {
		SystemParamInit.sendMessage = sendMessage;
	}

	public Integer getSmsTaskId() {
		return smsTaskId;
	}

	public void setSmsTaskId(Integer smsTaskId) {
		SystemParamInit.smsTaskId = smsTaskId;
	}

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		SystemParamInit.opId = opId;
	}

    public static String getTabStatusUrl() {
        return tabStatusUrl;
    }

    public void setTabStatusUrl(String tabStatusUrl) {
        SystemParamInit.tabStatusUrl = unicornUrl + tabStatusUrl;
    }

	
	/* 账户变更接口URL */
	public static String agencyAccount;
	public static String agencyUser;
	public static String agencyList;
	public static String agencyDetail;
	public static String agencyAccountList;
	public static String agencyContactList;
	public static String agencyFile;

	public String getAgencyAccount() {
		return agencyAccount;
	}

	public void setAgencyAccount(String agencyAccount) {
		SystemParamInit.agencyAccount = crmUrl + agencyAccount;
	}

	public String getAgencyUser() {
		return agencyUser;
	}

	public void setAgencyUser(String agencyUser) {
		SystemParamInit.agencyUser = crmUrl + agencyUser;
	}

	public String getAgencyList() {
		return agencyList;
	}

	public void setAgencyList(String agencyList) {
		SystemParamInit.agencyList = crmUrl + agencyList;
	}

	public String getAgencyDetail() {
		return agencyDetail;
	}

	public void setAgencyDetail(String agencyDetail) {
		SystemParamInit.agencyDetail = crmUrl + agencyDetail;
	}

	public String getAgencyAccountList() {
		return agencyAccountList;
	}

	public void setAgencyAccountList(String agencyAccountList) {
		SystemParamInit.agencyAccountList = crmUrl + agencyAccountList;
	}
	
	public String getAgencyContactList() {
		return agencyContactList;
	}

	public void setAgencyContactList(String agencyContactList) {
		SystemParamInit.agencyContactList = crmUrl + agencyContactList;
	}

	public String getAgencyFile() {
		return agencyFile;
	}

	public void setAgencyFile(String agencyFile) {
		SystemParamInit.agencyFile = crmUrl + agencyFile;
	}

	
	/*对账单，采购单，申请提前预付 URL*/
	
	//获取对账单列表
	public static String checkAccountList;
	
	//获取对账单明细
	public static String checkAccountDetail;
	
	// 获取采购单列表
	public static String purchaseOrderList;
	
	//采购单明显确认
	public static String purchaseOrderDetail;
	
	// 申请提前付款
	public static String applyPayAdvance;
	
	// 计算提前付款收益
	public static String calculatePayAdvance;

	public String getCheckAccountList() {
		return checkAccountList;
	}

	public void setCheckAccountList(String checkAccountList) {
		SystemParamInit.checkAccountList = fmisUrl+checkAccountList;
	}

	public String getCheckAccountDetail() {
		return checkAccountDetail;
	}

	public void setCheckAccountDetail(String checkAccountDetail) {
		SystemParamInit.checkAccountDetail = fmisUrl+checkAccountDetail;
	}

	public String getPurchaseOrderList() {
		return purchaseOrderList;
	}

	public void setPurchaseOrderList(String purchaseOrderList) {
		SystemParamInit.purchaseOrderList = fmisUrl+purchaseOrderList;
	}

	public String getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(String purchaseOrderDetail) {
		SystemParamInit.purchaseOrderDetail = fmisUrl+purchaseOrderDetail;
	}

	public String getApplyPayAdvance() {
		return applyPayAdvance;
	}

	public void setApplyPayAdvance(String applyPayAdvance) {
		SystemParamInit.applyPayAdvance = fmisUrl+applyPayAdvance;
	}

	public String getCalculatePayAdvance() {
		return calculatePayAdvance;
	}

	public void setCalculatePayAdvance(String calculatePayAdvance) {
		SystemParamInit.calculatePayAdvance = fmisUrl+calculatePayAdvance;
	}
	

	

	
	/* 财务结算接口URL */
	
	//获取赔款单列表
	public static String agencyIndemnityList;
	
	// 赔款单明细确认
	public static String addAgencyIndemnityInfo;
	
	// 预付款列表
	public static String agencyAdvanceList;
	
	// 预付款单明细确认
	public static String addAgencyAdvanceInfo;
	
	// 应开发票列表
	public static String agencyBillList;
	
	// 实际发票列表
	public static String agencyRelBillList;
	
	// 实开发票确认
	public static String addAgencyBillInfo;
	
	// 付款单列表
	public static String agencyPayList;
	
	// 查询系统对账条数
	public static String billConfirmInfo;
	
	//发票是否可编辑
	public static String isInvoiceEdit;
	
	//已出账单-下载明细
	public static String purchaseOrderUrl;
	
	// 外币种类查询
	public static String foreignCurrency;
	
	// 零售平台 账单确认
	public static String sellBillConfirm;
	
	//财务结算一键确认
	public static String oneClickConfirm;

	public static String getOneClickConfirm() {
		return oneClickConfirm;
	}

	public void setOneClickConfirm(String oneClickConfirm) {
		SystemParamInit.oneClickConfirm = fmisUrl + oneClickConfirm;
	}

	public static String getSellBillConfirm() {
		return sellBillConfirm;
	}

	public void setSellBillConfirm(String sellBillConfirm) {
		SystemParamInit.sellBillConfirm = fmisUrl + sellBillConfirm;
	}

	public static String getForeignCurrency() {
		return foreignCurrency;
	}

	public void setForeignCurrency(String foreignCurrency) {
		SystemParamInit.foreignCurrency = fmisUrl + foreignCurrency;
	}

	public static String getPurchaseOrderUrl() {
		return purchaseOrderUrl;
	}

	public void setPurchaseOrderUrl(String purchaseOrderUrl) {
		SystemParamInit.purchaseOrderUrl = fmisUrl + purchaseOrderUrl;
	}

	public static String getIsInvoiceEdit() {
		return isInvoiceEdit;
	}

	public void setIsInvoiceEdit(String isInvoiceEdit) {
		SystemParamInit.isInvoiceEdit = fmisUrl + isInvoiceEdit;
	}

	public String getFmisUrl() {
		return fmisUrl;
	}

	public void setFmisUrl(String fmisUrl) {
		SystemParamInit.fmisUrl = fmisUrl;
	}

	public String getAgencyIndemnityList() {
		return agencyIndemnityList;
	}

	public void setAgencyIndemnityList(String agencyIndemnityList) {
		SystemParamInit.agencyIndemnityList = fmisUrl + agencyIndemnityList;
	}

	public String getAddAgencyIndemnityInfo() {
		return addAgencyIndemnityInfo;
	}

	public void setAddAgencyIndemnityInfo(String addAgencyIndemnityInfo) {
		SystemParamInit.addAgencyIndemnityInfo = fmisUrl + addAgencyIndemnityInfo;
	}

	public String getAgencyAdvanceList() {
		return agencyAdvanceList;
	}

	public void setAgencyAdvanceList(String agencyAdvanceList) {
		SystemParamInit.agencyAdvanceList = fmisUrl + agencyAdvanceList;
	}

	public String getAddAgencyAdvanceInfo() {
		return addAgencyAdvanceInfo;
	}

	public void setAddAgencyAdvanceInfo(String addAgencyAdvanceInfo) {
		SystemParamInit.addAgencyAdvanceInfo = fmisUrl + addAgencyAdvanceInfo;
	}

	public String getAgencyBillList() {
		return agencyBillList;
	}

	public void setAgencyBillList(String agencyBillList) {
		SystemParamInit.agencyBillList = fmisUrl + agencyBillList;
	}

	public String getAgencyRelBillList() {
		return agencyRelBillList;
	}

	public void setAgencyRelBillList(String agencyRelBillList) {
		SystemParamInit.agencyRelBillList = fmisUrl + agencyRelBillList;
	}

	public String getAddAgencyBillInfo() {
		return addAgencyBillInfo;
	}

	public void setAddAgencyBillInfo(String addAgencyBillInfo) {
		SystemParamInit.addAgencyBillInfo = fmisUrl + addAgencyBillInfo;
	}

	public String getAgencyPayList() {
		return agencyPayList;
	}

	public void setAgencyPayList(String agencyPayList) {
		SystemParamInit.agencyPayList = fmisUrl + agencyPayList;
	}

	public String getBillConfirmInfo() {
		return billConfirmInfo;
	}

	public void setBillConfirmInfo(String billConfirmInfo) {
		SystemParamInit.billConfirmInfo = fmisUrl + billConfirmInfo;
	}

	
	
	/*财务结算之异常单处理 */
	
	//发起异常
	public static String launchAbnormal;
	
	//添加异常信息
	public static String addAbnormal;
	
	//异常已读更新
	public static String readUpdate;
	
	//结束异常单
	public static String finishAbnormal;
	
	//获取异常单列表
	public static String getAbnormalList;
	
	//获取异常单明细
	public static String getAbnormalDetail;

	public static String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		SystemParamInit.accountType = fmisUrl + accountType;
	}

	public static String getLaunchAbnormal() {
		return launchAbnormal;
	}

	public void setLaunchAbnormal(String launchAbnormal) {
		SystemParamInit.launchAbnormal = fmisUrl + launchAbnormal;
	}

	public static String getAddAbnormal() {
		return addAbnormal;
	}

	public void setAddAbnormal(String addAbnormal) {
		SystemParamInit.addAbnormal = fmisUrl + addAbnormal;
	}

	public static String getReadUpdate() {
		return readUpdate;
	}

	public void setReadUpdate(String readUpdate) {
		SystemParamInit.readUpdate = fmisUrl + readUpdate;
	}
	
	public static String getFinishAbnormal() {
		return finishAbnormal;
	}

	public void setFinishAbnormal(String finishAbnormal) {
		SystemParamInit.finishAbnormal = fmisUrl + finishAbnormal;
	}

	public static String getGetAbnormalList() {
		return getAbnormalList;
	}

	public void setGetAbnormalList(String getAbnormalList) {
		SystemParamInit.getAbnormalList = fmisUrl + getAbnormalList;
	}

	public static String getGetAbnormalDetail() {
		return getAbnormalDetail;
	}

	public void setGetAbnormalDetail(String getAbnormalDetail) {
		SystemParamInit.getAbnormalDetail = fmisUrl + getAbnormalDetail;
	}
	

	
	//校验团购券是否可用
	public static String hotelVerifyCheck;
	//客人确认使用后，提交使用渠道，以及入、离店日期信息
	public static String hotelVerifyConfirm;
	//查询销售统计报表
	public static String getSalesList;
	//根据条件查询团购券使用明细
	public static String searchVerifiesList;
	

	public String getHotelVerifyUrl() {
		return hotelVerifyUrl;
	}

	public void setHotelVerifyUrl(String hotelVerifyUrl) {
		SystemParamInit.hotelVerifyUrl = hotelVerifyUrl;
	}

	public String getHotelVerifyCheck() {
		return hotelVerifyCheck;
	}

	public void setHotelVerifyCheck(String hotelVerifyCheck) {
		SystemParamInit.hotelVerifyCheck = hotelVerifyUrl + hotelVerifyCheck;
	}

	public String getHotelVerifyConfirm() {
		return hotelVerifyConfirm;
	}

	public void setHotelVerifyConfirm(String hotelVerifyConfirm) {
		SystemParamInit.hotelVerifyConfirm = hotelVerifyUrl + hotelVerifyConfirm;
	}

	public String getGetSalesList() {
		return getSalesList;
	}

	public void setGetSalesList(String getSalesList) {
		SystemParamInit.getSalesList = hotelVerifyUrl + getSalesList;
	}

	public String getSearchVerifiesList() {
		return searchVerifiesList;
	}

	public void setSearchVerifiesList(String searchVerifiesList) {
		SystemParamInit.searchVerifiesList = hotelVerifyUrl + searchVerifiesList;
	}

	public Integer getAgencyHierarchy() {
		return agencyHierarchy;
	}

	public void setAgencyHierarchy(Integer agencyHierarchy) {
		SystemParamInit.agencyHierarchy = agencyHierarchy;
	}
	
	//自助游资源确认 - 查询游轮详细信息
	public static String searchResourceQueryByResId;

	public String getSearchResourceQueryByResId() {
		return searchResourceQueryByResId;
	}

	public void setSearchResourceQueryByResId(String searchResourceQueryByResId) {
		SystemParamInit.searchResourceQueryByResId = ngResUrl+searchResourceQueryByResId;
	}
	
}
