package com.rohitk.service;

import java.util.List;

import com.rohitk.exceptions.PostException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Post;

public interface PostService {
	
	Post createNewPost(Post post, Integer userId) throws PostException, UserException;

	String deletePost(Integer postId, Integer userId) throws PostException, UserException, Exception;
	
	List<Post> findPostByUserId(Integer userId);
	
	Post findPostById(Integer postId) throws PostException;
	
	List<Post> findAllPost();
	
	Post savedPost(Integer postId, Integer userId) throws PostException, UserException;
	
	Post likedPost(Integer postId, Integer userId) throws PostException, UserException;
}
