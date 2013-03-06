package com.losgangnamstyle.proyectoesiimi;

public class Persona {
	private int id1,id2;
	private String pasw1,pasw2;
	
	public void Presona(){
		this.id1=12345;
		this.id2=54321;
		this.pasw1="hola123";
		this.pasw2="hola321";
	}
	
	public int getId1(){
		return this.id1;
	}
	
	public int getId2(){
		return this.id2;
	}
	
	public String getPasw1(){
		return this.pasw1;
	}
	
	public String getPasw2(){
		return this.pasw2;
	}
}
