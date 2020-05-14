package com.tokenitos.superlist;

public class Articulo
{
	private final String articulo;
	private final int cantidad;

	public Articulo(String articulo, int cantidad)
	{
		this.articulo=articulo;
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

	public boolean equals(Articulo art){
		if(this.articulo.trim().equalsIgnoreCase(art.getArticulo())){
			return true;
		}
		return false;
	}

	@Override
	public String toString(){
		return "Articulo=" + articulo + ", cantidad=" + cantidad;
	}

}

