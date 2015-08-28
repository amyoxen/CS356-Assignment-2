import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/** User group extends DefaultMutableTreeNode for display purpose. 
*   Composite pattern is implemented. 
*   Observation pattern is implemented.
*/
public class User extends DefaultMutableTreeNode implements UserComponent, Subject, Observer{
	
	private static final long serialVersionUID = 1L;
	protected ArrayList <User> followers;
	protected ArrayList <User> followings;
	protected ArrayList <TwitMessage> newsFeeds;
	
	//Each userViewPanel is dedicated to each user.. 
	public UserViewPanel userPanel;
		
	public User(String id){
		super(id);
		this.followers=new ArrayList<User>();
		this.followings =new ArrayList<User>();
		this.newsFeeds = new ArrayList <TwitMessage>();
	}
	
	public ArrayList <TwitMessage> getNewsFeeds(){
		return this.newsFeeds;
	}

	@Override
	public String getComponentID(){
		return this.getUserObject().toString();
	}
	
	//Visitor Pattern
	@Override
	public void accept(ComponentVisitor visitor){
		visitor.examine(this);
	}
	
	//Tweet a message. It notifies observers at the same time.
	public void twitaMessage(String message) {
		TwitMessage m = new TwitMessage(this.getComponentID(), message);
		this.newsFeeds.add(m);
		this.printNewsFeed();
		this.notifyObservers(m);
	}
	
	//Print features to the panel.
	public void printFollowings() {
		userPanel.followingView.setText("(Current Following)\n");
		for (User i: followings){
			userPanel.followingView.setText(userPanel.followingView.getText()+"- "+i.getComponentID()+"\n");
		}
	}
	
	public void printNewsFeed(){
		userPanel.newsFeedView.setText("(News Feed)\n");
		for (TwitMessage i: newsFeeds){
			userPanel.newsFeedView.setText(userPanel.newsFeedView.getText()+"- "+i.getUserID()+": "+i.getMessage()+"\n");
		}
	}
	
	//component override functions
	@Override
	public UserGroup getParent(){
		return (UserGroup)(this.parent);
	}
	
	@Override
	public boolean setNodeIdentity(){
		setAllowsChildren(false);
		return false;
	}
	
	//Observer override functions
	@Override
	public void registerObserver(Observer o) {
		if(o instanceof User){
			//To avoid adding the same follower in the followers list.
			for(User i: followers){
				if (i.getComponentID().equals(((User)o).getComponentID())){
					return;
				}
			}
			this.followers.add((User) o);
			((User)o).addFollowing(this);
		}
	}
	
	@Override
	public void removeObserver(Observer o) {
		followers.remove((User) o);
	}
	
	@Override
	public void notifyObservers(TwitMessage message) {
		for (User f: followers){		
			f.update(this, message);
		}		
	}
	/**Create a follower ground to implement observer.
	 * 
	**/

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


	
