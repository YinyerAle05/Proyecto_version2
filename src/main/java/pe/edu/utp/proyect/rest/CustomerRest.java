package pe.edu.utp.proyect.rest;

import pe.edu.utp.proyect.model.Customer;
import pe.edu.utp.proyect.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("@RequestMapping(\"/v1/api/producto\")")
public class CustomerRest {

    private final CustomerService customerService;

    @Autowired
    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("/status/{state}")
    public List<Customer> findByState(@PathVariable String state) {
        return customerService.findByState(state);
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLogical(@PathVariable Long id) {
        customerService.deleteLogical(id);
    }

    @PutMapping("/restore/{id}")
    public void restore(@PathVariable Long id) {
        customerService.restore(id);
    }

    @DeleteMapping("/delete-physical/{id}")
    public void deletePhysical(@PathVariable Long id) {
        customerService.deletePhysical(id);
    }
}
