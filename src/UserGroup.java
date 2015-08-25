import java.util.ArrayList;
public class UserGroup implements UserComponent {
	private String id;
	private ArrayList <UserComponent> components;
	
	public UserGroup (String id){
		this.id = id;
		this.components = null;
	}
	
	@Override
	public String getComponentID(){
		return this.id;
	}
	
	public void addComponent(UserComponent c) {
		components.add(c);
	}

	@Override
	public void accept(ComponentVisitor visitor){
		for (UserComponent c : components){
			visitor.summerize(c);
		}
		
	}
	
	
}
