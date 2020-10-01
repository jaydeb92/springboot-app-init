package com.xworkz.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.boot.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

}
