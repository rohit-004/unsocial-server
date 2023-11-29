package com.rohitk.service;

import java.util.List;

import com.rohitk.exceptions.ChatException;
import com.rohitk.models.Chat;
import com.rohitk.models.User;

public interface ChatService {

	public Chat createChat(User reqUser, User user2);
	
	public Chat findChatById(Integer chatId) throws ChatException;
	
	public List<Chat> findUsersChat(Integer userId);
}
