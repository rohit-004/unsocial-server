package com.rohitk.service;

import com.rohitk.exceptions.CommentException;
import com.rohitk.exceptions.PostException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Comment;

public interface CommentService {
	
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws CommentException, UserException, PostException;

	public Comment findCommentById(Integer commentId) throws CommentException;
	
	public Comment likeComment(Integer CommentId, Integer userId) throws CommentException, UserException;
}
