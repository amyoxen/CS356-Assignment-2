import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Follower extends User implements Observer {
	private Map<String, String> map = new HashMap<String,String>();
	
	private ArrayList <UserComponent, String> followMsgs;
	@Override
	public void update(Observable follower, Object arg1) {
		// TODO Auto-generated method stub
	
		if (follower instanceof User){
			this.
		}
	
	}
}
