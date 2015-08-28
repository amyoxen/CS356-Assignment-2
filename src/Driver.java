/**Drive class
 * 
 */
import java.awt.EventQueue;

public class Driver {
	
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 AdminControlPanel mypanel = AdminControlPanel.getInstance();
					 mypanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
