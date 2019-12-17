package SUB2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class MainApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Persoana> lista = new ArrayList<Persoana>();
		BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
		String line;
		line = flux_in.readLine();
		while(line != null)
		{
			String[] v_line = line.split(";");
			String data = v_line[1].substring(1, 7);
			try {
				for (char c : v_line[1].toCharArray())
				{
					if(!Character.isDigit(c))
						throw new CnpExceptie("Cnp nu e tot numar");
				}
				if(Integer.parseInt(v_line[1].substring(0, 1)) > 6)
					throw new CnpExceptie("Sex Incorect");
				if(Integer.parseInt(data.substring(2, 4)) > 12)
					throw new CnpExceptie("Luna > 12");
				if(Integer.parseInt(data.substring(4)) > 31)
					throw new CnpExceptie("Zi > 31");
				
			}
			catch(CnpExceptie e)
			{
				BufferedReader cons_in = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(e);
				System.out.println("Cnp nou: ");
				boolean ok = false;
				String new_cnp ="";
				String new_data = "";
				while(ok == false)
				{
					new_cnp = cons_in.readLine();
					new_data = new_cnp.substring(1, 7);
					ok = true;
					if(Integer.parseInt(new_cnp.substring(0, 1)) > 6)
						ok = false;
					if(Integer.parseInt(new_data.substring(2, 4)) > 12)
						ok = false;
					if(Integer.parseInt(new_data.substring(4)) > 31)
						ok = false;
					for (char c : new_cnp.toCharArray())
					{
						if(!Character.isDigit(c))
							{
							ok = false;
							break;
							}
					}
					
				}
				v_line[1] = new_cnp;
			}
			
			Persoana obj = new Persoana(v_line[0], v_line[1]);
			lista.add(obj);
			line = flux_in.readLine();
		}
		
		flux_in.close();
		BufferedWriter flux_out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
		for(Persoana obj : lista)
		{
			flux_out.write(obj.toString());
		}
		flux_out.close();		
	}

}
