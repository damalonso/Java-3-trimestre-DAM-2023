import java.io.*;

public class expediente {
	private int expediente;
	
	expediente(File f) throws NumberFormatException, IOException
	{
		Lecturas l= new Lecturas();
		do {
			do {
				expediente=l.pedirEntero("el expediente del alumno: ", 0, 9999);
			}while(comprobarNum(expediente)!=4);
		}while(comprobarExpediente(f, expediente)==true);
	}
	
	private boolean comprobarExpediente(File f, int exp) throws IOException
	{
		boolean enc=false;
		if(f.exists())
		{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			linea=br.readLine();
			
			while(linea!=null && enc==false)
			{
				if(linea.startsWith("NUMERO"))
				{
					int nume=Integer.parseInt(linea.substring(linea.length()-4, linea.length()));
					if(nume==exp)
						enc=true;
				}
				linea=br.readLine();
			}
			

			br.close();
			fr.close();
		}
		return enc;
	}
	
	public int comprobarNum(int num) {
		int n=num, cont=0;
		while(n!=0)
		{
			n=n/10;
			cont++;
		}
		return cont;
	}

	public int getExpediente() {
		return expediente;
	}

	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}
	
	
}
