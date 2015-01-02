import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class Pote {

	private int id;
	private String nombre;
	private int tipo; //1: Basico 2: Selecto

	//1: Agua, zurito, vino del año
	//2: Caña, refrescos, vino crianza

	public void setId (int id) {

		this.id = id;
	}

	public int getId () {

		return id;
	}

	public void setNombre (String nombre) {

		this.nombre = nombre;
	}

	public String getNombre () {

		return nombre;
	}

	public void setTipo (int tipo) {

		this.tipo = tipo;
	}

	public int getTipo () {

		return tipo;
	}

	public void mostrarPotes () {

		ArrayList <Pote> arrayPote = new ArrayList <Pote> ();

		// Leer "Potes.txt"
		try {

			BufferedReader br = new BufferedReader (new FileReader("Potes.txt"));

			String linea = br.readLine();

			// Creamos un array de tipo String para separar los campos del fichero
			String [] camposSeparados = null;

			while (linea != null) {

				// Creamos los objetos que participan en el fichero "Potes.txt"
				Pote obPote = new Pote ();

				// Separamos las lineas obtenidas (linea) mediante "," y lo guardamos en "camposSeparados"
				camposSeparados = linea.split(",");

				// Introducimos los valores capturados del fichero en los objetos creados
				obPote.setId(Integer.parseInt(camposSeparados[0]));
				obPote.setNombre(camposSeparados[1]);
				obPote.setTipo(Integer.parseInt(camposSeparados[2]));

				// Añadimos el objeto "obPote" al ArrayList "arrayPote"
				arrayPote.add(obPote);

				linea = br.readLine();
			}

		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}

		// Mostramos los potes leídos
		System.out.println("\n------ POTES ------\n");
		for (int po=0; po<arrayPote.size(); po++) {

			System.out.println("  --- Pote " + (po+1) + " ---");
			System.out.println("Id: " + arrayPote.get(po).getId());
			System.out.println("Nombre: " + arrayPote.get(po).getNombre());

			// Comprobamos el tipo de pote, e indicamos si es básico o selecto
			if (arrayPote.get(po).getTipo() == 1) {
				System.out.println("Tipo: Básico");
			}
			else if (arrayPote.get(po).getTipo() == 2) {
				System.out.println("Tipo: Selecto");
			}
			System.out.println();
		}

		System.out.println();
	}
}