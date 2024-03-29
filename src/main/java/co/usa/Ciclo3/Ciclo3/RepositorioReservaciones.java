package co.usa.Ciclo3.Ciclo3;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crud4;

    public RepositorioReservaciones() {
    }

    public List<Reservaciones> getAll() {
        return (List)this.crud4.findAll();
    }

    public Optional<Reservaciones> getReservation(int id) {
        return this.crud4.findById(id);
    }

    public Reservaciones save(Reservaciones reservation) {
        return (Reservaciones)this.crud4.save(reservation);
    }

    public void delete(Reservaciones reservation) {
        this.crud4.delete(reservation);
    }
}
