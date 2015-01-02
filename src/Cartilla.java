class Cartilla {

	private boolean[] sellos = new boolean [10]; //array de 10, para guardar los sellos, cada, item sera un bar
	private Double descuento;

	//metodo sellar
	public void setSellar (boolean[] sello) {

		this.sellos = sello;
	}

	public boolean[] getSellar () {

		return sellos;
	}

	// Forma para poner valor "true" a través del número de bares
	/*public void setSello (int numbares) {

		for (int a=0; a<numbares; a++) {

			sellos[a] = true;
		}
	}*/

	//metodo devolver dto correspondiente
	// Recogemos el precio en conjunto del pintxo y del pote
	public void setDescuento (Double precio) {

		// Variable para saber cuantos "true" hay en el array
		int s = 0;

		// Recorremos el array
		for (int a=0; a<sellos.length; a++) {

			// Si encuentra una posición con el valor "true"
			if (sellos[a] == true) {

				// Guardamos en "s" la cantidad de veces que hay "true" en el array
				s = s+1;
			}
		}

		// Si hay menos de 6 "true", asignamos a "descuento" el descuento 0
		if (s < 6) {

			this.descuento = precio - (precio * 0) / 100;
		}
		// Si hay mas o igual de 6 y menos de 8 "true", asignamos a "descuento" el descuento 25
		else if (s >= 6 && s < 8) {

			this.descuento = precio - (precio * 25) / 100;
		}
		// Si hay mas o igual de 8 y menos de 10 "true", asignamos a "descuento" el descuento 50
		else if (s >= 8 && s < 10) {

			this.descuento = precio - (precio * 5) / 100;
		}
		// Si hay mas o igual de 10 "true", asignamos a "descuento" el descuento 100 (gratis)
		else if (s >= 10) {

			this.descuento = precio - (precio * 100) / 100;
		}
	}

	public Double getDescuento () {

		return descuento;
	}
}