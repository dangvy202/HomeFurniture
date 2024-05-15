package com.furniture.hms.service.category;

import com.furniture.hms.constant.CategoryMessage;
import com.furniture.hms.dto.category.CategoryRequest;
import com.furniture.hms.dto.category.CategoryResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.Category;
import com.furniture.hms.enums.ImageEnum;
import com.furniture.hms.enums.StatusEnum;
import com.furniture.hms.mapper.category.CategoryMapper;
import com.furniture.hms.repository.category.CategoryRepository;
import com.furniture.hms.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ImageService imageService;

    private static final String PATH = "D:\\HomeFurniture\\template\\HomeFurniture\\frontend\\furniture_home\\src\\component\\asset\\home";

    public ResultData<CategoryResponse> updateById(int id , CategoryRequest request) {
        CategoryResponse response = new CategoryResponse();
        Category category = categoryRepository.findById(id).orElse(null);
        if(category.toString() == null) {
            return new ResultData<>(Boolean.FALSE,CategoryMessage.FAIL,CategoryMessage.NOT_FOUND,response);
        }
        try {
            if(request.getFile() != null) {
                // update image
                File tempFile = new File(PATH + "\\" + category.getCategoryPicture());
                Boolean deleteCheck = tempFile.delete();

                if(deleteCheck == Boolean.TRUE) {
                    String noticeSavePicture = imageService.savePicture(PATH, request.getFile().getOriginalFilename(),
                            request.getFile().getBytes());
                    if(noticeSavePicture.equals(ImageEnum.FAIL_EXTENSION.getValue())) {
                        throw new Exception(noticeSavePicture);
                    }
                    category = CategoryMapper.INSTANCE.toCategoryEntity(request.getCategoryName(), request.getFile().getOriginalFilename(), request.getCategoryRedirect(), request.getStatus().getKey(),"VY",Instant.now(),"VY",Instant.now());
                    category.setId(id);
                    categoryRepository.save(category);
                    return new ResultData<>(Boolean.TRUE,null,CategoryMessage.SUCCESS,response);
                } else {
                    return new ResultData<>(Boolean.FALSE , CategoryMessage.FAIL,CategoryMessage.DELETE_OLD_FAIL,response);
                }
            } else {
                //update not image
                String oldImg = category.getCategoryPicture();
                category = CategoryMapper.INSTANCE.toCategoryEntityNotImage(request.getCategoryName(), request.getCategoryRedirect(), request.getStatus().getKey(),"VY",Instant.now(),"VY",Instant.now());
                category.setId(id);
                category.setCategoryPicture(oldImg);
                categoryRepository.save(category);
                return new ResultData<>(Boolean.TRUE,null,CategoryMessage.SUCCESS,response);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return new ResultData<>(Boolean.FALSE , CategoryMessage.FAIL,CategoryMessage.FAIL,response);
        }
    }

    public ResultData<CategoryResponse> updateStatusCategoryById(int id,CategoryRequest request) {
        CategoryResponse response = new CategoryResponse();
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null) {
            return new ResultData<>(Boolean.FALSE,CategoryMessage.FAIL,CategoryMessage.NOT_FOUND,null);
        }
        try {
            int status = request.getStatus().getKey();
            category.setStatus(status);
            categoryRepository.save(category);
            response = CategoryMapper.INSTANCE.toCategoryResponse(category);
            return new ResultData<>(Boolean.TRUE,null,CategoryMessage.SUCCESS,response);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return new ResultData<>(Boolean.FALSE,CategoryMessage.FAIL,CategoryMessage.FAIL,response);
        }
    }

    public ResultData<List<CategoryResponse>> getAllCategories() {
        List<Category> listCategories = categoryRepository.findAll();

        List<CategoryResponse> listCategoriesResponse = new ArrayList<>();

        if(!listCategories.isEmpty()) {
            for (Category category : listCategories){
                if(category.getStatus() == 1) {
                    CategoryResponse detailResponse = CategoryMapper.INSTANCE.toCategoryResponse(category);
                    listCategoriesResponse.add(detailResponse);
                }
            }
            return new ResultData<>(Boolean.TRUE,null, CategoryMessage.SUCCESS,listCategoriesResponse);
        }else {
            return null;
        }
    }

    public ResultData<CategoryResponse> createCategories(CategoryRequest request) {
        try{
            Category category = new Category();
            if(request.getStatus().equals(StatusEnum.VALID)) {
                category = CategoryMapper.INSTANCE.toCategoryEntity(request.getCategoryName(), request.getFile().getOriginalFilename(), request.getCategoryRedirect(), 1 , "Vy" , Instant.now(),"Vy",Instant.now());
            } else {
                category = CategoryMapper.INSTANCE.toCategoryEntity(request.getCategoryName(), request.getFile().getOriginalFilename(), request.getCategoryRedirect(), 0 , "Vy" , Instant.now(),"Vy",Instant.now());
            }
            String noticeSavePicture = imageService.savePicture(PATH, request.getFile().getOriginalFilename(),
                    request.getFile().getBytes());
            if(noticeSavePicture.equals(ImageEnum.FAIL_EXTENSION.getValue())) {
                throw new Exception(noticeSavePicture);
            }
            categoryRepository.save(category);
            return new ResultData<>(Boolean.TRUE,null,CategoryMessage.SUCCESS,null);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return new ResultData<>(Boolean.FALSE,CategoryMessage.FAIL,CategoryMessage.FAIL, null);
        }
    }
}
