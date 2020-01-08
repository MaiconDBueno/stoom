package br.com.stoom.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.stoom.model.Location;
import br.com.stoom.responses.apigeocoding.ApiGeocodingResponses;
import br.com.stoom.util.MapperObjetUtil;

@Service
public class GeocodingService {
	
	private RestTemplate restTemplate;
	
	@Autowired
	private MapperObjetUtil mapperObjetUtil;
	
	private static final String API_GOOGLE = "https://maps.googleapis.com/maps"
			+ "/api/geocode/json?address={streetName},{number},{city},{zipcode}\n" + 
			"&key={key}";
	
	@Value("${api.key}")
	private String apiKey;

	 
	public ApiGeocodingResponses apiConsumer(Location location) {
		
		Map<String, Object> params = new HashMap<String, Object>();
	    params.put("streetName", location.getStreetName());
	    params.put("number", location.getNumber());
	    params.put("city", location.getCity());
	    params.put("zipcode", location.getZipcode());
	    params.put("key", apiKey);
	    
	    restTemplate = new RestTemplate();
	    
	    String result = restTemplate.getForObject(API_GOOGLE, String.class, params);
	    
	    ApiGeocodingResponses apiGeocodingResponses =  mapperObjetUtil.doMapperObjet(result, ApiGeocodingResponses.class); 
	    
	    restTemplate = null;
	   
		return apiGeocodingResponses;
		
	}
	
}
