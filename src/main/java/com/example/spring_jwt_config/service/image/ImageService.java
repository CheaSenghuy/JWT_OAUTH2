package com.example.spring_jwt_config.service.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Object uploadImage(MultipartFile fileData) throws Exception;

}
