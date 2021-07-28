package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostPictureDto {

    @XmlElement(name = "path")
    private String path;

    @NotBlank
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
