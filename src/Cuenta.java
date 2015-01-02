import java.util.ArrayList;

class Cuenta {

	private ArrayList <PintxoPote> cuenta;

	//metodos getter/setter
	public void setCuenta (ArrayList <PintxoPote> cuenta) {

		this.cuenta = cuenta;
	}

	public ArrayList <PintxoPote> getCuenta () {

		return cuenta;
	}

	// metodo imprimir en pantalla
	// Recogemos el nombre tanto del pintxo como del pote, el precio en conjunto del pintxo y del pote y el precio con el descuento calculado
	public void imprimir (String pintxo, String pote, Double precio, Double descuentoFinal) {

		System.out.println("\n--- Has Pedido ---");
		System.out.println("Pintxo: " + pintxo);
		System.out.println("Pote: " + pote);

		System.out.println("--- Cuenta ---");
		System.out.println("Precio: " + precio + "€");
		System.out.println("Precio Final: " + descuentoFinal + "€");
		System.out.println();
	}

}