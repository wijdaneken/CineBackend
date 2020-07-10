package org.sid.cinema.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateProjection;
	private double prix;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	@ToString.Exclude
	private Salle salle;
	@ManyToOne
	@ToString.Exclude
	private Film film;
	@OneToMany(mappedBy= "projection")
	@JsonProperty(access = Access.WRITE_ONLY)
	@ToString.Exclude
	private Collection<Ticket> tickets;
	@ManyToOne 
	private Seance seance;
}
