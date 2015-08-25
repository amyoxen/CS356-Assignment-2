
public interface UserComponent {

	public String getComponentID();
	
	public void accept(ComponentVisitor visitor);
}
