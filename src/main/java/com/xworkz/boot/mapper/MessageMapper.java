package com.xworkz.boot.mapper;

import org.mapstruct.Mapper;

import com.xworkz.boot.dto.MessageDTO;
import com.xworkz.boot.entity.MessageEntity;

@Mapper
public interface MessageMapper {

	public MessageEntity convertDtoToEntity(MessageDTO dto);

	public MessageDTO convertDtoToEntity(MessageEntity entity);

}
