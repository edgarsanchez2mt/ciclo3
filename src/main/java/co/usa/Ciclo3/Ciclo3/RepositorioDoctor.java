package co.usa.Ciclo3.Ciclo3;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDoctor {
    @Autowired
    private InterfaceDoctor crud;

    public RepositorioDoctor() {
    }

    public List<Doctor> getAll() {
        return (List)this.crud.findAll();
    }

    public Optional<Doctor> getDoctor(int id) {
        return this.crud.findById(id);
    }

    public Doctor save(Doctor doctor) {
        return (Doctor)this.crud.save(doctor);
    }

    public void delete(Doctor doctor) {
        this.crud.delete(doctor);
    }
}
