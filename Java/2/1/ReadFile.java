import java.io.*;

public class ReadFile
{
	
	public static int options()
	{
		
		System.out.println("Επιλογες");
		System.out.println("1.Δημιουργια αρχειου");
		System.out.println("2.Εμφανιση αρχειου");
		System.out.println("3.Ταξινομηση 2 αρχειων");
		System.out.println("4.Τελος προγραμματος");
		System.out.print("Δωσε μια επιλογη: ");
		
		
		
		return UserInput.getInteger();
		
	}
	
	
	
	
	public static void insert(String name)
	{
		int data[]=new int[10];
		
		for(int i=0;i<10;i++)
			data[i]=(int )(Math.random() * 50 + 1);
		
		try
		{
			FileOutputStream file = new FileOutputStream(name);
			for(int  i=0;i<data.length;i++)
				file.write(data[i]);
			file.close();
		
		}catch(IOException msg)
		{
			System.out.println("Error"+msg.toString());
			
		}
	}

	public static void readf(String name)
	{
		
		try
		{
			
			FileInputStream file = new FileInputStream(name);
		
			boolean flag=false;
			int count=0;
			
			while(!flag)
			{
				int input=file.read();
				System.out.print(input + " ");
				if(input == -1)
					flag=true;
				else 
					count++;
				
			}
			file.close();
			
			System.out.println("\nBytes read: "+ count);
		}catch(IOException msg)
		{
			System.out.println("Error "+ msg.toString());
		}
		
		
	}

	public static void sort(String name,String name2,int[]array)
	{
		
		try
		{
			
			FileInputStream file = new FileInputStream(name);
			FileInputStream file2 = new FileInputStream(name2);
			
			boolean flag=false;
			int count=0;
		
			while(!flag)
			{
				int input=file.read();
				
				if(input == -1)
					flag=true;
				else 
				{
					array[count]=input;
					count++;
				}
				
			}
			file.close();
			flag=false;
			while(!flag)
			{
				int input2=file2.read();
				if(input2 == -1)
					flag=true;
				else 
				{
					array[count]=input2;
					count++;
				}
					
				
			}
			file2.close();
			
			
		}catch(IOException msg)
		{
			System.out.println("Error "+ msg.toString());
		}
		
		
	}

	  private int[] arraylist;
	  private int[] temp;
	  private int length;

	  public void sortr(int[] values) {
	    this.arraylist = values;
	    length = values.length;
	    this.temp = new int[length];
	    mergesort(0, length - 1);
	  }

	  private void mergesort(int low, int high) {
	    // check if low is smaller then high, if not then the array is sorted
	    if (low < high) {
	      // Get the index of the element which is in the middle
	      int middle = low + (high - low) / 2;
	      // Sort the left side of the array
	      mergesort(low, middle);
	      // Sort the right side of the array
	      mergesort(middle + 1, high);
	      // Combine them both
	      merge(low, middle, high);
	    }
	  }

	  private void merge(int low, int middle, int high) {

		  try{
		  FileOutputStream file = new FileOutputStream("Sorted file");
	    // Copy both parts into the temp array
	    for (int i = low; i <= high; i++) {
	      temp[i] = arraylist[i];
	    }

	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    // Copy the smallest values from either the left or the right side back
	    // to the original array
	    while (i <= middle && j <= high) {
	      if (temp[i] <= temp[j]) {
	        arraylist[k] = temp[i];
	        i++;
	      } else {
	        arraylist[k] = temp[j];
	        j++;
	      }
	      k++;
	    }
	    // Copy the rest of the left side of the array into the target array
	    while (i <= middle) {
	      arraylist[k] = temp[i];
	      k++;
	      i++;
	    }
	    for(int  i1=0;i1<arraylist.length;i1++)
			file.write(arraylist[i1]);
		file.close();

	    
	    
		  }catch(IOException msg)
			{
				System.out.println("Error "+ msg.toString());
			}
	    
	  }
	
	
	
	
	
	
	public static void main(String args[])
	{
		ReadFile f=new ReadFile();
		int array[]=new int[20];
		int ep;
		do{
			
			 ep=options();
			switch(ep)
			{
			case 1:
				System.out.print("Δωσε ονομα αρχειου για δημιουργια : ");
				String name=UserInput.getString();
				insert(name);
				break;
			case 2:
				System.out.print("Δωσε ονομα αρχειου για εμφανιση : ");
				name=UserInput.getString();
				readf(name);
				break;
			case 3:
				System.out.print("Δωσε ονομα 1ου αρχειου : ");
				name=UserInput.getString();
				System.out.print("Δωσε ονομα 2ου αρχειου : ");
				String name2=UserInput.getString();
				sort( name, name2,array);
				f.sortr(array);
				break;
			case 4:
				System.out.print("Τελος προγραμματος!");
				break;
			default:	
				System.out.print("\nΔωσε μια διαθεσιμη επιλογη\n\n");
			}
			
			
			
		}while(ep!=4);
		
		
		

		
		
	
	}
}

	
		
	
































		
