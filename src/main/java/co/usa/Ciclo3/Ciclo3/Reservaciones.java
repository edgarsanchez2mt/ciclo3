package co.usa.Ciclo3.Ciclo3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "reservation"
)
public class Reservaciones implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    @ManyToOne
    @JoinColumn(
            name = "id"
    )
    @JsonIgnoreProperties({"reservations"})
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(
            name = "idClient"
    )
    @JsonIgnoreProperties({"reservations", "messages"})
    private Cliente client;
    private String score;

    public Reservaciones() {
    }

    public Integer getIdReservation() {
        return this.idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return this.devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Cliente getClient() {
        return this.client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
