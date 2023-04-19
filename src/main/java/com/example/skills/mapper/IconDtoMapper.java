package com.example.skills.mapper;

import com.example.skills.dto.IconDto;
import com.example.skills.entity.Icon;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IconDtoMapper implements Mapper<Icon, IconDto> {

	@Override
	public IconDto map(Icon icon) {
		return Optional.ofNullable(icon)
				.map(object -> new IconDto(object.getId(), object.getImage(), object.getName()))
				.orElse(null);
	}

}
