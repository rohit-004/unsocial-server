package com.rohitk.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohitk.exceptions.CommentException;
import com.rohitk.exceptions.PostException;
import com.rohitk.exceptions.UserException;
import com.rohitk.models.Comment;
import com.rohitk.models.Post;
import com.rohitk.models.User;
import com.rohitk.repository.CommentRepository;
import com.rohitk.repository.PostRepository;

@Service
public class CommentServiceImplementation implements CommentService{

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws CommentException, UserException, PostException {
		
		User user = userService.findUserbyId(userId);
		
		Post post = postService.findPostById(postId);
		
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		
		Comment savedComment=commentRepository.save(comment);
		
		post.getComments().add(savedComment);
		
		postRepository.save(post);
		
		return savedComment;
	}

	@Override
	public Comment findCommentById(Integer commentId) throws CommentException {
		Optional<Comment> opt = commentRepository.findById(commentId);
		
		if(opt.isEmpty()) {
			throw new CommentException("Comment not exist");
		}
		
		return opt.get();
	}

	@Override
	public Comment likeComment(Integer CommentId, Integer userId) throws CommentException, UserException {
		Comment comment = findCommentById(CommentId);
		
		User user = userService.findUserbyId(userId);
		
		if (!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}else comment.getLiked().remove(user);
		
		return commentRepository.save(comment);
	}

	
}
