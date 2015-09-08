package mangodb;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MangodbDelete {

	public static void main(String[] args) {
		
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			DB db = mongo.getDB("test");
			boolean auth = db.authenticate("admin", "123456".toCharArray());
			System.out.println("DB authentication"+auth);
			
			DBCollection table = db.getCollection("srt");
			
			//DBCollection table = db.getCollection("user");

			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "srt");

			table.remove(searchQuery);
			System.out.println("Removed successfully");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
