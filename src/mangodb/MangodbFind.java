package mangodb;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MangodbFind {

	public static void main(String[] args) {
		
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			DB db = mongo.getDB("test");
			boolean auth = db.authenticate("admin", "123456".toCharArray());
			System.out.println("DB authentication"+auth);
			
			DBCollection table = db.getCollection("srt");
			

			BasicDBObject searchQuery = new BasicDBObject();

			searchQuery.put("name", "srt");

			DBCursor cursor = table.find(searchQuery);

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			DBCollection col2 = db.getCollection("hosting");
//			BasicDBObject searchQuery1 = new BasicDBObject();
//			searchQuery1.put("name",new BasicDBObject("$regex", "srt"));
            //DBCursor cursor3 = col2.find(new BasicDBObject("name",new BasicDBObject("$regex", "srt")), new BasicDBObject("name", 1).append("age", 1).append("_id", 0).append("gender", 1));
			DBCursor cursor3 = col2.find(new BasicDBObject(),new BasicDBObject("_id", 0));
            List<DBObject> myList = null;
            
            myList = cursor3.toArray();
            System.out.println("test"+cursor3.toString());
            
           myList.forEach(System.out::println);


//            int i3=1;
//            while (cursor3.hasNext()) { 
//               System.out.println("Inserted Document: "+i3); 
//               //System.out.println(cursor3);
//               System.out.println("hh"+cursor3.next());
//               i3++;
//            }
//            


            
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
