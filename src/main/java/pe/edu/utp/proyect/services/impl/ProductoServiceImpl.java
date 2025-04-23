package pe.edu.utp.proyect.services.impl;

import pe.edu.utp.proyect.model.Producto;
import pe.edu.utp.proyect.repository.ProductoRepository;
import pe.edu.utp.proyect.services.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() {
        log.info("Listando productos: ");
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        log.info("Buscando producto por ID: " + id);
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findByEstado(String estado) {
        log.info("Buscando productos con estado: " + estado);
        return productoRepository.findByEstado(estado);
    }

    @Override
    public Producto save(Producto producto) {
        log.info("Registrando producto: " + producto.toString());
        producto.setEstado("A"); 
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        log.info("Actualizando producto: " + producto.toString());
        return productoRepository.save(producto);
    }

    @Override
    public void deleteLogical(Long id) {
        log.info("Eliminando lógicamente producto con ID: " + id);
        Optional<Producto> producto = productoRepository.findById(id);
        producto.ifPresent(p -> {
            p.setEstado("I");  
            productoRepository.save(p);
        });
    }

    @Override
    public void restore(Long id) {
        log.info("Restaurando producto con ID: " + id);
        Optional<Producto> producto = productoRepository.findById(id);
        producto.ifPresent(p -> {
            p.setEstado("A");  
            productoRepository.save(p);
        });
    }

    @Override
    public void deletePhysical(Long id) {
        log.info("Eliminando físicamente producto con ID: " + id);
        productoRepository.deleteById(id);
    }
}
