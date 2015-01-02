class PintxoPote {

	private Pintxo pintxo;
	private Pote pote;
	private double precio;

	//metodo getter/setter
	public void setPintxo (Pintxo pintxo) {

		this.pintxo = pintxo;
	}

	public Pintxo getPintxo () {

		return this.pintxo;
	}

	public void setPote (Pote pote) {

		this.pote = pote;
	}

	public Pote getPote () {

		return this.pote;
	}

	// Recogemos el id de pintxo y el de pote
	public void setPrecio (int pi, int po) {

		// Comprobamos si el id de pintxo y pote es 1, en caso de serlo, se le asigna a "precio" el valor 1.5
		if (pi == 1 && po == 1) {

			this.precio = 1.5;
		}
		// Comprobamos si el id de pintxo y pote son distintos, en caso de serlo, se le asigna a "precio" el valor 2
		else if ((pi == 1 && po == 2) || (pi == 2 && po == 1)) {

			this.precio = 2;
		}
		// Comprobamos si el id de pintxo y pote es 2, en caso de serlo, se le asigna a "precio" el valor 2.5
		else if (pi == 2 && po == 2) {

			this.precio = 2.5;
		}
	}

	public Double getPrecio () {

		return this.precio;
	}
} 