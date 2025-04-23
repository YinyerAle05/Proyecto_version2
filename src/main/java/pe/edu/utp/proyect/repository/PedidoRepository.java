package pe.edu.utp.proyect.repository;

import pe.edu.utp.proyect.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    List<Pedido> findByEstado(String estado);
}
