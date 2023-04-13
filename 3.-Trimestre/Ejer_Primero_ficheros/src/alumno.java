import java.io.*;

public class alumno {
	private expediente n_expediente;
	private String nombre;
	private double notas[];
	
	alumno(File f) throws NumberFormatException, IOException
	{
		n_expediente=new expediente(f);
		Lecturas l= new Lecturas();
		nombre=l.pedirCadena("el nombre del alumno: ");
		notas=new double[3];
		for(int i=0;i<notas.length;i++)
			notas[i]=l.pedirReal("la nota "+(i+1)+" del alumno "+nombre+": ", 0, 10);
	}

	public expediente getN_expediente() {
		return n_expediente;
	}

	public void setN_expediente(expediente n_expediente) {
		this.n_expediente = n_expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
	public double mediaNota()
	{
		double media=0;
		for(int i=0;i<notas.length;i++)
			media+=notas[i];
		return media/notas.length;
	}
	
	public String notasMostrar()
	{
		String notase="\n";
		for(int i=0;i<notas.length;i++)
			notase+="\t"+notas[i]+"\n";
		return notase;
	}
	
	public String datos()
	{
		return "NUMERO DE EXPEDIENTE: "+getN_expediente().getExpediente()+"\n"
				+ "NOMBRE: "+nombre+"\n"
				+ "NOTAS: "+notasMostrar();
	}
	public String datosNotas()
	{
		return "Nombre: "+nombre+" \n\tNota media: "+mediaNota();
	}
	
	
}
