import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**UserGroup is a composite of the userComponent.
 * 
 */
public class UserGroup extends DefaultMutableTreeNode implements UserComponent {
	
	private static final long serialVersionUID = 1L;
	private ArrayList <UserComponent> components;
	
	public UserGroup (String id){
		super(id);
		this.components = new ArrayList <UserComponent>();
	}
	
	@Override
	public String getComponentID(){
		return this.getUserObject().toString();
	}
	
	//Only UserGroup and User is inherited from DefaultTreeNode, therefore, the component is casted.
	public void addComponent(UserComponent c) {
		if (c instanceof User){
			this.add((User)c);
		}		
		if (c instanceof UserGroup){
			this.add((UserGroup)c);
		}
		components.add(c);
	}

	@Override
	public void accept(ComponentVisitor visitor){
		visitor.examine(this);
		for (UserComponent c : components){
			c.accept(visitor);
		}
	}
	
	@Override
	public UserGroup getParent(){
		return (UserGroup)(this.parent);
	}
	
	@Override
	public boolean setNodeIdentity(){
		setAllowsChildren(true);
		return true;
	}
}
