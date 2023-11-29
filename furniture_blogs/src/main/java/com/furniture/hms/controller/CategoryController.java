package com.furniture.hms.controller;

import com.furniture.hms.dto.category.CategoryBlogResponse;
import com.furniture.hms.service.category.CategoryBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoryBlog")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CategoryController {

    private final CategoryBlogService categoryBlogService;

    @GetMapping
    public ResponseEntity<List<CategoryBlogResponse>> getAllCategories() {
        List<CategoryBlogResponse> response = categoryBlogService.getAllCategoriesBlog();
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
