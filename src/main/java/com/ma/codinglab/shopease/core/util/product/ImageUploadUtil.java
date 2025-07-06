package com.ma.codinglab.shopease.core.util.product;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

public class ImageUploadUtil {

    private ImageUploadUtil() {
        // private constructor to prevent instantiation
    }

    public static String uploadImage(MultipartFile image, String folderName) {
        if (image == null || image.isEmpty()) return null;

        String storageFileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        String uploadDir = "src/main/resources/static/images/" + folderName + "/";
        Path uploadPath = Paths.get(uploadDir);

        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, uploadPath.resolve(storageFileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed: " + e.getMessage(), e);
        }

        return "/images/" + folderName + "/" + storageFileName;
    }
}

