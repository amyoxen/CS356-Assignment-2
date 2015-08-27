/**visitor to see whether a user with a certain ID exists.
 * If it exists, return the user.
 */
public class UserExistVisitor implements ComponentVisitor{
	
	private String userID;
	private User findUser = null;
	
	public UserExistVisitor(String s){
		userID = s;
	}
	
	@Override
	public void examine(UserComponent c){
		String storeEachUserId = null;
		if (c instanceof User){
			storeEachUserId = c.getComponentID();
			if (storeEachUserId.equals(userID)){
				findUser = (User)c;
			}	
		}
	}
	
	public User returnUser() {
		return findUser;
	}
	
}
