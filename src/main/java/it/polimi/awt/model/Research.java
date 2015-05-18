package it.polimi.awt.model;

public class Research {
	
	private String name;
	private String location;
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Research [name=" + name + ", location=" + location + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
