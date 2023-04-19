package com.example.skills.service.impl;

import com.example.skills.dto.SkillCreateDto;
import com.example.skills.dto.SkillDto;
import com.example.skills.exception.CouldNotSaveSeatException;
import com.example.skills.mapper.SeatCreateMapper;
import com.example.skills.mapper.SkillDtoMapper;
import com.example.skills.repository.SkillRepository;
import com.example.skills.service.SkillService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

	private final SkillRepository skillRepository;

	private final SkillDtoMapper skillDtoMapper;

	private final SeatCreateMapper seatCreateMapper;

	@Override
	public List<SkillDto> findAll() {
		return skillRepository.findAll()
				.stream()
				.map(skillDtoMapper::map)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<SkillDto> findById(Integer id) {
		return skillRepository.findById(id)
				.map(skillDtoMapper::map);
	}

	@Override
	public SkillDto create(SkillCreateDto createDto) {
		return Optional.of(createDto)
				.map(seatCreateMapper::map)
				.map(skillRepository::saveAndFlush)
				.map(skillDtoMapper::map)
				.orElseThrow(CouldNotSaveSeatException::new);
	}

	@Override
	public Optional<SkillDto> update(Integer id, SkillCreateDto createDto) {
		 return skillRepository.findById(id)
				.map(entity -> seatCreateMapper.map(createDto, entity))
				 .map(skillRepository::saveAndFlush)
				 .map(skillDtoMapper::map);
	}
	@Override
	public boolean delete(Integer id) {
		return skillRepository.findById(id)
				.map(entity -> {
					skillRepository.delete(entity);
					return true;
				}).orElse(false);
	}

}
