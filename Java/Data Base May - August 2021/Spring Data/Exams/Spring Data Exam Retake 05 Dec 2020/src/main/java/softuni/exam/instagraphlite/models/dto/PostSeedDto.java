package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedDto {

    @XmlElement(name = "caption")
    private String caption;
    @XmlElement(name = "user")
    private PostUserDto postUserDto;
    @XmlElement(name = "picture")
    private PostPictureDto postPictureDto;

    @NotNull
    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    public PostUserDto getPostUserDto() {
        return postUserDto;
    }

    public void setPostUserDto(PostUserDto postUserDto) {
        this.postUserDto = postUserDto;
    }

    @NotNull
    public PostPictureDto getPostPictureDto() {
        return postPictureDto;
    }

    public void setPostPictureDto(PostPictureDto postPictureDto) {
        this.postPictureDto = postPictureDto;
    }
}
