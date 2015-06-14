package it.polimi.awt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "savedphoto")
public class SavedPhoto {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String url;
	private String smallurl;
	@ManyToOne
	@JoinColumn(name="idmountain", referencedColumnName = "id")
	private Mountain mountain;
	
	
	public String getSmallurl() {
		return smallurl;
	}

	public void setSmallurl(String smallurl) {
		this.smallurl = smallurl;
	}

	public Mountain getMountain() {
		return mountain;
	}

	public void setMountain(Mountain mountain) {
		this.mountain = mountain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
