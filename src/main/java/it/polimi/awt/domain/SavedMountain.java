package it.polimi.awt.domain;

public class SavedMountain {
	
	private String id;
	private int latitude;
	private int longitude;
	private String name;
	private String url;
	private String isSelected;
	
	public SavedMountain(){
		isSelected="unchecked";
	}
	

	public void setSelected(String isSelected) {
		this.isSelected = isSelected;
	}



	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
