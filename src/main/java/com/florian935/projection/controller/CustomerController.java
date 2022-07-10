package com.florian935.projection.controller;

import com.florian935.projection.domain.Customer;
import com.florian935.projection.domain.CustomerWithAddress;
import com.florian935.projection.domain.CustomerWithAddressAndPets;
import com.florian935.projection.domain.CustomerWithStreetAndPets;
import com.florian935.projection.entity.CustomerEntity;
import com.florian935.projection.repository.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerEntityRepository customerEntityRepository;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    List<Customer> findCustomers() {
        return this.customerEntityRepository.findCustomers();
    }

    @GetMapping(path = "with-address", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    List<CustomerWithAddress> findCustomersWithAddress() {
        return this.customerEntityRepository.findCustomersWithAddress();
    }

    @GetMapping(path = "with-address-and-pets", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    List<CustomerWithAddressAndPets> findCustomersWithAddressAndPets() {
        return this.customerEntityRepository.findCustomersWithAddressAndPets();
    }

    @GetMapping(path = "with-street-and-pets", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    List<CustomerWithStreetAndPets> findCustomersWithStreetAndPets() {
        return this.customerEntityRepository.findCustomersWithStreetAndPets();
    }

    @GetMapping(path = "find-all", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    List<CustomerEntity> findAll() {
        return this.customerEntityRepository.findAll();
    }

    @GetMapping(path = "get-customers", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    List<CustomerWithStreetAndPets> getCustomers() {
        return this.customerEntityRepository.getCustomers(CustomerWithStreetAndPets.class);
    }

    @GetMapping(path = "with-street-and-pets/{customerId}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(OK)
    List<CustomerWithStreetAndPets> findCustomerWithStreetAndPetsById(@PathVariable Integer customerId) {
        return this.customerEntityRepository.findCustomerWithStreetAndPetsById(customerId);
    }
}
