package com.nanobi.lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class BucketDimLucene {
	
	FSDirectory index;
	StandardAnalyzer analyzer;
	
	BucketDimLucene() throws IOException{
		index = FSDirectory.open(Paths.get("/home/nanobi/Drill/bucketdim.lucene"));
		analyzer = new StandardAnalyzer();
	}
	
    public static void main(String[] args) throws IOException, ParseException {
    	BucketDimLucene l = new BucketDimLucene();
    	l.addToDictionary("age_a");
    	System.out.println(l.search("age"));
    	System.out.println(l.getAll());
    }
    
	public void addToDictionary(String columName) {
		IndexWriter w =null;
		try {
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			w = new IndexWriter(index, config);
			addDoc(w, columName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (w != null)
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

    private static void addDoc(IndexWriter w, String text) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("bucket_dim", text, Field.Store.YES));
        w.addDocument(doc);
    }
    
    public JSONArray search(String text){
		IndexReader reader = null;
		JSONArray response = null;
		try {
			response = new JSONArray();
			Query q = new QueryParser("bucket_dim", analyzer).parse(text);
			int hitsPerPage = 10;
			reader = DirectoryReader.open(index);
			IndexSearcher searcher = new IndexSearcher(reader);
			TopDocs docs = searcher.search(q, hitsPerPage);
			ScoreDoc[] hits = docs.scoreDocs;
			
			for (int i = 0; i < hits.length; ++i) {
				JSONObject search = new JSONObject();
				int docId = hits[i].doc;
				Document d = searcher.doc(docId);
				search.put("possition", i+1);
				search.put("bucket_dim", d.get("bucket_dim"));
				response.add(search);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return response;
	}
    
    public JSONArray getAll(){
		IndexReader reader = null;
		JSONArray response = null;
		try {
			response = new JSONArray();
			int hitsPerPage = 10;
			reader = DirectoryReader.open(index);
			
			for (int i=0; i<reader.maxDoc(); i++) {
			   
			    Document doc = reader.document(i);
			    JSONObject search = new JSONObject();
			    search.put("possition", i+1);
				search.put("bucket_dim", doc.get("bucket_dim"));
				response.add(search);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return response;
	}
}