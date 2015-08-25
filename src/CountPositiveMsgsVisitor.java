import java.util.Map;
import java.util.HashMap;

public class CountPositiveMsgsVisitor implements ComponentVisitor {
	private static Map <String, Integer> postiveWords;
	
	public CountPositiveMsgsVisitor(){
		postiveWords = new HashMap<String, Integer>();
		postiveWords.put("excellent",0);
		postiveWords.put("good",0);
		postiveWords.put("fantastic",0);
	}
	
	pub
	
	
}
