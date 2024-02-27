package com.example.spring_jwt_config.service.image;

import com.example.spring_jwt_config.common.api.StatusCode;
import com.example.spring_jwt_config.components.FileManager;
import com.example.spring_jwt_config.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public Object uploadImage(MultipartFile fileData) throws Exception {
        if(fileData.isEmpty()) throw new BusinessException(StatusCode.IMAGE_CANNOT_BE_EMPTY);
        String imageUrl =  FileManager.storeImage(fileData);
        System.out.println(" Image URL : "+imageUrl);
        Map<String, String> data = new HashMap<>();
        data.put("image_url",imageUrl);

        return data;
    }

}
