package com.prasu.lucene;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class Lucene {
    /*
    *   This code fetches a plain text file line by line, and indexes the same using Apache Lucene.
    *
    */
	
    static IndexSearcher searcher;
    static IndexReader rdr;
	
    public static void main(String[] args) {
        try{
           // System.out.println("enter the text to search for in file...");
           // BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            String word = "my";
            System.out.println("Starting to look for word: "+ word);
          //  bfr.close();
            
            Lucene obj = new Lucene();
            StandardAnalyzer analyzer = new StandardAnalyzer();
            Directory dir = new RAMDirectory();
            IndexWriterConfig writeconfig = new IndexWriterConfig(analyzer);
            IndexWriter writer = new IndexWriter(dir, writeconfig);
            FileInputStream fis = new FileInputStream("/home/nanobi/Drill/BucketDim.txt");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));
            String line;
            int counter =0;
            while((line=buffer.readLine()) != null){
                ++counter;
	            Document doc = new Document();
	            doc.add(new TextField("fileline", line + " at line no." + counter, Field.Store.YES));
	            writer.addDocument(doc);
            }
            
            writer.close();
            Query qry = new QueryParser("fileline", analyzer).parse(word);
            ScoreDoc[] hits = obj.searchForText(dir, qry);
            System.out.println("Searching for index done!");
			
            obj.displayresult(hits);
            rdr.close();
	}catch(IOException ioex){
            ioex.printStackTrace();
	}catch(ParseException parse){
            parse.printStackTrace();
	}
    }
	
    private ScoreDoc[] searchForText(Directory dir, Query query){
        ScoreDoc[] hits = null;
        try{
            int hitsperpage = 10;
            rdr = DirectoryReader.open(dir);
            searcher = new IndexSearcher(rdr);
            TopScoreDocCollector docollector = TopScoreDocCollector.create(hitsperpage);
            searcher.search(query, docollector);
            hits = docollector.topDocs().scoreDocs;
	}catch(IOException ioex){
            ioex.printStackTrace();
	}
            return hits;
    }
		
    private void displayresult(ScoreDoc[] hits) throws IOException{
        System.out.println("Found "+hits.length+" lines.");
	for(int i =0; i < hits.length; i++){
            int docid = hits[i].doc;
            Document d = searcher.doc(docid);
            System.out.println(d.get("fileline"));
	}
    }
	
}