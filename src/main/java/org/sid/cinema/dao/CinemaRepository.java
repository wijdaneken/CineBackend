package org.sid.cinema.dao;


import org.sid.cinema.entities.Cinema;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@Service
@CrossOrigin("*")

@Qualifier("CinemaRepository")
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	public Page<Cinema> findByNameContains(String mc, Pageable pageable);
	//public Cinema findOneById(Long id);

}


