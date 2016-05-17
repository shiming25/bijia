package com.sou.tour.service.impl;



import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;

import com.sou.tour.domain.vo.TourInfoPageVo;
import com.sou.tour.domain.vo.TourInfoVo;
import com.sou.tour.service.ITourIkSearch;
import com.sou.tour.service.IkSearch;

@Service
public class TourIkSearch implements ITourIkSearch{

	/**
	 * 查询
	 */
	public TourInfoPageVo searchTop(TourInfoVo tourInfoVo) {
		IkSearch ikSearch = new IkSearch();
		
		//TourInfoPageVo tourInfoPageVo = ikSearch.searchTop10(tourInfoVo.getTitle());
		TourInfoPageVo tourInfoPageVo = ikSearch.searchPage(tourInfoVo);
		
		//List<TourInfoVo> retList = 
		return tourInfoPageVo;
	}
	public void search(TourInfoVo tourInfoVo) {
		String IDNEX_PATH = "G:/paoding_test_index";
		Directory dir;
		try {
			dir = FSDirectory.open(new File(IDNEX_PATH));
			
			IndexReader reader = DirectoryReader.open(dir);
			IndexSearcher searcher = new IndexSearcher(reader);
			
			//Analyzer analyzer1 = new StandardAnalyzer(Version.LUCENE_4_9);

//			// 获取Paoding中文分词器
//
			//Analyzer analyzer = new IKAnalyzer();
			String field = "title";
			//QueryParser parser = new QueryParser(Version.LUCENE_4_9, field, analyzer);
			QueryParser parser = null;
			Query query = parser.parse("content:北国江城");
			System.out.println("Query = " + query);
			
			TopDocs topDocs = searcher.search(query , 5);
			System.out.println("命中：" + topDocs.totalHits);
			//输出结果
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for (int i = 0; i < topDocs.totalHits; i++){
				Document targetDoc = searcher.doc(scoreDocs[i].doc);
				System.out.println("内容：" + targetDoc.toString());
			}	


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		TourIkSearch iSearch = new TourIkSearch();
		iSearch.search(null);
	}


}
