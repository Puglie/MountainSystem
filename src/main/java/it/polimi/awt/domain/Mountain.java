package it.polimi.awt.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mountain")
public class Mountain {
	
	@Id private String id;
	private String name;
	private String elevation;
	//private String location;
	private String prom;
	private String latitude_decimal;
	private String longitude_decimal;
	private String icon;
	private String latitude;
	private String longitude;
	
	
	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getProm() {
		return prom;
	}

	public void setProm(String prom) {
		this.prom = prom;
	}

	public String getLatitude_decimal() {
		return latitude_decimal;
	}

	public void setLatitude_decimal(String latitude_decimal) {
		this.latitude_decimal = latitude_decimal;
	}

	public String getLongitude_decimal() {
		return longitude_decimal;
	}

	public void setLongitude_decimal(String longitude_decimal) {
		this.longitude_decimal = longitude_decimal;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
/*	@Override
	public String toString() {
		return "Research [name=" + name + ", location=" + location + "]";
	}*/
	public void setName(String name) {
		this.name = name;
	}
	/*public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}*/
	
	

}
