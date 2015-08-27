
public interface UserComponent {
	public String getComponentID();
	public UserGroup getParent();
	public void accept(ComponentVisitor visitor);
	public boolean setNodeIdentity();
}
