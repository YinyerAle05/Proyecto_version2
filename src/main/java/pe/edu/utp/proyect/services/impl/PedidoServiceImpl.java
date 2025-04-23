package pe.edu.utp.proyect.services.impl;

import pe.edu.utp.proyect.model.Pedido;
import pe.edu.utp.proyect.repository.PedidoRepository;
import pe.edu.utp.proyect.services.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> findAll() {
        log.info("Listando pedidos: ");
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        log.info("Buscando pedido por ID: " + id);
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> findByEstado(String estado) {
        log.info("Buscando pedidos con estado: " + estado);
        return pedidoRepository.findByEstado(estado);
    }

    @Override
    public Pedido save(Pedido pedido) {
        log.info("Registrando pedido: " + pedido.toString());
        pedido.setEstado("A");  // Activo por defecto
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        log.info("Actualizando pedido: " + pedido.toString());
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteLogical(Long id) {
        log.info("Eliminando lógicamente pedido con ID: " + id);
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        pedido.ifPresent(p -> {
            p.setEstado("I");  // Inactivo
            pedidoRepository.save(p);
        });
    }

    @Override
    public void restore(Long id) {
        log.info("Restaurando pedido con ID: " + id);
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        pedido.ifPresent(p -> {
            p.setEstado("A");  // Activo
            pedidoRepository.save(p);
        });
    }

    @Override
    public void deletePhysical(Long id) {
        log.info("Eliminando físicamente pedido con ID: " + id);
        pedidoRepository.deleteById(id);
    }
}
