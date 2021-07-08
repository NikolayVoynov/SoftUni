package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicament")
public class Medicament extends Patient {

    private String name;
    private Set<Patient> patients;

    public Medicament() {
        this.patients = new HashSet<>();
    }

    @Column(name = "name", nullable = false, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
