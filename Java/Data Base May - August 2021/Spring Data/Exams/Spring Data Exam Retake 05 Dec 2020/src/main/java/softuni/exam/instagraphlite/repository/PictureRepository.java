package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entity.Picture;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    boolean existsByPath(String path);

    Optional<Picture> findByPath(String path);

    List<Picture> findPictureBySizeGreaterThanOrderBySizeAsc(double size);
}
