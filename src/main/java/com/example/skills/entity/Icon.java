package com.example.skills.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "icons")
@Setter
@NoArgsConstructor
@Getter
public class Icon {

	@Id
	private Long id;

	private String image;

	private String name;

	@MapsId
	@OneToOne()
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("skill")
	private Skill skill;

}
