package com.florian935.projection.domain;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface CustomerWithStreetAndPets {
    Integer getCustomerId();
    String getName();
    @Value("#{target.address.street}")
    String getStreet();
    List<Pet> getPets();
}
