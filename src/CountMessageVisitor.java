import java.lang.reflect.Array;

public class CountMessageVisitor implements ComponentVisitor {
	private int messageTotal;
	 public CountMessageVisitor(){
		 messageTotal=0;
	 }
	 
	 public void summerize(UserComponent c){
		 if (c instanceof User){
			 messageTotal += Array.getLength(((User) c).getNewsFeeds());
		 }
	 }
	 
	 public int showResults(){
		 return messageTotal;
	 }
	 
}
