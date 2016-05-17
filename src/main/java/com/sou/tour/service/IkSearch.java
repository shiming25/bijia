package com.sou.tour.service;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.sou.tour.domain.vo.TourInfoPageVo;
import com.sou.tour.domain.vo.TourInfoVo;

public class IkSearch {

	private static Directory dir = null;

	// public static final String IDNEX_PATH = "/searchDataMid/mipang";
	// public static final String IDNEX_PATH = "/searchDataMid/uzai";
	//public static  String IDNEX_PATH = "/searchDataMid/lvmama";
//	public static  String IDNEX_PATH = "/searchDataMid/qyer";
	//public static String IDNEX_PATH = "/searchDataMid/mafengwo";
	//public static String IDNEX_PATH = "/searchDataMid/hwzl8264";
//	public static String IDNEX_PATH = "/searchDataMid/dreams";
	public static String IDNEX_PATH = "/searchData";

	private static Analyzer analyzer = null;

	private static DirectoryReader reader;

	public static final int PAGE_SIZE = 8;

	static {
		try {
			dir = FSDirectory.open(new File(IDNEX_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void changeDir() {
		try {
			dir = FSDirectory.open(new File(IDNEX_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IndexSearcher getSearcher() {
		try {
			if (reader == null) {
				reader = DirectoryReader.open(dir);
			} else {
				DirectoryReader tr = DirectoryReader.openIfChanged(reader);
				if (tr != null) {
					reader.close();
					reader = tr;
				}
			}
			return new IndexSearcher(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TourInfoPageVo searchTop10(String queryString) {
		// String IDNEX_PATH = "/searchData";

		// Directory dir;
		// String queryString = "test"; // 查询条件
		String query_fields[] = new String[] { "title", "content", "departyCity", "destCity" };// 对哪几个字段进行查询检索
		TourInfoPageVo tourInfoPageVo = new TourInfoPageVo();
		List<TourInfoVo> retList = new ArrayList<TourInfoVo>();
		try {
			// dir = FSDirectory.open(new File(IDNEX_PATH));

			// IndexReader reader = DirectoryReader.open(dir);
			// IndexSearcher searcher = new IndexSearcher(reader);

			IndexSearcher searcher = getSearcher();

			// Analyzer analyzer1 = new StandardAnalyzer(Version.LUCENE_4_9);

			// // 获取Paoding中文分词器
			//
			// Analyzer analyzer = new IKAnalyzer();
			// String field = "title";
			// QueryParser parser = new QueryParser(Version.LUCENE_4_9, field,
			// analyzer);

			QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_4_9, query_fields, analyzer);

			parser.setDefaultOperator(QueryParser.OR_OPERATOR);// 多个关键字时采取 or 操作

			Query query = parser.parse(queryString);
			// System.out.println("Query = " + query);

			TopDocs topDocs = searcher.search(query, PAGE_SIZE);
			System.out.println("命中：" + topDocs.totalHits);
			tourInfoPageVo.setTotalCou(topDocs.totalHits);
			// 输出结果
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;

			// 关键字高亮显示的html标签，需要导入lucene-highlighter-x.x.x.jar
			SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
			Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));

			TourInfoVo tourInfoVo = null;
			String titleTemp = "";
			for (int i = 0; i < scoreDocs.length; i++) {

				Document targetDoc = searcher.doc(scoreDocs[i].doc);
				titleTemp = targetDoc.get("title");
				// System.out.println("内容title：" + titleTemp);

				// 内容增加高亮显示
				TokenStream tokenStream2 = analyzer.tokenStream("title", new StringReader(titleTemp));
				String title = highlighter.getBestFragment(tokenStream2, titleTemp);
				if (null == title) {
					title = titleTemp;
				}
				// System.out.println("文件名称:" + targetDoc.get("title") +
				// " 高亮内容:"
				// + title);
				tourInfoVo = new TourInfoVo();
				tourInfoVo.setTitle(title);
				// tourInfoVo.setContent(targetDoc.get("content"));
				tourInfoVo.setOrgUrl(targetDoc.get("orgUrl"));
				tourInfoVo.setDepartyCity(targetDoc.get("departyCity"));
				tourInfoVo.setDestCity(targetDoc.get("destCity"));
				tourInfoVo.setPrice(targetDoc.get("price"));
				tourInfoVo.setOrgPrice(targetDoc.get("orgPrice"));
				tourInfoVo.setEndDate(targetDoc.get("endDate"));
				tourInfoVo.setBusinessType(targetDoc.get("businessType"));

				//tourInfoVo.setIssue(getIssueStr(targetDoc.get("issue"), targetDoc.get("content")));
				tourInfoVo.setPicUrl(targetDoc.get("picUrl"));
				tourInfoVo.setCouPeople(targetDoc.get("peopleCou"));
				tourInfoVo.setCouReview(targetDoc.get("peopleCommentary"));
				tourInfoVo.setUpdateTime(targetDoc.get("updateTime"));
				tourInfoVo.setHostName(targetDoc.get("hostName"));
				retList.add(tourInfoVo);
			}
			tourInfoPageVo.setTourInfoVoList(retList);
			return tourInfoPageVo;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTokenOffsetsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tourInfoPageVo;

	}

	public TourInfoPageVo searchPage(TourInfoVo tourInfoVoParam) {
		System.out.println(tourInfoVoParam.toString());

		TourInfoPageVo tourInfoPageVo = new TourInfoPageVo();
		List<TourInfoVo> retList = new ArrayList<TourInfoVo>();
		try {
			//
			// IndexReader reader = DirectoryReader.open(dir);
			// IndexSearcher searcher = new IndexSearcher(reader);

			IndexSearcher searcher = getSearcher();

			// 查询条件
			BooleanQuery query = getQuery(tourInfoVoParam);

			// ScoreDoc lastDoc = new ScoreDoc(2,0.015481366f,-1);
			ScoreDoc lastDoc = null;
			if (tourInfoVoParam.getPageIndex() > 1) {
				TopDocs topDocs2 = searcher.search(query, (tourInfoVoParam.pageIndex - 1) * PAGE_SIZE);
				ScoreDoc[] scoreDocs2 = topDocs2.scoreDocs;
				lastDoc = scoreDocs2[(tourInfoVoParam.pageIndex - 1) * PAGE_SIZE - 1];
				// lastDoc = new
				// ScoreDoc(tourInfoVoParam.getDoc(),tourInfoVoParam.getScore(),tourInfoVoParam.getShardIndex());
			}
			// TopDocs topDocs = searcher.search(query, 10);

			TopDocs topDocs = searcher.searchAfter(lastDoc, query, PAGE_SIZE);

			// System.out.println("命中：" + topDocs.totalHits);
			tourInfoPageVo.setTotalCou(topDocs.totalHits);
			// 输出结果
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;

			// 关键字高亮显示的html标签，需要导入lucene-highlighter-x.x.x.jar
			BooleanQuery hightQuery = getHeightQuery(tourInfoVoParam);
			SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
			Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(hightQuery));

			TourInfoVo tourInfoVo = null;
			String titleTemp = "";
			String routePoiTemp = "";
			String issueTemp = "";
			for (int i = 0; i < scoreDocs.length; i++) {
//				System.out.println("ttt:"+i);
				Document targetDoc = searcher.doc(scoreDocs[i].doc);
				titleTemp = targetDoc.get("title");
				routePoiTemp = targetDoc.get("routePoi");
				issueTemp =  targetDoc.get("issue");
				// System.out.println("内容title：" + titleTemp);

				// 内容增加高亮显示
				TokenStream tokenStream2 = analyzer.tokenStream("title", new StringReader(titleTemp));
				String title = highlighter.getBestFragment(tokenStream2, titleTemp);
				if (null == title) {
					title = titleTemp;
				}

				if (routePoiTemp == null) {
					routePoiTemp = "";
				}
				tokenStream2 = analyzer.tokenStream("routePoi", new StringReader(routePoiTemp));
				String routePoi = highlighter.getBestFragment(tokenStream2, routePoiTemp);
				if (null == routePoi) {
					routePoi = routePoiTemp;
				}
				if (issueTemp == null) {
					issueTemp = "";
				}
				tokenStream2 = analyzer.tokenStream("issue", new StringReader(issueTemp));
				String issue = highlighter.getBestFragment(tokenStream2, issueTemp);
				if (null == issue) {
					issue = issueTemp;
				}
				// System.out.println("文件名称:" + targetDoc.get("title") +
				// " 高亮内容:"
				// + title);
				tourInfoVo = new TourInfoVo();
				tourInfoVo.setTitle(title);
				// tourInfoVo.setContent(targetDoc.get("content"));
				tourInfoVo.setOrgUrl(targetDoc.get("orgUrl"));
				tourInfoVo.setDepartyCity(targetDoc.get("departyCity"));
				tourInfoVo.setDestCity(targetDoc.get("destCity"));
				tourInfoVo.setPrice(formatPrice(targetDoc.get("price")));
				tourInfoVo.setOrgPrice(targetDoc.get("orgPrice"));
				tourInfoVo.setEndDate(targetDoc.get("endDate"));
				tourInfoVo.setBusinessType(targetDoc.get("businessType"));

				tourInfoVo.setIssue(getIssueStr(issue));
				tourInfoVo.setPicUrl(targetDoc.get("picUrl"));
				tourInfoVo.setCouPeople(targetDoc.get("peopleCou"));
				tourInfoVo.setCouReview(targetDoc.get("peopleCommentary"));
				tourInfoVo.setUpdateTime(targetDoc.get("updateTime"));
				tourInfoVo.setPriceType(targetDoc.get("priceType"));
				tourInfoVo.setHostName(targetDoc.get("hostName"));
				tourInfoVo.setRouteDay(targetDoc.get("routeDay"));
				tourInfoVo.setRoutePoi(routePoi);
				tourInfoVo.setGoodCou(targetDoc.get("goodCou"));
				tourInfoVo.setBadCou(targetDoc.get("badCou"));

				if (i == scoreDocs.length - 1) {
					tourInfoPageVo.setDoc(scoreDocs[i].doc);
					tourInfoPageVo.setScore(scoreDocs[i].score);
					tourInfoPageVo.setShardIndex(scoreDocs[i].shardIndex);
				}

				retList.add(tourInfoVo);
			}
			tourInfoPageVo.setTourInfoVoList(retList);
			return tourInfoPageVo;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTokenOffsetsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tourInfoPageVo;

	}

	private String formatPrice(String price) {
		if(null == price) {
			return "";
		}
		return price.replaceAll("起", "");
	}

	private BooleanQuery getQuery(TourInfoVo tourInfoVoParam) throws ParseException {
		// String queryString = "test"; // 查询条件
		String query_fields[] = new String[] { "title", "content", "issue","routePoi" };// 对哪几个字段进行查询检索
		String query_depart_fields[] = new String[] { "departyCity" };// 对哪几个字段进行查询检索
		String query_dest_fields[] = new String[] { "destCity" };// 对哪几个字段进行查询检索
		String query_type_fields[] = new String[] { "businessType" };// 对哪几个字段进行查询检索

		Map<String, Float> boosts = new HashMap<String, Float>();

		boosts.put("title", 20.0f);
		boosts.put("routePoi", 10.0f);
		boosts.put("issue", 0.5f);
		boosts.put("content", 0.1f);

		QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_4_9, query_fields, analyzer, boosts);

		parser.setDefaultOperator(QueryParser.OR_OPERATOR);// 多个关键字时采取 or 操作

		Query queryTitle = parser.parse(tourInfoVoParam.getTitle());

		BooleanQuery query = new BooleanQuery();

		query.add(queryTitle, BooleanClause.Occur.MUST);
		if (tourInfoVoParam.getDepartyCity() != null && !tourInfoVoParam.getDepartyCity().equals("")) {
			QueryParser parserDepatCity = new MultiFieldQueryParser(Version.LUCENE_4_9, query_depart_fields, analyzer,
					boosts);
			Query queryDepartCity = parserDepatCity.parse(tourInfoVoParam.getDepartyCity() + " 任意 不限 全国");

			query.add(queryDepartCity, BooleanClause.Occur.MUST);
		}
		if (tourInfoVoParam.getDestCity() != null && !tourInfoVoParam.getDestCity().equals("")) {
			QueryParser parserDestCity = new MultiFieldQueryParser(Version.LUCENE_4_9, query_dest_fields, analyzer,boosts);
			Query queryDestCity = parserDestCity.parse(tourInfoVoParam.getDestCity());
			query.add(queryDestCity, BooleanClause.Occur.MUST);
		}

		// 只支持线路
		QueryParser parserBusinessType = new MultiFieldQueryParser(Version.LUCENE_4_9, query_type_fields, analyzer,boosts);
		Query businessType = parserBusinessType.parse("自由行 跟团 自由 线路 中秋");
		query.add(businessType, BooleanClause.Occur.MUST);

		return query;
	}

	private BooleanQuery getHeightQuery(TourInfoVo tourInfoVoParam) throws ParseException {
		// String queryString = "test"; // 查询条件
		String query_fields[] = new String[] { "title", "content" };// 对哪几个字段进行查询检索
		String query_depart_fields[] = new String[] { "departyCity" };// 对哪几个字段进行查询检索
		String query_dest_fields[] = new String[] { "destCity" };// 对哪几个字段进行查询检索
		String query_type_fields[] = new String[] { "businessType" };// 对哪几个字段进行查询检索

		QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_4_9, query_fields, analyzer);

		parser.setDefaultOperator(QueryParser.OR_OPERATOR);// 多个关键字时采取 or 操作

		Query queryTitle = parser.parse(tourInfoVoParam.getTitle());

		BooleanQuery query = new BooleanQuery();

		query.add(queryTitle, BooleanClause.Occur.MUST);

		return query;
	}

	private String getIssueStr(String issue) {
		if (null != issue) {
			if (issue.length() > 200) {
				return issue.substring(0, 200) + "......";
			} else {
				return issue;
			}
		} else {
//			if (null != content) {
//				if (content.length() > 200) {
//					return content.substring(0, 200) + "......";
//				} else {
//					return content;
//				}
//			}
		}
		return "无";
	}

	public static void main(String args[]) {
		IkSearch iSearch = new IkSearch();
		// iSearch.searchTop10("团购");
		TourInfoVo test = new TourInfoVo();
		test.setTitle("大");
		// test.setDoc(5);
		// test.setScore(0.010924553f);
		// test.setShardIndex(-1);
		test.setPageIndex(1);
		iSearch.searchPage(test);
	}

}
