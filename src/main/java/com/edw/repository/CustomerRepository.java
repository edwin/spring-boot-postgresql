package com.edw.repository;

import com.edw.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 *  com.edw.repository.CustomerRepository
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 08 Jan 2026 10:15
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
