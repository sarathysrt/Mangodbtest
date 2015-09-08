package mangodb;
import java.io.Serializable;
import org.bson.types.ObjectId;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Address implements Serializable{
	private ObjectId _id;
	private int    type;
	private String street;
	private String city;
	private String state;
	
	public ObjectId getId() { return this._id; }

	public void makePojoFromBson( DBObject bson )

	{

	BasicDBObject b = ( BasicDBObject ) bson;

	this._id    = ( ObjectId ) b.get( "_id" );

	this.type   = ( Integer )  b.get( "type" );

	this.street = ( String )   b.get( "street" );

	this.city   = ( String )   b.get( "city" );

	this.state  = ( String )   b.get( "state" );
	}
}
