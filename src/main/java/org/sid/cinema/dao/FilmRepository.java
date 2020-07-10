
package org.sid.cinema.dao;

import org.sid.cinema.entities.Film;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource

@CrossOrigin("*")

@Qualifier("FilmRepository")
public interface FilmRepository extends JpaRepository<Film, Long> { 
	 public Page<Film> findByTitreContains(String mc, Pageable pageable);
											 

}
