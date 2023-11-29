package com.rohitk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rohitk.exceptions.StoryException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Story;
import com.rohitk.models.User;
import com.rohitk.service.StoryService;
import com.rohitk.service.UserService;

@RestController
public class StoryController {

	@Autowired
	private StoryService storyService;

	@Autowired
	private UserService userService;

	@PostMapping("/api/story")
	public Story createStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt) {

		User reqUser = userService.findUserByJwt(jwt);

		Story createdStory = storyService.createStory(story, reqUser);

		return createdStory;

	}
	
	@GetMapping("/api/story/user/{userId}")
	public List<Story> findUserStory(@PathVariable Integer userId) throws StoryException, UserException {

		List<Story> stories = storyService.findStoryByUser(userId);

		return stories;

	}
	
}
