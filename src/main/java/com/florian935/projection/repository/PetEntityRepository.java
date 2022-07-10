package com.florian935.projection.repository;

import com.florian935.projection.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetEntityRepository extends JpaRepository<PetEntity, Integer> {
}
