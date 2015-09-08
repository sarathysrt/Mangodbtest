package mangodb;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MangodbUpdate {

	public static void main(String[] args) {
		
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			DB db = mongo.getDB("test");
			boolean auth = db.authenticate("admin", "123456".toCharArray());
			System.out.println("DB authentication"+auth);
			
			DBCollection table = db.getCollection("srt");
			
			BasicDBObject query = new BasicDBObject();
			query.put("name", "srt");

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", "srt-updated");
						
			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			table.update(query, updateObj);
			System.out.println("Updated successfully");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
