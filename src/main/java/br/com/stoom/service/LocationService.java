package br.com.stoom.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.stoom.model.Location;
import br.com.stoom.repository.LocationRepository;
import br.com.stoom.responses.apigeocoding.ApiGeocodingResponses;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private GeocodingService geocodingService;

	public Location findById(Long id) {
		Optional<Location> obj = locationRepository.findById(id);
		return obj.orElse(null);
	}

	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	public Page<Location> findPageLazy(Pageable pageable) {
		return locationRepository.findAll(pageable);
	}
    
	@Transactional 
	public Location save(Location location) {
		if((location.getLatitude() == null) && (location.getLongitude() == null)){
			location  = this.addCoordinate(location);
		}
		return locationRepository.save(location);
	}

	public void deleteById(Long id) {
		locationRepository.deleteById(id);
	}
	
	public Location addCoordinate(Location location) {
		ApiGeocodingResponses api = geocodingService.apiConsumer(location);
		if(api != null) {
			location.setLatitude(api.getResults().get(0).getGeometry().getLocation().getLat());
			location.setLongitude(api.getResults().get(0).getGeometry().getLocation().getLng());
			return location;
		}
		return location;
	}
}
