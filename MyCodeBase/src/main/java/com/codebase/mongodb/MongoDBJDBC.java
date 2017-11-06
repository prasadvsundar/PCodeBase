package com.codebase.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;

public class MongoDBJDBC {

   public static void main( String args[] ) {
	
      try{   
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient("localhost" , 27017 );
			
         // Now connect to your databases
         DB db = mongoClient.getDB( "nanobi" );
         System.out.println(db.getCollection("movie").getCount());
        
         DBCollection coll = db.getCollection("movie");
         DBCursor cursor = coll.find();
			
         while (cursor.hasNext()) { 
            System.out.println(cursor.next());
         }
			
        /* boolean auth = db.authenticate("prasad", "Welcome1");
         System.out.println("Authentication: "+auth);
			
         DBCollection coll = db.createCollection("mycol");
         System.out.println("Collection created successfully");*/
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}