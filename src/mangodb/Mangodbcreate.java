package mangodb;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Mangodbcreate {

	public static void main(String[] args) {
		
		MongoClient mongoClient = null ;
		  try {
		   mongoClient = new MongoClient( "localhost" , 27017 );
		  } catch (UnknownHostException e) {
		   e.printStackTrace();
		  }
		  
		  DB db = mongoClient.getDB( "test" );
		  DBCollection documents = db.getCollection("Documents");
		  BasicDBObject document = new BasicDBObject();
		  document.put("Id", 12345);
		  document.put("Name", "sarathy");
		  document.put("Age", 25);
//		  try {
//		   Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse("1984-05-08T8:30:00.000Z");
//		   document.put("DateOfBirth", date);
//		  } catch (ParseException e) {
//		   e.printStackTrace();
//		  }
		  
		  String [] interests = {"Reading", "Politics", "Basketball"};
		  document.put("Interests", interests);

		  BasicDBObject address = new BasicDBObject();
		  address.put("addressDetail", "flat no 103, A Wing, Ram Nagar" );
		  address.put("area", "CHengalpet");
		  address.put("city", "Chennai");
		  address.put("pincode", 603202);
		  address.put("state", "TamilNadu");
		  address.put("country", "INDIA");

		  document.put("Address", address);
		  document.put("address", address);

		  List<BasicDBObject> booksRead = new ArrayList<BasicDBObject>();
		  BasicDBObject book1 = new BasicDBObject();
		  book1.put("name", "The Immortals of Meluha");
		  book1.put("authorName", "Amish Tripathi");
		  book1.put("publishedBy", "Westland Press");
		  booksRead.add(book1);

		  BasicDBObject book2 = new BasicDBObject();
		  book2.put("name", "The Krishna Key");
		  book2.put("authorName", "Ashwin Sanghi");
		  book2.put("publishedBy", "Westland Ltd");
		  booksRead.add(book2);

		  BasicDBObject book3 = new BasicDBObject();
		  book3.put("name", "Sita: An Illustrated Retelling of Ramayana");
		  book3.put("authorName", "Devdutt Pattanaik");
		  book3.put("publishedBy", "Mehata Publishing Ltd");
		  booksRead.add(book3);

		  document.put("BooksRead", booksRead);


		  documents.insert(document);

	}

}
