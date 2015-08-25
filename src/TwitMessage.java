
public class TwitMessage {
	private User user;
	private String message;
	
	public TwitMessage(User u, String m){
		this.user = u;
		this.message = m;
	}
	
	public void print(){
		System.out.println(user.getComponentID()+": "+message);
	}
	
}

