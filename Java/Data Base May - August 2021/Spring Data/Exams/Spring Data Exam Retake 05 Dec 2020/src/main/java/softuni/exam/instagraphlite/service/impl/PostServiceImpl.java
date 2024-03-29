package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostSeedRootDto;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    private static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final UserService userService;
    private final PictureService pictureService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public PostServiceImpl(PostRepository postRepository, UserService userService,
                           PictureService pictureService, ValidationUtil validationUtil,
                           ModelMapper modelMapper, XmlParser xmlParser) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.pictureService = pictureService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean аreImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(POSTS_FILE_PATH, PostSeedRootDto.class)
                .getPosts()
                .stream()
                .filter(postSeedDto -> {
                    boolean isValid = validationUtil.isValid(postSeedDto)
                            && userService.isEntityExist(postSeedDto.getPostUserDto().getUsername())
                            && pictureService.isEntityExist(postSeedDto.getPostPictureDto().getPath());

                    sb.append(isValid ? String.format("Successfully imported Post, made by %s",
                            postSeedDto.getPostUserDto().getUsername()) :
                            "Invalid Post")
                    .append(System.lineSeparator());

                    return isValid;
                })
                .map(postSeedDto -> {
                    Post post = modelMapper.map(postSeedDto, Post.class);

                    post.setUser(userService.findUserByGiven(postSeedDto.getPostUserDto().getUsername()));
                    post.setPicture(pictureService.findPictureByGiven(postSeedDto.getPostPictureDto().getPath()));

                    return post;
                })
                .forEach(postRepository::save);

        return sb.toString();
    }
}
