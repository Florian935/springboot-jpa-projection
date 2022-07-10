package com.florian935.projection.repository;

import com.florian935.projection.domain.Customer;
import com.florian935.projection.domain.CustomerWithAddress;
import com.florian935.projection.domain.CustomerWithAddressAndPets;
import com.florian935.projection.domain.CustomerWithStreetAndPets;
import com.florian935.projection.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query("""
            SELECT c.customerId as customerId, c.name as name
            FROM CustomerEntity c
            """)
    List<Customer> findCustomers();

    @Query("""
            SELECT c.customerId as customerId, c.name as name, c.address.street as street
            FROM CustomerEntity c
            """)
    List<CustomerWithAddress> findCustomersWithAddress();

    @Query("SELECT DISTINCT c FROM CustomerEntity c left join fetch c.pets")
    List<CustomerWithAddressAndPets> findCustomersWithAddressAndPets();

    @Query("SELECT DISTINCT c FROM CustomerEntity c left join fetch c.pets")
    List<CustomerWithStreetAndPets> findCustomersWithStreetAndPets();

    @Query("SELECT DISTINCT c FROM CustomerEntity c left join fetch c.pets WHERE c.customerId = :customerId")
    List<CustomerWithStreetAndPets> findCustomerWithStreetAndPetsById(@Param("customerId") Integer customerId);

    @Query("SELECT DISTINCT c FROM CustomerEntity c left join fetch c.pets")
    <T> List<T> getCustomers(Class<T> type);
}
