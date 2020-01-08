package br.com.stoom.responses.apigeocoding;

import java.util.List;

public class ApiGeocodingResponses {
	
	private List<Results> results;

    private String status;

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
   
}
