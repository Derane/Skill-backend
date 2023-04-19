package com.example.skills.mapper;

import com.example.skills.dto.SkillDto;
import com.example.skills.entity.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SkillDtoMapper implements Mapper<Skill, SkillDto> {

	private final IconDtoMapper iconDtoMapper;

	@Override
	public SkillDto map(Skill object) {
		return new SkillDto(object.getId(), object.getName(), object.getDescription(), iconDtoMapper.map(object.getIcon()));
	}
}

