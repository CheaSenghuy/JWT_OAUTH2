package com.example.spring_jwt_config.utils;

import org.apache.commons.lang3.StringUtils;

public class ImageUtil {
    public static String getImageUrl(String baseUrl, String imageUrl) {
        if(StringUtils.isBlank(imageUrl)) return "";
        return baseUrl + "/" + imageUrl;
    }

    public static String getImageUrlWithFallback(String baseUrl, String imageUrl) {
        if(StringUtils.isBlank(imageUrl)) return baseUrl + "/user-default.png";
        return baseUrl + "/" + imageUrl;
    }
}
