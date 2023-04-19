package com.example.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skills.entity.Skill;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}

