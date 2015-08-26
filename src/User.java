import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public class User extends DefaultMutableTreeNode implements Subject, UserComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	protected ArrayList <Follower> followers;
	protected ArrayList <User> followings;
	protected ArrayList <TwitMessage> newsFeeds;
	
	
	public User(String id){
		this.id = id;
		this.followers=new ArrayList<Follower>();
		this.followings =new ArrayList<User>();
		this.newsFeeds = new ArrayList <TwitMessage>();
	}
	
	@Override
	public String getComponentID(){
		return this.id;
	}
	
	public ArrayList <TwitMessage> getNewsFeeds(){
		return this.newsFeeds;
	}
	
	public void twitaMessage(String messageString){
		TwitMessage message = new TwitMessage(this.id, messageString);
		newsFeeds.add(message);
		printNewsFeed();
		this.notifyObservers(message);
	}
	
	@Override
	public void registerObserver(Observer o) {
		followers.add((Follower) o);
	}

	@Override
	public void removeObserver(Observer o) {
		followers.remove((User) o);
	}

	@Override
	public void notifyObservers(Object message) {
		for (Follower f: followers){
			if (message instanceof TwitMessage){
			f.update(this, (TwitMessage)message);
			}
		}		
	}
	
	@Override
	public void accept(ComponentVisitor visitor){
		visitor.summerize(this);
	}
	
	public void printNewsFeed(){
		for (TwitMessage i: newsFeeds){
			System.out.println(i.getUserID()+ ": "+i.getMessage());
		}
		
	}

	

}
	
