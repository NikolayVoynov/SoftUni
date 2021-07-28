package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.entity.Picture;

import java.io.IOException;

public interface PictureService {
    Boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;

    boolean isEntityExist(String path);

    String exportPictures();

    Picture findProfilePicture(String profilePicture);

    Picture findPictureByGiven(String path);
}
