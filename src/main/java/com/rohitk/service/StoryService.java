package com.rohitk.service;

import java.util.List;

import com.rohitk.exceptions.StoryException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Story;
import com.rohitk.models.User;

public interface StoryService {

	public Story createStory(Story story, User user);
	
	public List<Story> findStoryByUser(Integer userId) throws StoryException, UserException;
}
