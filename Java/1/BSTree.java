
public class BSTree 
{

	
	private TreeNode root;
	int count;
	static int count1,count2;
	public BSTree( )
	{
		root = null; 
		count=0;
		
	}
	public boolean isEmpty( )
	{
		return (root == null);
		
	}
	public int numberOfNodes( )
	{
		
		return count;
	}
	public int treeHeight( )
	{
		
		CountHeight(root);
		return  (count1+1);
	}
	
	public int treeHeight(Object data) 
	{
		
		
		
		CountHeight(root,data);
		return(count2+1);
	}
	
	public void insertElement(Object data)
	{ 
		if (isEmpty( ))
			root = new TreeNode(data);
		else
			insertNode(data,root);
		count++;
	}
	public void inOrderTraversal( )
	{ 
		System.out.println("INORDER TRAVERSAL");
		inOrder(root);
		System.out.println( );
		
	}
	public void preOrderTraversal( )
	{ 
		System.out.println("PREORDER TRAVERSAL");
		preOrder(root);
		System.out.println( );
		
	}
	public void postOrderTraversal( )
	{
		System.out.println("POSTORDER TRAVERSAL");
		postOrder(root);
		System.out.println( ); 
		
	}
	
	
	
	
	private void insertNode(Object data, TreeNode node)
	{
		
		if(((Comparable) data).compareTo(node.getNodeData()) >0)
		{
			if(node.getRightNode()==null)
				node.setRightNode(new TreeNode(data));
			else
				insertNode(data,node.getRightNode());
			
		}
		
		else if(((Comparable) data).compareTo(node.getNodeData()) <0)
		{
			if(node.getLeftNode()==null)
				node.setLeftNode(new TreeNode(data));
			else
				insertNode(data,node.getLeftNode());
		}
		else
			{
				if(((Comparable) data).compareTo(node.getNodeData())==0)
					node.setRightNode(new TreeNode(data));	
				else
					insertNode(data,node.getRightNode());
			}
	}
	
	private void inOrder(TreeNode node)
	{
		
		if (node == null)
			return;
			
		inOrder(node.getLeftNode());
		System.out.print(node.getNodeData() + " ");
		inOrder(node.getRightNode());
		
		
	}
	
	private void preOrder(TreeNode node)
	{
		
		if (node == null)
			return;
		
		System.out.print(node.getNodeData() + " ");
		preOrder(node.getLeftNode());
		preOrder(node.getRightNode());
		
	}
	
	private void postOrder(TreeNode node)
	{
		
		if (node == null)
			return;
			
		postOrder(node.getLeftNode());
		postOrder(node.getRightNode());
		System.out.print(node.getNodeData() + " ");
		
	}
	
	private void CountHeight(TreeNode node)
	{
		if (node == null)
			return;
		else if(node.getLeftNode()!=null)
			{
				CountHeight(node.getLeftNode());
				count1++;
			}
		else if(node.getRightNode()!=null)
		{
			
			CountHeight(node.getRightNode());
			count1++;
		}
	}
	
	private void CountHeight(TreeNode node,Object data)
	{
		if (node == null )
			return;
		else if( ((Comparable) data).compareTo(node.getNodeData())==0 )
		{
			count2++;
			return;
			
		}
		else if(node.getLeftNode()!=null)
			{
			if(((Comparable) data).compareTo(node.getLeftNode().getNodeData())==0)
			{
				count2++;
				return;
				
			}
			
				CountHeight(node.getLeftNode(),data);
				count2++;
			}
		else if(node.getRightNode()!=null)
		{
			if(((Comparable) data).compareTo(node.getRightNode().getNodeData())==0)
			{
				count2++;
				return;
				
			}
				CountHeight(node.getRightNode(),data);
			count2++;
		}
		
		
	}
	
	
	
}
