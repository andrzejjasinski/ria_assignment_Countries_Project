package com.ait.countries;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

public class Countries {

    private int id;

    private String country;

    private String phone_prefix;

    private String flag;

    private String population;
    
    private String capital_city;
    
    private String geo_location;

    private String commentary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone_prefix() {
		return phone_prefix;
	}

	public void setPhone_prefix(String phone_prefix) {
		this.phone_prefix = phone_prefix;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getCapital_city() {
		return capital_city;
	}

	public void setCapital_city(String capital_city) {
		this.capital_city = capital_city;
	}

	public String getGeo_location() {
		return geo_location;
	}

	public void setGeo_location(String geo_location) {
		this.geo_location = geo_location;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

}

