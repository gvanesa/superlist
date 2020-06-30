package com.tokenitos.superlist;

import java.util.Objects;

public class Articulo
{
	private String articulo;
	private int cantidad;

	public Articulo(String articulo, int cantidad)
	{
		this.articulo=articulo;
		this.cantidad=cantidad;
	}

	public void setCantidad(int cantidad)
	{
		this.cantidad=cantidad;
	}

	public String getArticulo()
	{
		return articulo;
	}

	public int getCantidad()
	{
		return cantidad;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Articulo articulo1 = (Articulo) o;
		return cantidad == articulo1.cantidad &&
				Objects.equals(articulo, articulo1.articulo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(articulo, cantidad);
	}

	public boolean equals(Articulo art){
		return this.articulo.trim().equalsIgnoreCase(art.getArticulo());
	}


	public String toString(){
		return '\t'+"Artículo: " + articulo + '\t'+'\t'+"Cantidad: " + cantidad;
	}

	/*public String toString(){
		return getArticulo() + "," + getCantidad();
	}*/


	public String toPrintResumido(){
		return articulo+";"+cantidad+ '\n' ;
	}

	public void setArticulo(String s) {
		this.articulo = s;
	}


	//public String toString() {return getArticulo() + ", " + getCantidad();}






}

