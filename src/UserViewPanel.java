import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**UserViewPanel for each user.
 * 
 */
public class UserViewPanel extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//an internal user pointed to the parent user.
	private User user;
	
	//components
	private JPanel supportPanel;
	private JScrollPane followingViewPanel, newsFeedViewPanel;
	private JTextField entryFollowUserID;
	private JButton btnFollowUser, btnPostTweet;
	public JTextArea tweetMessage, followingView, newsFeedView;
	
	//Constructor with user and tree root.
	public UserViewPanel(User passUser, final UserGroup root){
	this.user = passUser;
	supportPanel = new JPanel();
	tweetMessage = new JTextArea();	
	followingView = new JTextArea("(Current Following)");
	newsFeedView = new JTextArea("(News Feed)");	
	entryFollowUserID = new JTextField ("User ID");
	btnFollowUser = new JButton("Follow User");
	btnPostTweet = new JButton("Post Tweet");
	
	setFont(new Font("SansSerif", Font.PLAIN, 14)); 
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 300, 500);
	setTitle(user.getComponentID());
	
	add(supportPanel);
	supportPanel.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	c.insets = new Insets(2,2,2,2);	
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	c.gridwidth = 1;
	c.gridheight = 1;
	c.ipady = 30;
	supportPanel.add (entryFollowUserID,c);

	c.gridx = 1;
	c.gridy = 0;
	supportPanel.add (btnFollowUser,c);
	
	c.gridx = 0;
	c.gridy = 1;
	c.gridwidth = 2;
	c.gridheight = 4;
	c.fill = GridBagConstraints.BOTH;
	c.weightx = 1;
	c.weighty = 1;
	followingView.setLineWrap(true);
	followingViewPanel =new JScrollPane(followingView);
	supportPanel.add (followingViewPanel,c);
	
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
	supportPanel.add (tweetMessage, c);
	
	c.gridx = 1;
	c.gridy = 6;
	supportPanel.add (btnPostTweet,c);
	
	
	c.gridx = 0;
	c.gridy = 8;
	c.gridwidth = 2;
	c.gridheight = 4;
	c.fill = GridBagConstraints.BOTH;
	c.weightx = 1;
	c.weighty = 1;
	newsFeedView.setLineWrap(true);
	newsFeedViewPanel =new JScrollPane(newsFeedView);
	supportPanel.add (newsFeedViewPanel, c);

	//Add the button listeners.
	btnFollowUser.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String id = entryFollowUserID.getText();
			
			//Check to see if the user exists in the tree of group.
			UserExistVisitor v = new UserExistVisitor(id);
			root.accept(v);
			if (v.returnUser()==null){
				JOptionPane.showMessageDialog(null, "User not Exist.");
				return;
			}
			
			((User)v.returnUser()).registerObserver((Follower)user);
			user.printFollowings();			
		}
	});	
	
	//button to tweet a message.
	btnPostTweet.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			String message = tweetMessage.getText();
			user.twitaMessage(message);		
		}
	});
	}
	
}

