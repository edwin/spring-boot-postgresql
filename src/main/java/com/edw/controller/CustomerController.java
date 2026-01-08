package com.edw.controller;

import com.edw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *  com.edw.controller.CustomerController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 08 Jan 2026 10:22
 */
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity findAll () {
        return ResponseEntity.ok(customerService.findAll());
    }

}
