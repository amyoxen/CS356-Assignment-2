import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

/**This class is to generate the Admin Control Panel. 
 * Singleton is implemented to the class.
 * 
 */
public class AdminControlPanel extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//construct the tree
	final UserGroup root = new UserGroup("root");	
	private JTree userTree;
	private DefaultTreeModel treeModel;
	//the panel components declaration
	private JScrollPane treeViewPanel;
	private JTextField entryUserID, entryGroupID;
	private JButton btnAddUser, btnAddGroup, btnOpenUserView;
	private JButton btnShowUserTotal, btnShowGroupTotal, btnShowMessagesTotal, btnShowPosPercentage;
	//Single instance
	private static AdminControlPanel instance = null;
	
	private AdminControlPanel(){	
		entryUserID = new JTextField("User ID");
		entryGroupID =new JTextField("Group ID");
		btnAddUser = new JButton("Add User");
		btnAddGroup = new JButton("Add Group");
		btnOpenUserView = new JButton("Open User View");		
		btnShowUserTotal = new JButton("Show User Total");
		btnShowGroupTotal = new JButton("Show Group Total");
		btnShowMessagesTotal = new JButton("Show Messages Total");
		btnShowPosPercentage = new JButton("Show Positive Percentage");
		
		//Setup the fram parameters.
        setFont(new Font("SansSerif", Font.PLAIN, 14)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,550,300);
        Container myPane = this.getContentPane();
        myPane.setLayout(new BoxLayout(myPane,BoxLayout.X_AXIS));
		
		//Setup the treeViewPanel
		treeModel = new DefaultTreeModel(root);
		treeModel.setAsksAllowsChildren (true);  
		userTree = new JTree(treeModel);
		treeViewPanel = new JScrollPane(userTree);
		
		//Setup the panel layout
		JPanel inputPanel = new JPanel();
		JPanel userPanel = new JPanel();
		JPanel statPanel = new JPanel();
		JPanel leftPanel = new JPanel(new BorderLayout());		
        leftPanel.add(treeViewPanel);
        treeViewPanel.setMinimumSize(new Dimension(150, 300));
		myPane.add(leftPanel);
		
		inputPanel.setLayout(new BorderLayout());
		myPane.add(inputPanel);
		inputPanel.add(userPanel, BorderLayout.NORTH);
		inputPanel.add(statPanel, BorderLayout.SOUTH);
		inputPanel.setPreferredSize(new Dimension(300,300));
	
        GridBagConstraints c = new GridBagConstraints();
        userPanel.setLayout(new GridBagLayout());
        
        c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(2,2,2,2);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		userPanel.add (entryUserID,c);
		
		c.gridx = 1;
		c.gridy = 0;
		userPanel.add (btnAddUser,c);
		
		c.gridx = 0;
		c.gridy = 1;
		userPanel.add (entryGroupID,c);
		
		c.gridx = 1;
		c.gridy = 1;
		userPanel.add (btnAddGroup,c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		userPanel.add (btnOpenUserView,c);
		
		statPanel.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		statPanel.add (btnShowUserTotal,c);
		
		//define constrains for Show Group Total button
		c.gridx = 1;
		c.gridy = 0;
		statPanel.add (btnShowGroupTotal,c);
		
		//define constrains for Show Message Total button
		c.gridx = 0;
		c.gridy = 1;
		statPanel.add (btnShowMessagesTotal,c);
		
		//define constrains for Show Positive Percentage button
		c.gridx = 1;
		c.gridy = 1;
		statPanel.add (btnShowPosPercentage,c);	
		
		//Adding action listener for buttons.
		btnOpenUserView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (userTree.getLastSelectedPathComponent()==null){
					JOptionPane.showMessageDialog(null, "Please select a component.");
					return;
				}	else if(((UserComponent) userTree.getLastSelectedPathComponent()).setNodeIdentity()){
					JOptionPane.showMessageDialog(null, "Please select a User. ");
					} else {
						User selectedUser = (User)(userTree.getLastSelectedPathComponent());
						selectedUser.userPanel = new UserViewPanel(selectedUser, root);
						selectedUser.userPanel.setVisible(true); 
					}
			}		
		});
		
		btnAddUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				UserGroup group = null;
				String id = entryUserID.getText();
				if (userTree.getLastSelectedPathComponent()==null){
					JOptionPane.showMessageDialog(null, "Please select a component.");
					return;
				}
				
				if(((UserComponent) userTree.getLastSelectedPathComponent()).setNodeIdentity()){
					group = (UserGroup) userTree.getLastSelectedPathComponent();
					}
				else {
					group = ((User)(userTree.getLastSelectedPathComponent())).getParent();
				}			
				User addUser = new User(id);
				addUser.setNodeIdentity();
				group.addComponent(addUser);
				treeModel.reload(group);
			}
		});

		btnAddGroup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (userTree.getLastSelectedPathComponent()==null){
					JOptionPane.showMessageDialog(null, "Please select a component.");
					return;
				}
				UserGroup group = null;
				String id = entryGroupID.getText();
				if(((UserComponent) userTree.getLastSelectedPathComponent()).setNodeIdentity()){
					group = (UserGroup) userTree.getLastSelectedPathComponent();
					}
				else {
					group = ((User)(userTree.getLastSelectedPathComponent())).getParent();
				}
				
				UserGroup addGroup = new UserGroup(id);
				addGroup.setNodeIdentity();
				group.addComponent(addGroup);
				treeModel.reload(group);
			}
		});	
		
		btnShowGroupTotal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CountGroupVisitor v =new CountGroupVisitor();
				root.accept(v);
				JOptionPane.showMessageDialog(null, "Total number of groups: " + String.valueOf(v.showResults()));
			}
		});
		
		btnShowUserTotal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CountUserVisitor v =new CountUserVisitor();
				root.accept(v);
				JOptionPane.showMessageDialog(null, "Total number of Users: " + String.valueOf(v.showResults()));
			}
		});
		
		btnShowMessagesTotal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CountMessageVisitor v =new CountMessageVisitor();
				root.accept(v);
				JOptionPane.showMessageDialog(null, "Total number of NewsFeeds: " + String.valueOf(v.showResults()));
			}
		});
		
		btnShowPosPercentage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CountPositiveMsgsVisitor v =new CountPositiveMsgsVisitor();
				root.accept(v);
				JOptionPane.showMessageDialog(null, "Percentage of Positive Messages: " + String.valueOf(v.showResults())+"%");
			}
		});
}
	
	//Singleton Pattern for Admin Control Panel.
	public static AdminControlPanel getInstance(){
		if (instance == null){
			instance = new AdminControlPanel();
		}
		return instance;
	}
}