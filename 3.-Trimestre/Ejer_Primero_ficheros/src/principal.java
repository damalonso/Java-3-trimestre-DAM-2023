import java.io.*;

public class principal {

	public static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
	
	public static int menu() throws IOException
	{
		int opc=0;
		boolean ok;
		do {
			try {
				ok=true;
				System.out.println("1.- Añadir un nuevo alumno al fichero.\n"
						+ "2.- Calcular la media de cada alumno.\n"
						+ "3.- Generar otro fichero de texto con los nombres de todos los alumnos sin que haya ninguno repetido.\n"
						+ "4.- Salir.");
				opc=Integer.parseInt(lector.readLine());
			} 
			catch (NumberFormatException e) {
				ok=false;
				System.out.println("ERROR. Introduce datos numericos.");
			}
		}while(!ok || opc<1 || opc>4);
		return opc;
	}
	
	public static void añadirFichero(File f, alumno a) throws IOException
	{
		FileWriter fw= new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);
		
		String datos=a.datos();
		pw.println(datos);
		
		pw.close();
		fw.close();
	}
	
	public static void opcion1Mostrar(File f) throws IOException
	{
		if(!f.exists())
			System.out.println("El fichero no existe.");
		else {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			linea=br.readLine();
			while(linea!=null)
			{
				System.out.println(linea);
				linea=br.readLine();
			}
			br.close();
			fr.close();
		}
	}

	public static void opcion2Mostrar(File f) throws IOException
	{
		int cont=0;
		double suma;
		String nombre = null;
		if(!f.exists())
			System.out.println("El fichero no existe");
		else {
			FileReader fr= new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			linea=br.readLine();
			while(linea != null)
			{
				if(linea.startsWith("NOMBRE:"))
				{
					nombre= linea.substring(8);
				}
				if(linea.startsWith("NOTAS:"))
				{
					suma=0;
					while(cont!=3)
					{
						linea=br.readLine();
						suma+=Double.parseDouble(linea);
						cont++;
					}
					cont=0;
					System.out.println(nombre+" tiene una media de "+(suma/3));
				}
				else 
					linea=br.readLine();
			}
			
			br.close();
			fr.close();
		}
	}
	
	public static void opcion3(File alumnos, File alumnosExistentes) throws IOException
	{
		
		String linea, linea1, nom = null;
		boolean enc=false;

			if(alumnos.exists())
			{
				FileReader fr=new FileReader(alumnos);
				BufferedReader br = new BufferedReader(fr);
				linea=br.readLine();
				
				while(linea!=null)
				{
					if(linea.startsWith("NOMBRE:"))
					{
						nom = linea.substring(8);
					
						if(alumnosExistentes.exists())
						{
							enc=false;
							FileReader fr1=new FileReader(alumnosExistentes);
							BufferedReader br1 = new BufferedReader(fr1);
							linea1=br1.readLine();
							while(linea1!=null && enc==false)
							{
								if(nom.equalsIgnoreCase(linea1))
									enc=true;
								linea1=br1.readLine();
							}

							br1.close();
							fr1.close();
						}
						
						if(enc==false)
						{
							FileWriter fw= new FileWriter(alumnosExistentes, true);
							PrintWriter pw = new PrintWriter(fw);
							pw.println(nom);
							pw.close();
							fw.close();
						}
					}
					linea=br.readLine();
				}
				br.close();
				fr.close();
			}
			
		
	}
	
	public static void opcion3Mostrar(File alumnosExistentes) throws IOException
	{
		if(!alumnosExistentes.exists())
			System.out.println("El fichero no existe.");
		else {
			
			FileReader fr = new FileReader(alumnosExistentes);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			linea=br.readLine();
			while(linea!=null) {
				System.out.println(linea);
				linea=br.readLine();
			}
			br.close();
			fr.close();
		}
	}
	
	public static void main(String[] args) throws IOException {

		File alumnos = new File("datosAlumnos.txt");
		File alumnosExistentes= new File("alumnos.txt");
		
		int opc;
		do {
			opc=menu();
			switch(opc)
			{
			case 1:
				alumno a = new alumno(alumnos);
				añadirFichero(alumnos, a);
				opcion1Mostrar(alumnos);
				break;
			case 2:
				opcion2Mostrar(alumnos);
				break;
			case 3:
				opcion3(alumnos, alumnosExistentes);
				opcion3Mostrar(alumnosExistentes);
				break;
			}
			System.out.println();
		}while(opc!=4);
	}
}