package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final PictureService pictureService;
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validatorUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, PictureService pictureService, PictureRepository pictureRepository,
                           ModelMapper modelMapper, ValidationUtil validatorUtil, Gson gson) {
        this.userRepository = userRepository;
        this.pictureService = pictureService;
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public Boolean аreImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                .fromJson(readFromFileContent(), UserSeedDto[].class))
                .filter(userSeedDto -> {
                    boolean isValid = validatorUtil.isValid(userSeedDto)
                            && pictureService.isEntityExist(userSeedDto.getProfilePicture())
                            && !isEntityExist(userSeedDto.getUsername());

                    sb.append(isValid ? String.format("Successfully imported User: %s", userSeedDto.getUsername()) :
                            "Invalid User")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(userSeedDto -> {
                    User user = modelMapper.map(userSeedDto, User.class);
                    user.setProfilePicture(pictureService.findProfilePicture(userSeedDto.getProfilePicture()));

                    return user;
                })
                .forEach(userRepository::save);

        return sb.toString();
    }

    @Override
    public boolean isEntityExist(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        userRepository.
                findAllByPostsCountDescThenByUserId()
                .forEach(user -> {
                    sb.append(String.format("User: %s",user.getUsername()))
                            .append(System.lineSeparator())
                            .append(String.format("Post count: %d", user.getPosts().size()))
                            .append(System.lineSeparator());

                    for (Post post : user.getPosts()) {
                        sb.append(String.format("==Post Details:"))
                                .append(System.lineSeparator())
                                .append(String.format("----Caption: %s", post.getCaption()))
                                .append(System.lineSeparator())
                                .append(String.format("----Picture Size: %.2f", post.getPicture().getSize()))
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString().trim();
    }

    @Override
    public User findUserByGiven(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }
}
