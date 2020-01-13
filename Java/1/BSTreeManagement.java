import java.util.Random;



public class BSTreeManagement 
{
	 public static int options()
	 {
	 	System.out.println("\nOPTIONS");
	 	System.out.println("1.Eisagwgh foithtwn");
	 	System.out.println("2.INORDER TRAVERSAL");
	 	System.out.println("3.PREORDER TRAVERSAL");
	 	System.out.println("4.POSTORDER TRAVERSAL");
	 	System.out.println("5.PLITHOS KOMBWN DENTROU");
	 	System.out.println("6.YPSOS TOU DENTROU");
	 	System.out.println("7.YPSOS DENTROU GIA SYGKEKRIMENO DENTRO");
	 	System.out.println("8.TELOS PROGRAMMATOS");
	 	System.out.print("> DWSE EPILOGH : ");
	 	
	 	return UserInput.getInteger() ;
	 }
	 
	 public static int insertOptions()
	 {
		 
		 System.out.println("TROPOS EISAGWGHS");
		 System.out.println("1.MANUAL");
		 System.out.println("2.RANDOM");
		 System.out.print("DWSE EPILOGH");
		 
		 return UserInput.getInteger();
		 
	 }
	 
	 
	 
	public static void main(String args[ ])
	{
	
		
		BSTree tree = new BSTree( );
		Random rand = new Random();
		
		int ep,n;	
		String dat = "";
			
		do 
		{
			
			 ep=options();
			switch(ep)
			{
			case 1:int op=insertOptions();
				if(op==1)
				{
					
					 System.out.print("DWSE AM :");
					 int am=UserInput.getInteger();
					 System.out.print("DWSE ONOMA :");
					 String on=UserInput.getString();
					 System.out.print("DWSE VATHMO :");
					 double va=UserInput.getDouble();
					 tree.insertElement(new Student(am,on,va));
					
					
				}else
				{
				  n = rand.nextInt(50) + 1;	
				  for (int i=0; i<=5; i++) {
					  char data = (char)(rand.nextInt(25)+97);
					  dat = data + dat;
					}
				  tree.insertElement(new Student(n,dat,n));
				}
			break;
			case 2:
				if(tree.isEmpty())
			
					System.out.print("TO DENTRO EINAI ADEIO \n");
				else
					tree.inOrderTraversal( );
				break;
			case 3:
				if(tree.isEmpty())
					
					System.out.print("TO DENTRO EINAI ADEIO \n");
				else
				tree.preOrderTraversal( );
				break;
			case 4:
				if(tree.isEmpty())
					
					System.out.print("TO DENTRO EINAI ADEIO \n");
				else
				tree.postOrderTraversal( );
				break;
			case 5:
				if(tree.isEmpty())
					
					System.out.print("TO DENTRO EINAI ADEIO \n");
				else
				System.out.println(tree.numberOfNodes());
				break;
			case 6:
				if(tree.isEmpty())
					
					System.out.print("TO DENTRO EINAI ADEIO \n");
				else
				System.out.println(tree.treeHeight());
				break;
			case 7:
				if(tree.isEmpty())
					
					System.out.print("TO DENTRO EINAI ADEIO \n");
				else
				{
				System.out.println("DWSE STOIXEIA SYGKEKRHMENOU KOMBOU");
				 System.out.print("DWSE AM :");
				 int am=UserInput.getInteger();
				 System.out.print("DWSE ONOMA :");
				 String on=UserInput.getString();
				 System.out.print("DWSE VATHMO :");
				 double va=UserInput.getDouble();
				
				System.out.println(tree.treeHeight(new Student(am,on,va)));
				}
			break;
			case 8:
				System.out.println("TELOS PROGRAMMATOS");
				break;
			default:
				System.out.println("DWSE MIA APO TIS YPARXOUSES EPILOGES");
				break;
			
			}
			
		}while(ep!=8);
			
		
	
	
		
	}
	
	
	
}
