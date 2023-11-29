package com.rohitk.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohitk.exceptions.StoryException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Story;
import com.rohitk.models.User;
import com.rohitk.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService {

	@Autowired
	private StoryRepository storyRepository;

	@Autowired
	private UserService userService;

	@Override
	public Story createStory(Story story, User user) {

		Story createdStory = new Story();
		
		createdStory.setCaptions(story.getCaptions());
		createdStory.setImage(story.getImage());
		createdStory.setUser(user);
		createdStory.setTimestamp(LocalDateTime.now());

		return storyRepository.save(createdStory);
	}

	@Override
	public List<Story> findStoryByUser(Integer userId) throws StoryException, UserException {

		userService.findUserbyId(userId);

		return storyRepository.findByUserId(userId);
	}

}
