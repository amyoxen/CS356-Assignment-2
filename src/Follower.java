import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Follower extends User implements Observer {
	
	@Override
	public void update(Observable following, Object msg) {
		
		if (following instanceof User){
			//TwitMessage message = new TwitMessage((User)following, (TwitMessage)msg);
			this.followingMsgs.add((TwitMessage)msg);
		}
	
	}
	
	
	public void addFollwings(User u){
		followings.add(u);
	}
}
