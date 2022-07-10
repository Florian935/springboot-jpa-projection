package com.florian935.projection.repository;

import com.florian935.projection.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRepository extends JpaRepository<AddressEntity, Integer> {
}
