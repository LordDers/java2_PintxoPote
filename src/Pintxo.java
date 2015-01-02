import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class Pintxo {

	private int id;
	private String nombre;
	private String[] ingredientes;
	private int tipo; // 1: Basico 2:Selecto
	//1: Tortilla patata, ...
	//2: Foie,...

	//metodos getter/setter
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

	public void setIngredientes (String [] ingredientes) {

		this.ingredientes = ingredientes;
	}

	public String [] getIngredientes () {

		return ingredientes;
	}

	public void setTipo (int tipo) {

		this.tipo = tipo;
	}

	public int getTipo () {

		return tipo;
	}

	public void mostrarPintxos () {
	//public ArrayList<Pintxo> cargarPintxos (ArrayList<Pintxo> pintxo) {

		ArrayList <Pintxo> arrayPintxo = new ArrayList <Pintxo> ();

		// Leer "Pintxos.txt"
		try {

			BufferedReader br = new BufferedReader (new FileReader("Pintxos.txt"));

			String linea = br.readLine();

			// Creamos dos arrays de tipo String para separar los campos del fichero
			String [] camposSeparados = null;
			String [] camposSeparadosIngredientes = null;

			while (linea != null) {

				// Creamos los objetos que participan en el fichero "Pintxos.txt"
				Pintxo obPintxo = new Pintxo ();

				// Separamos las lineas obtenidas (linea) mediante "#" y lo guardamos en "camposSeparados"
				camposSeparados = linea.split("#");
				// Separamos las lineas obtenidas (camposSeparados) mediante "," y lo guardamos en "camposSeparadosIngredientes"
				camposSeparadosIngredientes = camposSeparados[2].split(",");

				// Introducimos los valores capturados del fichero en los objetos creados
				obPintxo.setId(Integer.parseInt(camposSeparados[0]));
				obPintxo.setNombre(camposSeparados[1]);
				obPintxo.setIngredientes(camposSeparadosIngredientes);
				obPintxo.setTipo(Integer.parseInt(camposSeparados[3]));

				// Añadimos el objeto "obPintxo" al ArrayList "arrayPintxo"
				arrayPintxo.add(obPintxo);

				linea = br.readLine();
			}

		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}

		// Mostramos los pintxos leídos
		System.out.println("\n------ PINTXOS ------\n");
		for (int pin=0; pin<arrayPintxo.size(); pin++) {

			System.out.println("  --- Pintxo " + (pin+1) + " ---");
			System.out.println("Id: " + arrayPintxo.get(pin).getId());
			System.out.println("Nombre: " + arrayPintxo.get(pin).getNombre());

			// Ingredientes
			for (int piningre=0; piningre<arrayPintxo.get(pin).getIngredientes().length; piningre++) {

				System.out.println("Ingrediente " +  (piningre+1) + ": " + arrayPintxo.get(pin).getIngredientes()[piningre]);
			}

			// Comprobamos el tipo de pintxo, e indicamos si es básico o selecto
			if (arrayPintxo.get(pin).getTipo() == 1) {
				System.out.println("Tipo: Básico");
			}
			else if (arrayPintxo.get(pin).getTipo() == 2) {
				System.out.println("Tipo: Selecto");
			}
			System.out.println();
		}

		System.out.println();
		// return pintxo;
	}
}