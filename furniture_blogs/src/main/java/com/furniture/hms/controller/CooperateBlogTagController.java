package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.cooperate.CooperateResponse;
import com.furniture.hms.service.cooperate.CooperateBlogTagService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CooperateBlogTagController {

    private final CooperateBlogTagService cooperateBlogTagService;

    @GetMapping("/tag/{id}")
    public ResponseEntity<CooperateResponse> getAllTagBlog(@PathVariable("id") int id) {
	CooperateResponse response = cooperateBlogTagService.getListBlogByTagBlog(id);
	if (response != null) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
    }

}
