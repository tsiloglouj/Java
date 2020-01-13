
public class TreeNode
{

	
	private TreeNode left;
	private Object item;
	private TreeNode right;
	

	
	TreeNode(Object item)
	{
		
		this.item=item;
		left=right=null;
	}
	
	
	public Object getNodeData()
	{
		return item;
	}
	
	
	
	public TreeNode getLeftNode( )
	{
		
		return left;
		
	}
	public TreeNode getRightNode( )
	{
		
		return right;
		
	}
	public boolean isLeaf( )
	{
		
		return(left==null && right==null);
		
	}
	public void setLeftNode(TreeNode node)
	{
		
		left=node;
		
	}
	public void setRightNode(TreeNode node)
	{
		
		right=node;
		
	}
	
}
