package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.CommentMessage;
import com.furniture.hms.dto.comment.CommentRequest;
import com.furniture.hms.dto.comment.CommentResponse;
import com.furniture.hms.service.comment.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponse> saveCommmentBlog(@RequestBody CommentRequest request) {
	CommentResponse response = commentService.saveCommmentBlog(request);

	if (response.getStatus() && response.getMessage() == CommentMessage.COMMENT_SUCCESS) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
    }

}
