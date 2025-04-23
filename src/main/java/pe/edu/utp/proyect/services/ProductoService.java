package pe.edu.utp.proyect.services;

import pe.edu.utp.proyect.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    List<Producto> findByEstado(String estado);

    Producto save(Producto producto);

    Producto update(Producto producto);

    void deleteLogical(Long id);

    void restore(Long id);

    void deletePhysical(Long id);
}
