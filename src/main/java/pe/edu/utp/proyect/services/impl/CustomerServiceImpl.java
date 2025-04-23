package pe.edu.utp.proyect.services.impl;

import pe.edu.utp.proyect.model.Customer;
import pe.edu.utp.proyect.repository.CustomerRepository;
import pe.edu.utp.proyect.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /* Listar Todos */
    @Override
    public List<Customer> findAll() {
        log.info("Listando Datos: ");
        return customerRepository.findAll();
    }

    /* Listar por ID */
    @Override
    public Optional<Customer> findById(Long id) {
        log.info("Listando Datos por ID: ");
        return customerRepository.findById(id);
    }

    /* Buscar por estado */
    @Override
    public List<Customer> findByState(String state) {
        log.info("Buscando clientes con estado: " + state);
        return customerRepository.findByState(state); 
    }

    /* Agregar */
    @Override
    public Customer save(Customer customer) {
        log.info("Registrando Datos: " + customer.toString());
        customer.setState("A");
        return customerRepository.save(customer);
    }

    /* Actualizar */
    @Override
    public Customer update(Customer customer) {
        log.info("Editando Datos: " + customer.toString());
        return customerRepository.save(customer);
    }

    /* Eliminado lógico */
    @Override
    public void deleteLogical(Long id) {
        log.info("Eliminando lógicamente cliente con ID: " + id);
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(c -> {
            c.setState("I");
            customerRepository.save(c);
        });
    }

    /* Restaurar cliente */
    @Override
    public void restore(Long id) {
        log.info("Restaurando cliente con ID: " + id);
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(c -> {
            c.setState("A");
            customerRepository.save(c);
        });
    }

    /* Eliminación física */
    @Override
    public void deletePhysical(Long id) {
        log.info("Eliminando físicamente cliente con ID: " + id);
        customerRepository.deleteById(id);
    }
}
