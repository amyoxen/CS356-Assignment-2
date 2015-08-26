import java.util.ArrayList;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class UserGroup extends DefaultMutableTreeNode implements UserComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private ArrayList <UserComponent> components;
	
	public UserGroup (String id){
		super(id);
		this.id = id;
		this.components = new ArrayList <UserComponent>();
	}
	
	@Override
	public String getComponentID(){
		return this.id;
	}
	
	public void addComponent(UserComponent c) {
		if (c instance of User){
			
		}
		this.add(c);
		components.add(c);
	}

	@Override
	public void accept(ComponentVisitor visitor){
		for (UserComponent c : components){
			visitor.summerize(c);
		}
		
	}
	
	
}
