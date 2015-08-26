import java.awt.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class AdminControlPanel extends JPanel implements TreeSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane treeViewPanel;
	private JTextField entryUserID, entryGroupID;
	private JButton btnAddUser, btnAddGroup, btnOpenUserView;
	private JButton btnShowUserTotal, btnShowGroupTotal, btnShowMessagesTotal, btnShowPosPercentage;
	private JTree userTree;
	
	private static AdminControlPanel instance = null;
	
	private AdminControlPanel(){
		//treeViewArea = new JTextArea(15,15);	
		treeViewPanel = new JScrollPane();
		entryUserID = new JTextField("User ID");
		entryGroupID =new JTextField("Group ID");
		btnAddUser = new JButton("Add User");
		btnAddGroup = new JButton("Add Group");
		btnOpenUserView = new JButton("Open User View");		
		btnShowUserTotal = new JButton("Show User Total");
		btnShowGroupTotal = new JButton("Show Group Total");
		btnShowMessagesTotal = new JButton("Show Messages Total");
		btnShowPosPercentage = new JButton("Show Positive Percentage");
			
        setFont(new Font("SansSerif", Font.PLAIN, 14)); 
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,550,300);
        
		setLayout(new BorderLayout());
		
		//getContentPane().JPanel treeViewPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel userPanel = new JPanel();
		JPanel statPanel = new JPanel();
		
		inputPanel.setLayout(new BorderLayout());
		
		add(treeViewPanel, BorderLayout.WEST);
		add(inputPanel,BorderLayout.EAST);
		inputPanel.add(userPanel, BorderLayout.NORTH);
		inputPanel.add(statPanel, BorderLayout.SOUTH);
		//treeViewPanel.add(treeViewArea);
		inputPanel.setPreferredSize(new Dimension(300,300));
		
		
		UserGroup root = new UserGroup("root");
		userTree = new JTree(root);
		//createNodes(root);
		
		
		treeViewPanel.getViewport().add(userTree);
		add(treeViewPanel);
		
		
		//treeViewArea.setPreferredSize(new Dimension(120,200));
		//treeViewArea.setLineWrap(true);
		
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
		btnShowGroupTotal.addActionListener(new CountGroupVisitor());
		//define constrains for Show Message Total button
		c.gridx = 0;
		c.gridy = 1;
		statPanel.add (btnShowMessagesTotal,c);
		
		//define constrains for Show Positive Percentage button
		c.gridx = 1;
		c.gridy = 1;
		statPanel.add (btnShowPosPercentage,c);
		
	}
	
	private void createNodes(UserGroup root) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Launch the application.
	 */
	
	public static AdminControlPanel getInstance(){
		if (instance == null){
			instance = new AdminControlPanel();
		}
		return instance;
	}
	
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

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		UserGroup node = (UserGroup)userTree.getLastSelectedPathComponent();
		if (node==null){
			return;
		}
		Object nodeInfo = node.getUserObject();
		
		
	}
	
}