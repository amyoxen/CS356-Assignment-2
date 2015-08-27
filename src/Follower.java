/**Create a follower ground to implement observer.
 * 
**/
public class Follower extends User implements Observer {
	private static final long serialVersionUID = 1L;
	public Follower (String id) {
		super(id);		
	}
	
	public void addFollowing(User s){
			followings.add(s);
	}

	@Override
	public void update(Subject s, TwitMessage m) {
		if (s instanceof User){
			this.newsFeeds.add(m);
			this.printNewsFeed();
		}
	}
}
