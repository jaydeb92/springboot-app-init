package com.xworkz.boot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "message_info")
public class MessageEntity implements Serializable {
	private static final Logger logger = LoggerFactory.getLogger(MessageEntity.class);
	@Id
	@Column(name = "M_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	@Column(name = "FROM_NAME")
	private String fromName;
	@Column(name = "MESSAGE")
	private String message;

	public MessageEntity() {
		logger.debug("created\t" + this.getClass().getSimpleName());
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
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
		return "MessageEntity [mid=" + mid + ", fromName=" + fromName + ", message=" + message + "]";
	}

}
