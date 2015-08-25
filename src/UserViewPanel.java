import java.awt.*;
import javax.swing.*;

public class UserViewPanel extends JFrame {
private static final long serialVersionUID = 1L;
	private JPanel userPanel;
	private JTextArea tweetMessage, followingView, newsFeedView;
	private JTextField entryFollowUserID;
	private JButton btnFollowUser, btnPostTweet;
	
	public UserViewPanel(){
	
	userPanel = new JPanel();
	tweetMessage = new JTextArea();	
	followingView = new JTextArea("List View");
	newsFeedView = new JTextArea("List View");	
	entryFollowUserID = new JTextField ("User ID");
	btnFollowUser = new JButton("Follow User");
	btnPostTweet = new JButton("Post Tweet");
	
	setFont(new Font("SansSerif", Font.PLAIN, 14)); 
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 600, 600);
	
	add(userPanel);
	userPanel.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	c.insets = new Insets(2,2,2,2);	
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	c.gridwidth = 1;
	c.gridheight = 1;
	c.ipady = 30;
	userPanel.add (entryFollowUserID,c);

	c.gridx = 1;
	c.gridy = 0;
	userPanel.add (btnFollowUser,c);
	
	c.gridx = 0;
	c.gridy = 1;
	c.gridwidth = 2;
	c.gridheight = 4;
	c.fill = GridBagConstraints.BOTH;
	c.weightx = 1;
	c.weighty = 1;
	userPanel.add (followingView,c);
	
	c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 2;
	c.insets = new Insets(2,2,2,2);	
	c.gridx = 0;
	c.gridy = 6;
	c.gridwidth = 1;
	c.gridheight = 1;
	c.ipady = 30;
	tweetMessage.setPreferredSize(new Dimension(2,10));
	tweetMessage.setLineWrap(true);
	userPanel.add (tweetMessage, c);
	
	c.gridx = 1;
	c.gridy = 6;
	userPanel.add (btnPostTweet,c);
	
	
	c.gridx = 0;
	c.gridy = 8;
	c.gridwidth = 2;
	c.gridheight = 4;
	c.fill = GridBagConstraints.BOTH;
	c.weightx = 1;
	c.weighty = 1;
	userPanel.add (newsFeedView, c);
	
}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserViewPanel mypanel = new UserViewPanel();
					 mypanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

