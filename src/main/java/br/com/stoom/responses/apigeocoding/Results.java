package br.com.stoom.responses.apigeocoding;

import java.util.List;

public class Results {
	
	private String formatted_address;

    private List<String> types;

    private Geometry geometry;

    private List<Address_components> address_components;

    private String place_id;

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public List<Address_components> getAddress_components() {
		return address_components;
	}

	public void setAddress_components(List<Address_components> address_components) {
		this.address_components = address_components;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
    
    


}
