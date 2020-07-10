package org.sid.cinema.dao;

import org.sid.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")

public interface TicketRepository extends JpaRepository<Ticket, Long>{
	//public Page<Ticket> findByNameContains(String mc, Pageable pageable);
	//public Ticket findAll(String mc, Pageable pageable);

	//public Page<Ticket> findOneById(Long id, Pageable pageable);
}
