import java.io.*;

public class ReadFile
{
	
	public static int options()
	{
		
		System.out.println("��������");
		System.out.println("1.���������� ������� ");
		System.out.println("2.�������� �������");
		System.out.println("3.�������� �����");
		System.out.println("4.����� ������������");
		System.out.print("���� ��� �������: ");
		
		return UserInput.getInteger();
		
	}
	
	
	
	
	public static void insert(String name)
	{
		
		try
		{
			FileWriter outStream = new FileWriter(name+".txt");
			BufferedWriter buffwrite = new  BufferedWriter(outStream);
			
			int number,i=0;
			String onoma,psifos;
			System.out.println("���� ������ ��������� : ");
			number=UserInput.getInteger();
			
			while(i<number)
			{
			
				System.out.println("���� ����� �������� : ");
				onoma=UserInput.getString();
				System.out.println("���� ���� �������� (���/���) : ");
				psifos=UserInput.getString();
				buffwrite.write(onoma);
				buffwrite.newLine();
				buffwrite.write(psifos);	
				buffwrite.newLine();
				i++;
					
				
			}
			buffwrite.close();
			System.out.println("File created!");
		}catch(IOException msg)
		{
			System.out.println("Error"+msg.toString());
			
		}
	}

	public static void readf(String name)
	{
		
		try
		{
			
			FileReader file = new FileReader(name+".txt");
			 BufferedReader buff = new  BufferedReader(file);
			boolean flag=false;
			
			
			while(!flag)
			{
				String line = buff.readLine();
				
				if(line == null)
					flag=true;
				else 
					System.out.println(line);
				
			}
			file.close();
			
		
		}catch(IOException msg)
		{
			System.out.println("Error "+ msg.toString());
		}
		
		
	}

	public static void convert(String name)
	{
		
		
		try
		{
			
		 FileReader file = new FileReader(name+".txt"); 
		 BufferedReader buff = new  BufferedReader(file);
		
		 FileWriter outStream = new FileWriter("BOULEUTES-NAI.txt");
		 FileWriter outStream1 = new FileWriter("BOULEUTES-OXI.txt");
		 BufferedWriter buffwrite = new  BufferedWriter(outStream);
		 BufferedWriter buffwrite1 = new  BufferedWriter(outStream1);
		


			boolean flag=false;
			int count=0,count1=0;
			while(!flag)
			{
				String line = buff.readLine();
				String line1 = buff.readLine();
				
				if(line == null || line1 == null)
					flag=true;
				else
				{
					
					if(line1.equals("���") || line1.equals("���") || line1.equals("NAI") || line1.equals("nai"))
					{	
						++count;
						buffwrite.write(count+" "+line);
						buffwrite.newLine();
					}
					else if(line1.equals("���") || line1.equals("���") ||line1.equals("OXI") || line1.equals("oxi"))
					{
						
						++count1;
						buffwrite1.write(count1+" "+line);
						buffwrite1.newLine();
					
					}
					
				}
					
				
			}
			file.close();
			buffwrite.close();
			buffwrite1.close();
			System.out.println("Done !");
			System.out.println("������ ��� :"+ count +" ������ ��� :"+ count1);
		}catch(IOException msg)
		{
			System.out.println("Error "+ msg.toString());
		}
		
		
	}

	 
	
	
	
	public static void main(String args[])
	{
	
		
		int ep;
		do{
			
			 ep=options();
			switch(ep)
			{
			case 1:
				System.out.print("���� ����� ������� ��� ���������� : ");
				String name=UserInput.getString();
				insert(name);
				break;
			case 2:
				System.out.print("���� ����� ������� ��� �������� : ");
				name=UserInput.getString();
				readf(name);
				break;
			case 3:
				System.out.print("���� ����� ������� ���������: ");
				name=UserInput.getString();
				convert(name);
				
				break;
			case 4:
				System.out.print("����� ������������!");
				break;
			default:	
				System.out.print("\n���� ��� ��������� �������\n\n");
			}
			
		
		}while(ep!=4);
		
		
		

		
		
	
	}
}

	
		
	
































		
