package com.xworkz.boot.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.boot.dto.MessageDTO;
import com.xworkz.boot.entity.MessageEntity;
import com.xworkz.boot.mapper.MessageMapper;
import com.xworkz.boot.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public int create(MessageDTO messageDTO) {
		logger.debug("invoked create method in MessageServiceImpl");
		boolean valid = false;
		String name = messageDTO.getFromName();
		String message = messageDTO.getMessage();
		try {
			if (Objects.nonNull(messageDTO)) {
				logger.debug("MessageDTO not null can send message..");
				valid = true;
				if (valid && !name.isEmpty()) {
					logger.debug("Name not empty can send message.");
					valid = true;
				} else {
					logger.debug("Name  empty can not send message.");
					valid = false;
				}
				if (valid && !message.isEmpty()) {
					logger.debug("message not empty can send message.");
					valid = true;
				} else {
					logger.debug("message empty can not  send message.");
					valid = false;
				}
				if (valid) {
					logger.debug("message and name not empty can send message.");
					valid = true;
					/*
					 * MessageEntity entity = new MessageEntity();
					 * BeanUtils.copyProperties(messageDTO, entity);
					 */
					MessageEntity entity = messageMapper.convertDtoToEntity(messageDTO);

					MessageEntity messageEntity = messageRepository.save(entity);

					int mid = messageEntity.getMid();
					logger.debug("mid\t" + mid);
					return mid;

				} else {
					logger.debug("message or name  empty can not send message.");
					valid = false;
				}

			} else {
				logger.debug("MessageDTO  null can not send message..");
				valid = false;

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

}
