
public class TwitMessage {
	private String id;
	private String message;
	
	public TwitMessage(String userID, String m){
		this.id = userID;
		this.message = m;
	}
	
	
	public String getUserID(){
		return this.id;
	}
	
	public String getMessage(){
		return this.message;
	}
	
}

