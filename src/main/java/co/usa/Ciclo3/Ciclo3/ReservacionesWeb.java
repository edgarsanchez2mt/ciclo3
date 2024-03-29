package co.usa.Ciclo3.Ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/Reservation"})
@CrossOrigin(
        origins = {"*"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
public class ReservacionesWeb {
    @Autowired
    private serviciosReservaciones servicio;

    public ReservacionesWeb() {
    }

    @GetMapping({"/all"})
    public List<Reservaciones> getReservations() {
        return this.servicio.getAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return this.servicio.getReservation(reservationId);
    }

    @PostMapping({"/save"})
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return this.servicio.save(reservation);
    }

    @PutMapping({"/update"})
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return this.servicio.update(reservation);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return this.servicio.deleteReservation(reservationId);
    }
}
