package com.springframework.MSSCbrewery.service;

import com.springframework.MSSCbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .customerName("Mateo Terselich")
                .build();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
            return CustomerDTO.builder()
                    .id(UUID.randomUUID())
                    .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        //TODO definition ...
    }

    @Override
    public void deleteCustomer(UUID customerId) { log.debug("Delete customer debugging..."); }
}
