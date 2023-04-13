import java.io.*;

public class Lecturas {
	private static BufferedReader lector=new BufferedReader(new InputStreamReader(System.in));
	
	public int pedirEntero(String cad, int li,int ls) throws NumberFormatException, IOException
	{
		int n=0;
		boolean ok;
		do {ok=true;
			try{System.out.println("Introduzca "+cad + " entre "+li + " y " + ls);
			    n=Integer.parseInt(lector.readLine());
			   }
			catch(NumberFormatException e)
			{System.out.println("El dato debe ser numerico");
			ok=false;}
		}while(ok==false || n<li || n>ls);
		return n;
	}
	
	public double pedirReal(String cad, int li, int ls) throws NumberFormatException, IOException
	{
		double n=0;
		boolean ok;
		do {ok=true;
			try{System.out.println("Introduzca "+cad);
			    n=Double.parseDouble(lector.readLine());
			   }
			catch(NumberFormatException e)
			{System.out.println("El dato debe ser numerico");
			ok=false;}
		}while(ok==false || n<li || n>ls);
		return n;
	}
	
	public String pedirCadena(String cad) throws IOException
	{
		String c;
		do {System.out.println("Introduzca "+cad);
		    c=lector.readLine();
		   }while(c.isEmpty());
		return c;
	}
	
	private boolean buscar(String letras, char c)
	{	boolean enc=false;
		for(int i=0;i<letras.length()&& enc==false;i++)
		{
			if(letras.charAt(i)==c)
				return true;
		}
		return enc;
	}
	
	public char pedirLetra(String cad) throws IOException
	{
		String letras="ABCDEFGHIJKLMN�OPQRSTUVWXYZ";
		String dato;
		do {System.out.println("Introduzca "+cad);
		    dato=lector.readLine().toUpperCase(); 
		   }while(dato.isEmpty() || dato.length()!=1 || !buscar(letras,dato.charAt(0)));
		return dato.charAt(0);
	}
}

