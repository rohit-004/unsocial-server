package com.rohitk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rohitk.exceptions.ReelsException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Reels;
import com.rohitk.models.User;
import com.rohitk.service.ReelsService;
import com.rohitk.service.UserService;

@RestController
public class ReelsController {
	
	@Autowired
	private ReelsService reelsService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/api/reels")
	public Reels createReels(@RequestBody Reels reel, @RequestHeader("Authorization") String jwt) {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Reels createdReels =  reelsService.createReels(reel, reqUser);
		
		return createdReels;
	}
	
	@GetMapping("/api/reels")
	public List<Reels> findAllReels() {
		
		List<Reels> Reels =  reelsService.findAllReels();
		
		return Reels;
	}
	
	@GetMapping("/api/reels/user/{userId}")
	public List<Reels> findUserReels(@PathVariable Integer userId) throws UserException, ReelsException {
		
		List<Reels> Reels =  reelsService.findUsersReel(userId);
		
		return Reels;
	}
}
