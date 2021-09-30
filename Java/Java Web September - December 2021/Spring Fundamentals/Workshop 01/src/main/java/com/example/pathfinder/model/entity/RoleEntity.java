package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleNameEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    private RoleNameEnum name;

    public RoleEntity() {
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum role) {
        this.name = role;
    }
}
