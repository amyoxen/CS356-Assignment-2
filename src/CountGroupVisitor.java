import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CountGroupVisitor implements ComponentVisitor, ActionListener {
	private int groupTotal;
	JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	 public CountGroupVisitor(){
		 groupTotal=0;
	 }
	 
	 public void summerize(UserComponent c){
		 if (c instanceof UserGroup){
			 groupTotal += 1;
		 }
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(frame, groupTotal);	
	}
}
