package br.com.stoom.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.stoom.model.Location;
import br.com.stoom.responses.Response;
import br.com.stoom.responses.ResponseData;
import br.com.stoom.service.LocationService;

@RestController
@RequestMapping("/api/")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	 
	@GetMapping("/v1/location/{id}") 
	public ResponseEntity<Response<Location>> locationFindBy(@PathVariable Long id) { 
		Response<Location> response = new Response<Location>();
		Location location = locationService.findById(id); 
		if(location == null) {
			return ResponseEntity.notFound().build();
		}
		response.setData(locationService.findById(id));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/v1/location") 
	public ResponseEntity<ResponseData<Location>> locationFindAll(){
		ResponseData<Location> response = new ResponseData<Location>();
		response.setData(locationService.findAll());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/v2/location") 
	public Page<Location> locationFindPage(Pageable pageable){ 
		return locationService.findPageLazy(pageable); 
	}
	
	
	@PostMapping("/v1/location")
	public ResponseEntity<Response<Location>> createLocation(@Valid @RequestBody Location location,
			BindingResult result) {
		
		Response<Location> response = new Response<Location>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		location.setCreationDate(new Date());
		Location savedLocation = locationService.save(location);
		response.setData(savedLocation);
		
		URI locationURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedLocation.getId()).toUri();
		
		return ResponseEntity.created(locationURI).build();
		
	}
	
	@PutMapping("/v1/location/{id}")
	public ResponseEntity<Response<Location>> updateLocation(@RequestBody Location location, 
			@PathVariable Long id) {
	
		Location updateLocation = locationService.findById(id);

		if(updateLocation == null) {
			return ResponseEntity.notFound().build();
		}
		
		location.setId(updateLocation.getId());
		location.setUpdateDate(new Date());
		locationService.save(location);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/v1/location/{id}") 
	public ResponseEntity<Response<Location>> deleteLocation(@PathVariable long id) { 
		
		Location location = locationService.findById(id); 
		if(location == null) {
			return ResponseEntity.notFound().build();
		}
		
		locationService.deleteById(location.getId());
		
		return ResponseEntity.ok().build();
	}

}
