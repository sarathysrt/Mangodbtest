package mangodb;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBList;
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
			
			DBCollection table = db.getCollection("Documents");
			

			BasicDBObject searchQuery = new BasicDBObject();

			searchQuery.put("Name", "Documents");

			DBCursor cursor = table.find(searchQuery);

			while (cursor.hasNext()) {
				System.out.println("s"+cursor.next());
			}
			
			DBCollection col2 = db.getCollection("Documents");
			DBCursor query = col2.find(new BasicDBObject(),new BasicDBObject("_id", 0));
//            List<DBObject> myList = null;
//            myList = query.toArray();
//           myList.forEach(System.out::println);
			String Disp =null;
			while (query.hasNext()) {
				DBObject o = query.next();
				Disp=o.get("Name").toString()+" -> Books read [";
				if (o.get("BooksRead").toString().contains("[")){
					BasicDBList addresses = ( BasicDBList ) o.get( "BooksRead" );

			        for( Iterator< Object > it = addresses.iterator(); it.hasNext(); )
			        {
			            BasicDBObject dbo     = ( BasicDBObject ) it.next();
			            //System.out.println(dbo.get("name"));
			            Disp = Disp+" "+dbo.get("name")+",";
			        }
				  
        	  }
        	  else
        	  {
        		  BasicDBObject b = ( BasicDBObject ) o.get("BooksRead");
				  System.out.println(b.get("names"));
        	  }	
				System.out.println(Disp+" ]");
				
			}
			

            
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
