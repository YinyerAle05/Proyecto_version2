package pe.edu.utp.proyect.repository;

import pe.edu.utp.proyect.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    List<Producto> findByEstado(String estado);
}
