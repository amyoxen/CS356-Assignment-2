import java.util.Observable;
import java.util.Observer;

public class Follower extends User implements Observer {
	
	public Follower (String id) {
		super(id);		
	}
	
	@Override
	public void update(Observable following, Object msg) {		
		if (following instanceof User){
			this.newsFeeds.add((TwitMessage)msg);
			printNewsFeed();
		}
	}
	
	public void addFollwings(User u){
		followings.add(u);
		u.addObserver(this);
	}
	
}
