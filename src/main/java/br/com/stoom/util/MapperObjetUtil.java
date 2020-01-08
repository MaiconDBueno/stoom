package br.com.stoom.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.stoom.responses.apigeocoding.ApiGeocodingResponses;


@Component
public class MapperObjetUtil {
	
	public <T> T doMapperObjet(String json, Class<T> c) {
		return 	new Gson().fromJson(json, c); 
	}

}
