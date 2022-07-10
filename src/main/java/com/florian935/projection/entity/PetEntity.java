package com.florian935.projection.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "pet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class PetEntity {

    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy = IDENTITY)
    Integer petId;

    @Column(name = "name")
    String name;

    @ManyToOne(targetEntity = CustomerEntity.class)
    @JoinColumn(name = "customer_id")
    CustomerEntity customer;
}
