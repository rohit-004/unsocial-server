package com.rohitk.service;

import java.util.List;

import com.rohitk.exceptions.ReelsException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Reels;
import com.rohitk.models.User;

public interface ReelsService {

	public Reels createReels(Reels reel, User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUsersReel(Integer userId) throws ReelsException, UserException;
}
