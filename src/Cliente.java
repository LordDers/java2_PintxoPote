class Cliente {

	private int id;
	private String nombre; //Guardar Nombre Apellidos
	private Cartilla cartilla;

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

	public void setCartilla (Cartilla cartilla) {

		this.cartilla = cartilla;
	}

	public Cartilla getCartilla () {

		return cartilla;
	}
}