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
@RequestMapping({"/api/Client"})
@CrossOrigin(
        origins = {"*"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
public class ClienteWeb {
    @Autowired
    private serviciosCliente servicio;

    public ClienteWeb() {
    }

    @GetMapping({"/all"})
    public List<Cliente> getClients() {
        return this.servicio.getAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Cliente> getClient(@PathVariable("id") int clientId) {
        return this.servicio.getClient(clientId);
    }

    @PostMapping({"/save"})
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente client) {
        return this.servicio.save(client);
    }

    @PutMapping({"/update"})
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente client) {
        return this.servicio.update(client);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return this.servicio.deleteClient(clientId);
    }
}
