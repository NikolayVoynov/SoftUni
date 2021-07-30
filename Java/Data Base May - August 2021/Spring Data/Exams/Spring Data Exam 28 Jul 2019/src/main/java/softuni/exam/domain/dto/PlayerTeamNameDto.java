package softuni.exam.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlayerTeamNameDto {

    @Expose
    private String name;
    @Expose
    private PlayerTeamPicDto picture;

    public PlayerTeamNameDto() {
    }

    @NotBlank
    @Size(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public PlayerTeamPicDto getPicture() {
        return picture;
    }

    public void setPicture(PlayerTeamPicDto picture) {
        this.picture = picture;
    }
}
