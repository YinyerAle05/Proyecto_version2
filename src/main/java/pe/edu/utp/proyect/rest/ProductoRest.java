package pe.edu.utp.proyect.rest;

import pe.edu.utp.proyect.model.Producto;
import pe.edu.utp.proyect.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/producto")
public class ProductoRest {

    private final ProductoService productoService;

    @Autowired
    public ProductoRest(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Producto> findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @GetMapping("/status/{estado}")
    public List<Producto> findByEstado(@PathVariable String estado) {
        return productoService.findByEstado(estado);
    }

    @PostMapping("/save")
    public Producto save(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/update")
    public Producto update(@RequestBody Producto producto) {
        return productoService.update(producto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLogical(@PathVariable Long id) {
        productoService.deleteLogical(id);
    }

    @PutMapping("/restore/{id}")
    public void restore(@PathVariable Long id) {
        productoService.restore(id);
    }

    @DeleteMapping("/delete-physical/{id}")
    public void deletePhysical(@PathVariable Long id) {
        productoService.deletePhysical(id);
    }
}
