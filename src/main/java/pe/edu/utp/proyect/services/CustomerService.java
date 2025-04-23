package pe.edu.utp.proyect.services;

import pe.edu.utp.proyect.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    List<Customer> findByState(String state);

    Customer save(Customer customer);

    Customer update(Customer customer);
    
    void deleteLogical(Long id);

    void restore(Long id);

    void deletePhysical(Long id);
}