package com.example.skills.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
@NoArgsConstructor
@Setter
@Getter
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;
	@OneToOne(mappedBy = "skill", cascade = CascadeType.ALL)

	private Icon icon;
}
