package SUB2;

import java.util.Calendar;

public class Persoana {
	private String nume;
	private String cnp;
	public Persoana(String n, String cnp)
	{
		this.nume = n;
		this.cnp = cnp;
	}
	public int Varsta()
	{
		String data = this.cnp.substring(1, 7);
		Calendar data_curenta = Calendar.getInstance();
		Calendar data_cnp = Calendar.getInstance();
		data = "19" + data.substring(0, 2);
		data_cnp.set(Calendar.YEAR, Integer.parseInt(data));
		int varsta = data_curenta.get(Calendar.YEAR) - data_cnp.get(Calendar.YEAR);		
		return varsta;
	}
	
	public String numeGet()
	{
		return this.nume;
	}
	
	public String cnpGet()
	{
		return this.cnp;
	}
	
	public String toString()
	{
		return this.nume + " " + this.cnp + " " + this.Varsta() + "\n";
	}
}
