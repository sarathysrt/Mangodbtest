package mangodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MangodbCtTable {
	private ObjectId _id;
	 public static void main( String args[] ){
	// Since 2.10.0, uses MongoClient
	try {
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		DB db = mongo.getDB("test");
		boolean auth = db.authenticate("admin", "123456".toCharArray());
		System.out.println("DB authentication"+auth);
		
		
//		DBCollection table = db.getCollection("srt");
//		BasicDBObject document = new BasicDBObject();
//		document.put("name", "srt2");
//		document.put("age", 30);
//		document.put("gender", "M");
//		document.put("createdDate", new Date());
//		table.insert(document);
		
		
		DBCollection collection = db.getCollection("hosting");
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("database", "oracle");
		documentMap.put("table", "hosting");
			

		Map<String, Object> documentMapDetail = new HashMap<String, Object>();
		documentMapDetail.put("records", 199);
		documentMapDetail.put("index", "vps_index2");
		documentMapDetail.put("active", "true");
		
		BasicDBObject document = new BasicDBObject();
        document.put( "records",   15 );
        document.put( "index", "12s3" );
        document.put( "active",   "extra" );

		
		ArrayList< DBObject > array = new ArrayList< DBObject >();
		array.add( document );
		array.add( document );
		
		documentMap.put("detail", array);
		
		collection.insert(new BasicDBObject(documentMap));
		System.out.println("Created successfully");
		
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
	}
	 }
}
