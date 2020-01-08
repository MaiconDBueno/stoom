package br.com.stoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.stoom.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> { 

}
