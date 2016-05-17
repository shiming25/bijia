package com.sou.tour.domain.vo;

import java.util.List;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TopDocs;

public class TourInfoPageVo {
	// 总页数
	private int totalCou;
	// 总条数
	private List<TourInfoVo> tourInfoVoList;

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

	public int getTotalCou() {
		return totalCou;
	}

	public void setTotalCou(int totalCou) {
		this.totalCou = totalCou;
	}

	public List<TourInfoVo> getTourInfoVoList() {
		return tourInfoVoList;
	}

	public void setTourInfoVoList(List<TourInfoVo> tourInfoVoList) {
		this.tourInfoVoList = tourInfoVoList;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
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
}
