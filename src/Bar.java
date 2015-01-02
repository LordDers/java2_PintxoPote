import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class Bar {

	private int id;
	private String nombre;
	private String direccion;
	private ArrayList <Pintxo> pintxos;
	private ArrayList <Pote> potes;

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

	public void setDireccion (String dir) {

		this.direccion = dir;
	}

	public String getDireccion () {

		return direccion;
	}

	public void setPintxos (ArrayList <Pintxo> pintxo) {

		this.pintxos = pintxo;
	}

	public ArrayList <Pintxo> getPintxos () {

			return pintxos;
	}

	public void setPote (ArrayList <Pote> pote) {

		this.potes = pote;
	}

	public ArrayList <Pote> getPote () {

		return potes;
	}

	public void mostrarBares () {

		ArrayList <Bar> arrayBares = new ArrayList <Bar> ();
		ArrayList <Pintxo> arrayPintxo = new ArrayList <Pintxo> ();

		// Leer "Bares.txt"
		try {

			BufferedReader br = new BufferedReader (new FileReader("Bares.txt"));

			String linea = br.readLine();

			// Creamos arrays de tipo String para separar los campos del fichero
			String [] camposSeparados = null;
			String [] camposBar = null;
			String [] camposPintxo = null;
			String [] camposPintxoIngredientes = null;

			while (linea != null) {

				// Creamos los objetos que participan en el fichero "Bares.txt"
				Bar obBar = new Bar ();

				// Separamos las lineas obtenidas (linea) mediante "#" y lo guardamos en "camposSeparados"
				camposSeparados = linea.split("#");
				// Separamos las lineas obtenidas (camposSeparados) mediante "," y lo guardamos en "camposBar"
				camposBar = camposSeparados[0].split(",");

				// Introducimos los valores capturados del fichero en los objetos creados
				obBar.setId(Integer.parseInt(camposBar[0]));
				obBar.setNombre(camposBar[1]);
				obBar.setDireccion(camposBar[2]);

				// Creamos los objetos que participan en el fichero "Bares.txt"
				Pintxo obPintxo = new Pintxo ();

				// Separamos las lineas obtenidas (camposSeparados) mediante ";" y lo guardamos en "camposPintxo"
				camposPintxo = camposSeparados[1].split(";");
				// Separamos las lineas obtenidas (camposPintxo) mediante "," y lo guardamos en "camposPintxoIngredientes"
				camposPintxoIngredientes = camposPintxo[2].split("\\*");

				// Introducimos los valores capturados del fichero en los objetos creados
				obPintxo.setId(Integer.parseInt(camposPintxo[0]));
				obPintxo.setNombre(camposPintxo[1]);
				obPintxo.setIngredientes(camposPintxoIngredientes);
				obPintxo.setTipo(Integer.parseInt(camposPintxo[3]));

				// Añadimos el objeto "obPintxo" al ArrayList "arrayPintxo"
				arrayPintxo.add(obPintxo);
				// Introducimos los valores de "arrayPintxo" en "setPintxos"
				obBar.setPintxos(arrayPintxo);

				// Añadimos el objeto "obBar" al ArrayList "arrayBares"
				arrayBares.add(obBar);

				linea = br.readLine();
			}

		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}

		// Mostramos los bares leídos
		System.out.println("\n------ BARES ------\n");
		for (int po=0; po<arrayBares.size(); po++) {

			System.out.println("  --- Bar " + (po+1) + " ---");
			System.out.println("Id: " + arrayBares.get(po).getId());
			System.out.println("Nombre: " + arrayBares.get(po).getNombre());
			System.out.println("Dirección: " + arrayBares.get(po).getDireccion());

			/*for (int b=0; b<arrayPintxo.size(); b++) {

				System.out.println("    ---   Pintxo " + (b+1) + " Bar " + (po+1) + " ---");
				System.out.println("       Id: " + arrayPintxo.get(po).getId());
				System.out.println("       Nombre: " + arrayPintxo.get(po).getNombre());

				for (int i=0; i<arrayPintxo.get(b).getIngredientes().length; i++) {

					System.out.println("       Ingrediente " + (i+1) + ": " + arrayPintxo.get(b).getIngredientes()[i]);
				}
				//break;
			}*/

			System.out.println();
		}

		System.out.println();
	}
}