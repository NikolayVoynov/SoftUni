package softuni.exam.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamSeedDto {

    @XmlElement
    private String name;
    @XmlElement(name = "picture")
    private TeamPictureDto teamPictureDto;

    @NotBlank
    @Size(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public TeamPictureDto getTeamPictureDto() {
        return teamPictureDto;
    }

    public void setTeamPictureDto(TeamPictureDto teamPictureDto) {
        this.teamPictureDto = teamPictureDto;
    }
}
