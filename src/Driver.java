
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User aa = new User("fsdfsdf");
		Follower bb = new Follower("bb");
		
		bb.addFollwings(aa);
		aa.twitaMessage("dd");
		bb.twitaMessage("dfd");
		
	}

}
