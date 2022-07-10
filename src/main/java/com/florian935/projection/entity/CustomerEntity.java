package com.florian935.projection.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class CustomerEntity {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = IDENTITY)
    Integer customerId;

    @Column(name = "name")
    String name;

    @ManyToOne(targetEntity = AddressEntity.class)
    @JoinColumn(name = "address_id")
    AddressEntity address;

    @OneToMany(mappedBy = "customer")
    List<PetEntity> pets = new ArrayList<>();
}
