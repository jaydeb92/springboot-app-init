package com.xworkz.boot.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDTO implements Serializable {
	private static final Logger logger = LoggerFactory.getLogger(MessageDTO.class);

	private String fromName;
	private String message;

	public MessageDTO() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageDTO [fromName=" + fromName + ", message=" + message + "]";
	}

}
