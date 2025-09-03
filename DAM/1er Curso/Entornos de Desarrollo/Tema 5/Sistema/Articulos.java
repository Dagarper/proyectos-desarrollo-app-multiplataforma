package Sistema;

public class Articulos {

	private string Nombre;
	private string Descripcion;
	private string Material;
	private string Color;
	private double Precio;
	private int Stock;
	private string Tipo;

	public string getNombre() {
		return this.Nombre;
	}

	public void setNombre(string Nombre) {
		this.Nombre = Nombre;
	}

	public string getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(string Descripcion) {
		this.Descripcion = Descripcion;
	}

	public string getMaterial() {
		return this.Material;
	}

	public void setMaterial(string Material) {
		this.Material = Material;
	}

	public string getColor() {
		return this.Color;
	}

	public void setColor(string Color) {
		this.Color = Color;
	}

	public double getPrecio() {
		return this.Precio;
	}

	public void setPrecio(double Precio) {
		this.Precio = Precio;
	}

	public int getStock() {
		return this.Stock;
	}

	public void setStock(int Stock) {
		this.Stock = Stock;
	}

	/**
	 * 
	 * @param numero
	 */
	public void modificarStock(int numero) {
		// TODO - implement Articulos.modificarStock
		throw new UnsupportedOperationException();
	}

}