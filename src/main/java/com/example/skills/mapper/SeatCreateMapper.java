package com.example.skills.mapper;

import com.example.skills.dto.SkillCreateDto;
import com.example.skills.entity.Icon;
import com.example.skills.entity.Skill;
import com.example.skills.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SeatCreateMapper implements Mapper<SkillCreateDto, Skill> {

	@Override
	public Skill map(SkillCreateDto object) {
		Skill skill = new Skill();
		skill.setName(object.getName());
		skill.setDescription(object.getDescription());
		return skill;
	}

	@Override
	public Skill map(SkillCreateDto object, Skill skill) {
		skill.setName(object.getName());
		skill.setDescription(object.getDescription());
		return skill;
	}
}