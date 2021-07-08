package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation extends Patient{

    private LocalDate visitationDate;
    private String comments;
    private Patient patient;

    public Visitation() {
    }

    @Column(name = "visitation_date", nullable = false)
    public LocalDate getVisitationDate() {
        return visitationDate;
    }

    public void setVisitationDate(LocalDate dateVisitation) {
        this.visitationDate = dateVisitation;
    }

    @Column(name = "comments", columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @ManyToOne
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
