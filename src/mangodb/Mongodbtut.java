package mangodb;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Mongodbtut {
	 public static void main( String args[] ){
	// Since 2.10.0, uses MongoClient
	try {
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		DB db = mongo.getDB("test");
		boolean auth = db.authenticate("admin", "123456".toCharArray());
		System.out.println("DB authentication"+auth);
		// get db names
		List<String> dbs = mongo.getDatabaseNames();
		for(String db1 : dbs){
		
			System.out.println(db1);
		}
		System.out.println("TEST collection names");
		// get collection names
		Set<String> tables = db.getCollectionNames();
		
		for(String coll : tables){
			System.out.println(coll);
		}

		
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
	}
	 }
}
