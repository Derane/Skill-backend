package com.example.skills.controller;

import com.example.skills.dto.SkillCreateDto;
import com.example.skills.dto.SkillDto;
import com.example.skills.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("api/v1/skills")
@RequiredArgsConstructor
public class SkillController {

	private final String FRONTEND_URL = "https://main.dm42678gl3gyy.amplifyapp.com/";
	private final SkillService skillService;

	@CrossOrigin(origins = FRONTEND_URL)
	@GetMapping()
	public List<SkillDto> findAll() {
		return skillService.findAll();
	}

	@CrossOrigin(origins = FRONTEND_URL)
	@GetMapping("/{id}")
	public SkillDto findById(@PathVariable Integer id) {
		return skillService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
	}

	@CrossOrigin(origins = FRONTEND_URL)
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public SkillDto create(@RequestBody SkillCreateDto createDto) {
		return skillService.create(createDto);
	}

	@CrossOrigin(origins = FRONTEND_URL)
	@PutMapping("/update/{id}")
	public SkillDto update(@PathVariable Integer id, @RequestBody SkillCreateDto createDto) {
		return skillService.update(id, createDto)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
	}

	@CrossOrigin(origins = FRONTEND_URL)
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		if (!skillService.delete(id)) {
			throw new ResponseStatusException(NOT_FOUND);
		}
	}
}
