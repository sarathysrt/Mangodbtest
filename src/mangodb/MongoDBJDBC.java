package mangodb;

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

public class MongoDBJDBC{
   public static void main( String args[] ){
      try{   
    	  String myUserName="test";
    	  String myPassword="test";
		 // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         // Now connect to your databases
         DB db = mongoClient.getDB( "test" );
		 System.out.println("Connect to database successfully");
         boolean auth = true;//db.authenticate(myUserName, myPassword);
		 System.out.println("Authentication: "+auth);
//         DBCollection coll = db.createCollection("mycol", null);
         System.out.println("Collection created successfully");
         DBCollection col2 = db.getCollection("mycol");
         System.out.println("Collection mycol selected successfully");
//         BasicDBObject doc = new BasicDBObject("title", "MongoDB").
//                 append("description", "database").
//                 append("likes", 100).
//                 append("url", "http://www.tutorialspoint.com/mongodb/").
//                 append("by", "tutorials point");
//              coll.insert(doc);
              System.out.println("Document inserted successfully");
              
              DBCursor cursor = col2.find();
              int i=1;
              while (cursor.hasNext()) { 
                 System.out.println("Inserted Document: "+i); 
                 System.out.println(cursor.next()); 
                 i++;
              }
              
              
//              DBCursor cursor1 = col2.find();
//              while (cursor1.hasNext()) { 
//                 DBObject updateDocument = cursor1.next();
//                 updateDocument.put("likes","200");
//                 col2.update(updateDocument,null); 
//                 
//              }
//              System.out.println("Document updated successfully");
//              cursor1 = col2.find();
//              int i1=1;
//              while (cursor.hasNext()) { 
//                 System.out.println("Updated Document: "+i1); 
//                 System.out.println(cursor.next()); 
//                 i1++;
//              }
              
              DBObject myDoc = col2.findOne();
              col2.remove(myDoc);
              DBCursor cursor3 = col2.find();
              int i3=1;
              while (cursor3.hasNext()) { 
                 System.out.println("Inserted Document: "+i3); 
                 System.out.println(cursor3.next()); 
                 i3++;
              }
      }catch(Exception e){
	     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  }
   }
}