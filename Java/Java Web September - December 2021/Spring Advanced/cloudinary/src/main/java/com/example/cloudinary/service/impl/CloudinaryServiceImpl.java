package com.example.cloudinary.service.impl;

import com.cloudinary.Cloudinary;
import com.example.cloudinary.service.CloudinaryImage;
import com.example.cloudinary.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private static final String TEMP_FILE = "temp-file";
    private static final String URL = "url";
    private static final String PUBLIC_ID = "public_id";

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


    @Override
    public CloudinaryImage upload(MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public boolean delete(String publicId) {
        return false;
    }
}
