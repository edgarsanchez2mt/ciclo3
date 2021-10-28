package co.usa.Ciclo3.Ciclo3;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "message"
)
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn(
            name = "id"
    )
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(
            name = "clientId"
    )
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Cliente client;

    public Mensaje() {
    }

    public Integer getIdMessage() {
        return this.idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
}
