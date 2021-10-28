package co.usa.Ciclo3.Ciclo3;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crud3;

    public RepositorioMensaje() {
    }

    public List<Mensaje> getAll() {
        return (List)this.crud3.findAll();
    }

    public Optional<Mensaje> getMessage(int id) {
        return this.crud3.findById(id);
    }

    public Mensaje save(Mensaje message) {
        return (Mensaje)this.crud3.save(message);
    }

    public void delete(Mensaje message) {
        this.crud3.delete(message);
    }
}
