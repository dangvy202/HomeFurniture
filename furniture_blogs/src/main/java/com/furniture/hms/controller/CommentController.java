package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<CommentResponse>> saveCommmentBlog(@RequestBody CommentRequest request) {

	commentService.saveCommmentBlog(request);
	return null;
//	if (response != null) {
//	    return new ResponseEntity<>(response, HttpStatus.OK);
//	} else {
//	    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//	}
    }

}
