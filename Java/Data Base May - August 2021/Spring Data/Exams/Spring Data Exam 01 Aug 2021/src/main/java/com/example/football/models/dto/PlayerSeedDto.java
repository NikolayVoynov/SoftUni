package com.example.football.models.dto;

import com.example.football.models.entity.enums.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement
    private String email;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement
    private Position position;
    @XmlElement(name = "town")
    private PlayerSeedTownDto town;
    @XmlElement(name = "team")
    private PlayerSeedTeamDto team;
    @XmlElement(name = "stat")
    private PlayerSeedStatDto stat;

    @Size(min = 2)
    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 2)
    @NotBlank
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public PlayerSeedTownDto getTown() {
        return town;
    }

    public void setTown(PlayerSeedTownDto town) {
        this.town = town;
    }


    public PlayerSeedTeamDto getTeam() {
        return team;
    }

    public void setTeam(PlayerSeedTeamDto team) {
        this.team = team;
    }


    public PlayerSeedStatDto getStat() {
        return stat;
    }

    public void setStat(PlayerSeedStatDto stat) {
        this.stat = stat;
    }
}
