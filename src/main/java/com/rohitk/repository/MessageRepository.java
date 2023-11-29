package com.rohitk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohitk.models.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	public List<Message> findByChatId(Integer chatId);
}
