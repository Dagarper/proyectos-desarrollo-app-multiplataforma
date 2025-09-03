package Sistema;

import Usuarios.*;

public class Pedido {

	private Date Fecha_Realizacion;
	private double Precio_Total;
	private int Cantidad;
	private Estado_Pedido Estado;

	public Date getFecha_Realizacion() {
		// TODO - implement Pedido.getFecha_Realizacion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Fecha_Realizacion
	 */
	public void setFecha_Realizacion(Date Fecha_Realizacion) {
		// TODO - implement Pedido.setFecha_Realizacion
		throw new UnsupportedOperationException();
	}

	public double getPrecio_Total() {
		// TODO - implement Pedido.getPrecio_Total
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Precio_Total
	 */
	public void setPrecio_Total(double Precio_Total) {
		// TODO - implement Pedido.setPrecio_Total
		throw new UnsupportedOperationException();
	}

	public Socio getSocio() {
		// TODO - implement Pedido.getSocio
		throw new UnsupportedOperationException();
	}

	public Estado_Pedido getEstado() {
		// TODO - implement Pedido.getEstado
		throw new UnsupportedOperationException();
	}

	public double calcularPrecio() {

	}

	/**
	 * 
	 * @param Estado
	 */
	public void setEstado(Estado_Pedido Estado) {
		// TODO - implement Pedido.setEstado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param articulo
	 * @param numero
	 */
	public boolean incluyeArticulo(Articulos articulo, int numero) {

	}

	public void verDetalle() {
		// TODO - implement Pedido.verDetalle
		throw new UnsupportedOperationException();
	}

	public boolean cobrar() {
		// TODO - implement Pedido.cobrar
		throw new UnsupportedOperationException();
	}

}