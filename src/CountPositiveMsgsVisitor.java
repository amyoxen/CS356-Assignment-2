import java.lang.reflect.Array;
import java.util.ArrayList;


public class CountPositiveMsgsVisitor implements ComponentVisitor {
	private static ArrayList <String> postiveWords;
	private int positiveMsgCount;
	private int totalMsgCount;
	public CountPositiveMsgsVisitor(){
		postiveWords = new ArrayList<String>();
		postiveWords.add("excellent");
		postiveWords.add("good");
		postiveWords.add("fantastic");
		postiveWords.add("great");
		
		positiveMsgCount=0;
	}
	
	
	public void summerize(UserComponent c){
		 ArrayList <TwitMessage> newsFeeds =  new ArrayList<TwitMessage>();
		 if (c instanceof User){
			 newsFeeds = ((User) c).getNewsFeeds();
			 totalMsgCount += Array.getLength(newsFeeds);
			 
			 for (TwitMessage m: newsFeeds){		 
				 for (String p:postiveWords){
					 if (m.getMessage().toLowerCase().contains(p.toLowerCase())){
						 positiveMsgCount++;
						 break;
					 }
				 }
			 }
		 }
	 }
	
	public void showResult(){
		float result = (float)positiveMsgCount/totalMsgCount;
		System.out.println(String.valueOf(result));
	}
	
}
