package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.blog.BlogResponse;
import com.furniture.hms.service.blog.BlogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogResponse>> getAllBlog() {
	List<BlogResponse> response = blogService.getAllBlog();
	if (response != null) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<BlogResponse>> getBlogByCategoryBlogId(@PathVariable("id") int id) {
	List<BlogResponse> response = blogService.getBlogByCategoryBlogId(id);
	if (response != null) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<BlogResponse> getBlogDetailById(@PathVariable("id") int id) {
	BlogResponse response = blogService.getBlogDetailById(id);
	if (response != null) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
    }

}
