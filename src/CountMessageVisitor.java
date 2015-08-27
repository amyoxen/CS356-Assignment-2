/**visitor to count the total of messages.
 * 
 */
public class CountMessageVisitor implements ComponentVisitor {
	private int messageTotal;
	 public CountMessageVisitor(){
		 messageTotal=0;
	 }
	 
	 @Override
	 public void examine(UserComponent c){
		 if (c instanceof User){
			 messageTotal += ((User) c).getNewsFeeds().size();
		 }
	 }
	 
	 public int showResults(){
		 return messageTotal;
	 }
	 
}
