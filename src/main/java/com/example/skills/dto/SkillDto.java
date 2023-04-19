package com.example.skills.dto;

import com.example.skills.entity.Icon;
import jakarta.persistence.*;
import lombok.Value;

@Value
public class SkillDto {

	Long id;

	String name;

	String description;

	IconDto icon;
}
