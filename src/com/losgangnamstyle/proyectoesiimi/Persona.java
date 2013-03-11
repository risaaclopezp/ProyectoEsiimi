package com.losgangnamstyle.proyectoesiimi;

public class Persona {
	private int id1,id2;
	private int pasw1,pasw2;
	
	public Persona(){
		this.id1=12345;
		this.id2=54321;
		this.pasw1=10190;
		this.pasw2=121291;
	}
	
	public int getId1(){
		return this.id1;
	}
	
	public int getId2(){
		return this.id2;
	}
	
	public int getPasw1(){
		return this.pasw1;
	}
	
	public int getPasw2(){
		return this.pasw2;
	}
}