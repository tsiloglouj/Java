import java.io.*;

class UserInput { 

	static int getInteger() { 
		String line;
		InputStreamReader eisodosString=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(eisodosString);
		try{
			line=br.readLine();
			int i=Integer.parseInt(line);
			return i;
		}
		catch(Exception e) {
			return -1;
		}
	}
		static float getFloat() { 
			String line;
			InputStreamReader eisodosString=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(eisodosString);
			try{
				line=br.readLine();
				float i=Float.parseFloat(line);
				return i;
			}
			catch(Exception e) {
				return -1;
			}
		}

	static double getDouble() {
	
		InputStreamReader eisodosString=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(eisodosString);
		try{
			String line=br.readLine();
			double i=Double.parseDouble(line);
			return i;
			}
			catch(Exception e) {
				return -1;
			}
		}

	static String getString() {
		InputStreamReader eisodosString=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(eisodosString);
		try{
				String line=br.readLine();
				return line;
				}
				catch(Exception e) {
				return "-1";
			}
		}
	static char getChar(){
		InputStreamReader eisodosString=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(eisodosString);
		try{
			char line = (char)br.read();
			return line;
			}
			catch(Exception e){
			return ' ';
			
			
	}
		}
		
		
		
		
		
		
		
	}


