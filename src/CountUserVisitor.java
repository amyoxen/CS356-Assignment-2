/**visitor to count the number of users.
 * 
 */
public class CountUserVisitor implements ComponentVisitor {
	
		private int userTotal;
		 public CountUserVisitor(){
			 userTotal=0;
		 }
		 
		 @Override
		 public void examine(UserComponent c){
			 if (c instanceof User){
				 userTotal += 1;
			 }
		 }
		 
		 public int showResults(){
			 return userTotal;
		 }
	}
