package softuni.exam.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;

public class PlayerTeamPicDto {

    @Expose
    private String url;

    public PlayerTeamPicDto() {
    }

    @NotBlank
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
