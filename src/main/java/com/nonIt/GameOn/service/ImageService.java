package com.nonIt.GameOn.service;

import com.nonIt.GameOn.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
    public byte[] uploadImage(MultipartFile file)
            throws IOException {

        return ImageUtility.compressImage(file.getBytes());
    }

    public byte[] getImage(byte[] image) throws IOException {
        return ImageUtility.decompressImage(image);
    }
}
