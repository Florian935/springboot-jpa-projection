package com.florian935.projection.domain;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface CustomerWithAddressAndPets {
    Integer getCustomerId();
    String getName();
    Address getAddress();
    List<Pet> getPets();
}
