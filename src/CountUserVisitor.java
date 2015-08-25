
public class CountUserVisitor implements ComponentVisitor {
		private int userTotal;
		 public CountUserVisitor(){
			 userTotal=0;
		 }
		 
		 public void summerize(UserComponent c){
			 if (c instanceof User){
				 userTotal += 1;
			 }
		 }
		 
		 public int showResults(){
			 return userTotal;
		 }
	}
