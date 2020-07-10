package org.sid.cinema.dao;

import org.sid.cinema.entities.Categorie;
import org.sid.cinema.entities.Film;
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
@Qualifier("CategorieRepository")
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	public Page<Categorie> findByNameContains(String mc, Pageable pageable);

}
