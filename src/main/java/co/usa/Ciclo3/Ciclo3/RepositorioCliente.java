package co.usa.Ciclo3.Ciclo3;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crud1;

    public RepositorioCliente() {
    }

    public List<Cliente> getAll() {
        return (List)this.crud1.findAll();
    }

    public Optional<Cliente> getCliente(int id) {
        return this.crud1.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return (Cliente)this.crud1.save(cliente);
    }

    public void delete(Cliente cliente) {
        this.crud1.delete(cliente);
    }
}
