package com.sidia.provarest.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Ratings")
public class Ratings implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Title title;

	private float averageRating;

	private Integer numVotes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public Integer getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(Integer numVotes) {
		this.numVotes = numVotes;
	}

	public Ratings() {
	}

	public Ratings(String tconst, float averageRating, Integer numVotes) {
		this.title = new Title(tconst);
		this.averageRating = averageRating;
		this.numVotes = numVotes;
	}

	public String toString() {

		return "\n id:" + id + "\n tconst:" + title.getTconst() + "\n averageRating:" + averageRating + "\n numVotes:"
				+ numVotes;
	}

}