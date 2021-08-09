package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedStatDto {

    @XmlElement(name = "id")
    private Long ig;

    public Long getIg() {
        return ig;
    }

    public void setIg(Long ig) {
        this.ig = ig;
    }
}
