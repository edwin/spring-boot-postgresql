package com.edw.service;

import com.edw.model.Customer;
import com.edw.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *  com.edw.service.CustomerService
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 08 Jan 2026 10:15
 */
@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(@Autowired CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "customerId"));
    }
}
