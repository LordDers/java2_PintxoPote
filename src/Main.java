import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main (String[] args) {

		Scanner sc = new Scanner (System.in);

		ArrayList <Pintxo> arrayPintxo = new ArrayList <Pintxo> ();

		try {

			BufferedReader br = new BufferedReader (new FileReader("Pintxos.txt"));

			String linea = br.readLine();

			String [] camposSeparados = null;
			String [] camposSeparadosIngredientes = null;

			while (linea != null) {

				Pintxo obPintxo = new Pintxo ();

				camposSeparados = linea.split("#");
				camposSeparadosIngredientes = camposSeparados[2].split(",");

				obPintxo.setId(Integer.parseInt(camposSeparados[0]));
				obPintxo.setNombre(camposSeparados[1]);
				obPintxo.setIngredientes(camposSeparadosIngredientes);
				obPintxo.setTipo(Integer.parseInt(camposSeparados[3]));

				//System.out.println(camposSeparados[0]);
				//System.out.println(camposSeparados[1]);
				//System.out.println(camposSeparados[2]);
				//System.out.println(camposSeparados[3]);

				//for (int a=0; a<camposSeparadosIngredientes.length; a++) {

					//System.out.println(camposSeparadosIngredientes[a]);
				//}

				arrayPintxo.add(obPintxo);

				linea = br.readLine();
			}
		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}

		ArrayList <Pote> arrayPote = new ArrayList <Pote> ();

		try {

			BufferedReader br = new BufferedReader (new FileReader("Potes.txt"));

			String linea = br.readLine();

			String [] camposSeparados = null;

			while (linea != null) {

				Pote obPote = new Pote ();

				camposSeparados = linea.split(",");

				obPote.setId(Integer.parseInt(camposSeparados[0]));
				obPote.setNombre(camposSeparados[1]);
				obPote.setTipo(Integer.parseInt(camposSeparados[2]));

				arrayPote.add(obPote);

				linea = br.readLine();
			}

		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}

		int opcion;

		do {

			System.out.println(" MENU:");
			System.out.println("1. Cargar Pintxos");
			System.out.println("2. Cargar Potes");
			System.out.println("3. Cargar Bares");
			System.out.println("4. Asignar Pintxos y Potes a cada bar");
			System.out.println("5. PintxoPote");
			System.out.println("0. SALIR");

			System.out.print("\nIntroduce una opcion: ");
			opcion = sc.nextInt();

			switch (opcion) {

				case 1: {

					// Lectura desde Main.java
					/*System.out.println("PINTXOS");
					for (int pin=0; pin<arrayPintxo.size(); pin++) {

						System.out.println("--- Pintxo " + (pin+1) + " ---");
						System.out.println("Id: " + arrayPintxo.get(pin).getId());
						System.out.println("Nombre: " + arrayPintxo.get(pin).getNombre());

						for (int piningre=0; piningre<arrayPintxo.get(pin).getIngredientes().length; piningre++) {

							System.out.println("Ingrediente " +  (piningre+1) + ": " + arrayPintxo.get(pin).getIngredientes()[piningre]);
						}

						if (arrayPintxo.get(pin).getTipo() == 1) {
							System.out.println("Tipo: Básico");
						}
						else if (arrayPintxo.get(pin).getTipo() == 2) {
							System.out.println("Tipo: Selecto");
						}
						System.out.println();
					}

					System.out.println();*/

					// Lectura desde Pintxo.java
					Pintxo obPintxo = new Pintxo ();
					obPintxo.mostrarPintxos();
					break;
				}

				case 2: {

					Pote obPote = new Pote ();
					obPote.mostrarPotes();
					break;
				}

				case 3: {

					Bar obBar = new Bar ();
					obBar.mostrarBares();
					break;
				}

				case 4: {

					System.out.print("¿Cuántos amigos sois? ");
					int amigos = sc.nextInt();

					Bar obBar = new Bar ();
					obBar.mostrarBares();

					System.out.print("¿En qué bar tomaréis los pintxos (id)? ");
					int bar = sc.nextInt();

					/*System.out.print("¿En cuántos bares tomaréis los pintxos?");
					int cbar = sc.nextInt();*/

					Pintxo obPintxo = new Pintxo ();
					obPintxo.mostrarPintxos();

					System.out.print("¿Qué pintxo deseas (id)? ");
					int pintxo = sc.nextInt();

					int pi = 0;
					String piNombre = null;

					for (int pin=0; pin<arrayPintxo.size(); pin++) {

						if (pintxo == arrayPintxo.get(pin).getId()) {

							pi = arrayPintxo.get(pin).getTipo();
							piNombre = arrayPintxo.get(pin).getNombre();
						}
					}

					Pote obPote = new Pote ();
					obPote.mostrarPotes();

					System.out.print("¿Qué pote deseas (id)? ");
					int pote = sc.nextInt();

					int po = 0;
					String poNombre = null;

					for (int pot=0; pot<arrayPote.size(); pot++) {

						if (pote == arrayPote.get(pot).getId()) {

							po = arrayPote.get(pot).getTipo();
							poNombre = arrayPote.get(pot).getNombre();
						}
					}

					PintxoPote pp = new PintxoPote ();
					pp.setPrecio(pi, po);

					Double precio = pp.getPrecio();

					Cartilla cartilla = new Cartilla ();
					cartilla.setDescuento(precio);
					//cartilla.setSello(cbar);
					Double descuento = cartilla.getDescuento();

					Cuenta cuenta = new Cuenta ();
					cuenta.imprimir(piNombre, poNombre, precio, descuento);

					break;
				}

				case 5: {

					System.out.println("Cinco");
					break;
				}

				default: {

					System.out.println("No has seleccionado una opción válida.");
					System.out.println();
				}
			}

		} while (opcion != 0);
			System.out.println("Has decidido salir.");
	}
}