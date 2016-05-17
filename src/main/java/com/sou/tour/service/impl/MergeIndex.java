package com.sou.tour.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;

import com.sou.tour.service.IkSearch;

@Service
public class MergeIndex {
	private void deleteIndex(File to, Analyzer sa) {
		IndexWriter indexWriter = null;
		Directory dir = null;

		try {
			dir = FSDirectory.open(to);
			// 建立索引
			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_4_9, sa);
			// iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// iwc.setOpenMode(OpenMode.CREATE);
			indexWriter = new IndexWriter(dir, iwc);
			indexWriter.deleteAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (indexWriter != null)
					indexWriter.close();
				if (dir != null)
					dir.close();
			} catch (Exception e) {

			}

		}
	}

	public void mergeIndex(File from, File to, Analyzer sa) {
		IndexWriter indexWriter = null;
		FSDirectory[] fsArr = null;
		Directory dir = null;
		try {
			System.out.println("正在合并索引文件到：\t "+to.getAbsolutePath());
			// Analyzer analyzer = new IKAnalyzer();
			dir = FSDirectory.open(to);
			// 建立索引
			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_4_9, sa);
			iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// iwc.setOpenMode(OpenMode.CREATE);
			indexWriter = new IndexWriter(dir, iwc);

			// indexWriter = new IndexWriter(to, sa, false);
			// indexWriter.setMergeFactor(100000);
			// indexWriter.setMaxFieldLength(Integer.MAX_VALUE);
			// indexWriter.setMaxBufferedDocs(Integer.MAX_VALUE);
			// indexWriter.setMaxMergeDocs(Integer.MAX_VALUE);

			FSDirectory[] fs = { FSDirectory.open(from) };
			fsArr = fs;
			indexWriter.addIndexes(fs);

			// indexWriter.optimize();

			System.out.println("已完成合并!\t ");
		} catch (Exception e) {
			System.out.println("合并索引出错！");
			e.printStackTrace();
		} finally {
			try {
				if (indexWriter != null)
					indexWriter.close();
				if (fsArr != null)
					fsArr[0].close();
				if (dir != null)
					dir.close();
			} catch (Exception e) {

			}

		}

	}

	private void mergeDicIndex(String filepath,String toPath) {
		File file = new File(filepath);
		if (file.isDirectory()) {
			String[] filelist = file.list();
			File toFile = new File(toPath);
			for (int i = 0; i < filelist.length; i++) {
				File readfile = new File(filepath + "/" + filelist[i]);
				if (readfile.isDirectory()) {
					System.out.println("正合并第"+i+"个文件。");
					//mergeIndex(readfile, toFile, new IKAnalyzer());
				}
			}
		}
	}

	public String mergeAllIndex() {
		String indexPath = "/searchData";
		
		if(IkSearch.IDNEX_PATH.equals("/searchData")) {
			indexPath = "/searchData2";
		}  else {
			indexPath = "/searchData";
		}
		File toFile = new File(indexPath);
		//deleteIndex(toFile,new IKAnalyzer());
		mergeDicIndex("/searchDataMid",indexPath);
		
		
		IkSearch.IDNEX_PATH = indexPath;
		IkSearch.changeDir();
		
		return "true";
	}

	public static void main(String[] areg) {
		// File from = new File("F:/web/faq/lucene/indexDir");
		// File to = new File("F:/indexDir");
		// mergeIndex(from, to, new IKAnalyzer());
		MergeIndex mergeIndex = new MergeIndex();
		File toFile = new File("/searchData");

		//mergeIndex.deleteIndex(toFile, new IKAnalyzer());
		mergeIndex.mergeAllIndex();
	}
}
