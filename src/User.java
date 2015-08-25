import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class User extends Observable implements UserComponent{
	private String id;
	private ArrayList <User> followers;
	private ArrayList <User> followings;
	private ArrayList <String> twitMessages;
	
	
	
	
	@Override
	public String getComponentID(){
		return this.id;
	}
	
	@Override
	public void addObserver(Observer o){
		followers.add((User) o);
	}
	
	@Override
	public void deleteObserver(Observer o){
		followers.remove((User) o);
	}
	
	@Override
	public void deleteObserver(Observer o){
		followers.remove((User) o);
	}
	
	public void notifyObservers(String m){
		for (User f:followers){
			f.update(this, m);
		}
	}
	
	public void twitMessage(String m){
		twitMessages.add(m);
		notifyObservers(m);
	}
	
	
}
