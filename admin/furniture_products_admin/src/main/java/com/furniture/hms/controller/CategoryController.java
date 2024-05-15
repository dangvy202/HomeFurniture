package com.furniture.hms.controller;

import com.furniture.hms.dto.category.CategoryRequest;
import com.furniture.hms.dto.category.CategoryResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CategoryController {

    private final CategoryService categoryService;

    @PutMapping("/update/{id}")
    public ResponseEntity<ResultData<CategoryResponse>> updateById(@PathVariable("id") int id, @ModelAttribute CategoryRequest request) {
        var response = categoryService.updateById(id,request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/update/status/{id}")
    public ResponseEntity<ResultData<CategoryResponse>> updateStatusCategoryById(@PathVariable("id") int id, @RequestBody CategoryRequest request) {
        var response = categoryService.updateStatusCategoryById(id,request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResultData<List<CategoryResponse>>> getAllCategories() {
        var response = categoryService.getAllCategories();
        return new ResponseEntity<ResultData<List<CategoryResponse>>>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResultData<CategoryResponse>> createCategories(@ModelAttribute @Validated CategoryRequest request) {
        var response = categoryService.createCategories(request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
