package com.example.spring_jwt_config.controller.images;

import com.example.spring_jwt_config.controller.RestApiController;
import com.example.spring_jwt_config.service.image.ImageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/image")
@RequiredArgsConstructor
public class ImageController extends RestApiController {

    private final ImageService imageService;

    @PostMapping(value = "/files/upload-image",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImage(@Valid @NotNull @RequestPart(name= "file_data") MultipartFile fileData) throws Exception{
        return ok(imageService.uploadImage(fileData));
    }

    @GetMapping("/files/test")
    public ResponseEntity<?> getDemoTest(@RequestParam String payload)
    {
        return ok(payload);
    }
}
