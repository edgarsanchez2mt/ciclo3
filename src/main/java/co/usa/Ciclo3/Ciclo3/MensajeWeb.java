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
@RequestMapping({"/api/Message"})
@CrossOrigin(
        origins = {"*"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
public class MensajeWeb {
    @Autowired
    private serviciosMensaje servico;

    public MensajeWeb() {
    }

    @GetMapping({"/all"})
    public List<Mensaje> getMessages() {
        return this.servico.getAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Mensaje> getMessage(@PathVariable("id") int messageId) {
        return this.servico.getMessage(messageId);
    }

    @PostMapping({"/save"})
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje message) {
        return this.servico.save(message);
    }

    @PutMapping({"/update"})
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje message) {
        return this.servico.update(message);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return this.servico.deleteMessage(messageId);
    }
}
