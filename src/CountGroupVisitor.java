/**visitor to count the total of groups.
 * 
 */
public class CountGroupVisitor implements ComponentVisitor {
	
	private int groupTotal;
	
	 public CountGroupVisitor(){
		 groupTotal=0;
	 }
	 
	 @Override
	 public void examine(UserComponent c){
		 if (c instanceof UserGroup){
			 groupTotal += 1;
		 }
	 }
	 
	 public int showResults(){
		 return groupTotal;
	 }
}
