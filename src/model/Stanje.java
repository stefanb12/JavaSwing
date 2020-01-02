package model;

public enum Stanje {
	B("Budzet"), 
	S("Samofinansiranje");
	
	public final String name;
	
	private Stanje(String name){
		this.name = name;
	}
	
}
