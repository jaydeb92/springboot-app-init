package com.xworkz.boot.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xworkz.boot.dto.MessageDTO;
import com.xworkz.boot.entity.MessageEntity;

@Component
public class MessageMapperImpl implements MessageMapper {
	private static final Logger logger = LoggerFactory.getLogger(MessageMapperImpl.class);

	public MessageMapperImpl() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public MessageEntity convertDtoToEntity(MessageDTO dto) {
		logger.debug("invoked convertDtoToEntity in MessageMapperImpl class");
		MessageEntity entity = new MessageEntity();
		entity.setFromName(dto.getFromName());
		entity.setMessage(dto.getMessage());
		return entity;
	}

	@Override
	public MessageDTO convertDtoToEntity(MessageEntity entity) {
		logger.debug("invoked convertDtoToEntity in MessageMapperImpl class");
		MessageDTO dto = new MessageDTO();
		dto.setFromName(entity.getFromName());
		dto.setMessage(entity.getMessage());
		return dto;
	}

}
