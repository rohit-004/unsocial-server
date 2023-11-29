package com.rohitk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohitk.exceptions.ReelsException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Reels;
import com.rohitk.models.User;
import com.rohitk.repository.ReelsRepository;

@Service
public class ReelsServiceImplementation implements ReelsService{

	@Autowired
	private ReelsRepository reelsRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Reels createReels(Reels reel, User user) {
		
		Reels createReel = new Reels();
		
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		createReel.setVideo(reel.getVideo());
		
		return reelsRepository.save(createReel);
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findUsersReel(Integer userId) throws ReelsException, UserException {
		
		userService.findUserbyId(userId);
		
		return reelsRepository.findByUserId(userId);
	}

}
