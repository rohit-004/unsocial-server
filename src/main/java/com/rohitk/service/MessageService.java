package com.rohitk.service;

import java.util.List;

import com.rohitk.exceptions.ChatException;
import com.rohitk.exceptions.MessageException;
import com.rohitk.models.Message;
import com.rohitk.models.User;

public interface MessageService {

	public Message createMessage(User user,Integer chatId, Message req) throws MessageException, ChatException;
	
	public List<Message> findChatsMessages(Integer chatId) throws MessageException, ChatException;
	
}
