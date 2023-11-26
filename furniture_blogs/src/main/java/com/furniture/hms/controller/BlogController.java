package com.furniture.hms.controller;

import com.furniture.hms.dto.blog.BlogResponse;
import com.furniture.hms.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<List<BlogResponse>> getBlogById(@PathVariable("id") int id){
        List<BlogResponse> response = blogService.getBlogById(id);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
