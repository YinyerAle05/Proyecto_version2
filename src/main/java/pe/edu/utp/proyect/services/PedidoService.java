package pe.edu.utp.proyect.services;

import pe.edu.utp.proyect.model.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> findAll();

    Optional<Pedido> findById(Long id);

    List<Pedido> findByEstado(String estado);

    Pedido save(Pedido pedido);

    Pedido update(Pedido pedido);

    void deleteLogical(Long id);

    void restore(Long id);

    void deletePhysical(Long id);
}
