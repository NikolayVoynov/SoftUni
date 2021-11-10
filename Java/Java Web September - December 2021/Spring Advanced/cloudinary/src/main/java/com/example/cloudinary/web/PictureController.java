package com.example.cloudinary.web;

import com.example.cloudinary.model.binding.PictureBindingModel;
import com.example.cloudinary.model.entity.PictureEntity;
import com.example.cloudinary.repository.PictureRepository;
import com.example.cloudinary.service.CloudinaryImage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PictureController {

    private final PictureRepository pictureRepository;

    public PictureController(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @GetMapping("/pictures/add")
    public String addPicture() {
        return "add";
    }

//    @PostMapping("/pictures/add")
//    public String addPicture(PictureBindingModel pictureBindingModel) {
//        var picture = createPictureEntity(pictureBindingModel.getPicture(),
//                pictureBindingModel.getTitle());
//
//        pictureRepository.save(picture);
//
//        return "redirect:/pictures/all";
//    }
//
//    private PictureEntity createPictureEntity(MultipartFile file, String title) throws IOException {
//        final CloudinaryImage uploaded = this.cloudinaryService.upload(file);
//
//        PictureEntity pictureEntity = new PictureEntity();
//        pictureEntity.setPublicId(uploaded.getPublicId());
//        pictureEntity.setTitle(title);
//        pictureEntity.setUrl(uploaded.getUrl());

//        return pictureEntity;
//    }

    @GetMapping("/pictures/all")
    public String all(Model model) {


        //TODO

        return "all";
    }

}
