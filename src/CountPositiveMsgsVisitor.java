import java.util.ArrayList;
import javax.swing.JOptionPane;

/**visitor to count the % of positive messages.
 * 
 */
public class CountPositiveMsgsVisitor implements ComponentVisitor {
	
	//Use a string array to store the postive words.
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
	
	@Override
	public void examine(UserComponent c){
		 ArrayList <TwitMessage> newsFeeds =  new ArrayList<TwitMessage>();
		 if (c instanceof User){
			 newsFeeds = ((User) c).getNewsFeeds();
			 totalMsgCount += newsFeeds.size();
			 //Compare the strings in each news feed.
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
	
	public float showResults() {
		if (totalMsgCount == 0){
			JOptionPane.showMessageDialog(null, "No Input Message Yet!");
			return 0;
		}

		return (float)positiveMsgCount/totalMsgCount*100;
	}
	
}
