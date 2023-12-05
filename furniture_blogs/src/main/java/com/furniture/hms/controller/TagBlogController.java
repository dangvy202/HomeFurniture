package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.tagblog.TagBlogResponse;
import com.furniture.hms.service.tagblog.TagBlogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tagblog")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class TagBlogController {

    private final TagBlogService tagBlogService;

    @GetMapping
    public ResponseEntity<List<TagBlogResponse>> getAllTagBlog() {
	List<TagBlogResponse> response = tagBlogService.getAllTagBlog();
	if (response != null) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
    }
}
