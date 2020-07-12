package com.tokenitos.superlist;

import java.util.Objects;

public class Precio
{
	private String articulo;
	private int valor;

	public Precio(String articulo, int cantidad)
	{
		this.articulo=articulo;
		this.valor=cantidad;
	}

	public void setCantidad(int valor)
	{
		this.valor=valor;
	}

	public String getArticulo()
	{
		return articulo;
	}

	public int getValor()
	{
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Precio articulo1 = (Precio) o;
		return valor == articulo1.valor &&
				Objects.equals(articulo, articulo1.articulo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(articulo, valor);
	}

	public boolean equals(Precio art){
		return this.articulo.trim().equalsIgnoreCase(art.getArticulo());
	}


	public String toString(){
		return '\t'+"Artículo: " + articulo + '\t'+'\t'+"Valor: " + valor;
	}

	/*public String toString(){
		return getArticulo() + "," + getCantidad();
	}*/


	public String toPrintResumido(){
		return articulo+";"+valor+ '\n' ;
	}

	public void setArticulo(String s) {
		this.articulo = s;
	}


	//public String toString() {return getArticulo() + ", " + getCantidad();}






}

