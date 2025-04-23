package pe.edu.utp.proyect.rest;

import pe.edu.utp.proyect.model.Pedido;
import pe.edu.utp.proyect.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/pedido")
public class PedidoRest {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoRest(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @GetMapping("/status/{estado}")
    public List<Pedido> findByEstado(@PathVariable String estado) {
        return pedidoService.findByEstado(estado);
    }

    @PostMapping("/save")
    public Pedido save(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @PutMapping("/update")
    public Pedido update(@RequestBody Pedido pedido) {
        return pedidoService.update(pedido);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLogical(@PathVariable Long id) {
        pedidoService.deleteLogical(id);
    }

    @PutMapping("/restore/{id}")
    public void restore(@PathVariable Long id) {
        pedidoService.restore(id);
    }

    @DeleteMapping("/delete-physical/{id}")
    public void deletePhysical(@PathVariable Long id) {
        pedidoService.deletePhysical(id);
    }
}
