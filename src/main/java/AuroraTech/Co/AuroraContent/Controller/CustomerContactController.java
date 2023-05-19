package AuroraTech.Co.AuroraContent.Controller;


import AuroraTech.Co.AuroraContent.Model.CustomerContact;
import AuroraTech.Co.AuroraContent.Repository.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-contacts")
public class CustomerContactController {
    @Autowired
    private CustomerContactRepository customerContactRepository;


    @PostMapping()
    public CustomerContact createCustomerContact(@RequestBody CustomerContact customerContact) {
        return customerContactRepository.save(customerContact);
    }


    @GetMapping("/")
    public CustomerContact getContentById(@RequestParam("id") int id) {
        CustomerContact customerContact = customerContactRepository.findById(id).orElse(null);
        return customerContact;
    }

    @GetMapping()
    public List<CustomerContact> getAllCustomerContacts() {
        return customerContactRepository.findAll();
    }

    @PutMapping("/{id}")
    public CustomerContact updateCustomerContact(@PathVariable int id, @RequestBody CustomerContact customerContactData) {
        CustomerContact customerContact = customerContactRepository.findById(id).orElse(null);
        if (customerContact != null) {
            customerContact.setCustomerName(customerContactData.getCustomerName());
            customerContact.setCustomerEmail(customerContactData.getCustomerEmail());
            customerContact.setSubject(customerContactData.getSubject());
            customerContact.setMessage(customerContactData.getMessage());
            return customerContactRepository.save(customerContact);
        } else {
            return null;
        }

    }

    @DeleteMapping("/{id}")
    public void deleteCustomerContact(@PathVariable int id) {
        CustomerContact customerContact = customerContactRepository.findById(id).orElse(null);
        if (customerContact != null) {
            customerContactRepository.delete(customerContact);
        }
    }

}





