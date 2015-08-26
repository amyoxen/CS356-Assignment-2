public class Follower extends User implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Follower (String id) {
		super(id);		
	}
	
	public void addSubject(Subject s){
		followings.add((User)s);
		s.registerObserver(this);
	}

	@Override
	public void update(Subject following, TwitMessage msg){
		if (following instanceof User){
			this.newsFeeds.add((TwitMessage)msg);
			printNewsFeed();
		}
		
	}

}
