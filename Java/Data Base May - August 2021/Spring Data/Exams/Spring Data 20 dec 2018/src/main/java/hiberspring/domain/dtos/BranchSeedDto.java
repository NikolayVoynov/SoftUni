package hiberspring.domain.dtos;

import com.google.gson.annotations.Expose;
import hiberspring.domain.entities.Town;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BranchSeedDto {

    @Expose
    private String name;
    @Expose
    private String town;

    public BranchSeedDto() {
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
