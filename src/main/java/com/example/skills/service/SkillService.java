package com.example.skills.service;

import com.example.skills.dto.SkillCreateDto;
import com.example.skills.dto.SkillDto;
import com.example.skills.entity.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {

	List<SkillDto> findAll();

	Optional<SkillDto> findById(Integer id);

	SkillDto create(SkillCreateDto createDto);

	Optional<SkillDto> update(Integer id, SkillCreateDto createDto);

	boolean delete(Integer id);
}
