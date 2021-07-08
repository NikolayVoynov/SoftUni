package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient_info")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient extends BaseEntity{

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private byte[] picture;
    private boolean medicalInsurance;
    private Set<Visitation> visitations;
    private Set<Diagnose> diagnoses;
    private Set<Medicament> medicaments;

    public Patient() {
        this.visitations = new HashSet<>();
        this.diagnoses = new HashSet<>();
        this.medicaments = new HashSet<>();
    }

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 60)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email", length = 150)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth", nullable = false)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Lob
    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column
    public boolean isMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(boolean medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    @OneToMany(mappedBy = "patient")
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @ManyToMany(mappedBy = "patients")
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @ManyToMany(mappedBy = "patients")
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}
