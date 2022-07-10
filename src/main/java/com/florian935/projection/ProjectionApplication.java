package com.florian935.projection;

import com.florian935.projection.domain.Customer;
import com.florian935.projection.entity.AddressEntity;
import com.florian935.projection.entity.CustomerEntity;
import com.florian935.projection.entity.PetEntity;
import com.florian935.projection.repository.AddressEntityRepository;
import com.florian935.projection.repository.CustomerEntityRepository;
import com.florian935.projection.repository.PetEntityRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectionApplication.class, args);
	}

	@Bean
	ApplicationRunner initData(CustomerEntityRepository customerEntityRepository,
							   AddressEntityRepository addressEntityRepository,
							   PetEntityRepository petEntityRepository) {
		return event -> {
			addressEntityRepository.save(new AddressEntity(null, "Paris"));
			customerEntityRepository.save(
					new CustomerEntity(null,
							"Florian",
							new AddressEntity(1, null), List.of()
					)
			);
			customerEntityRepository.save(
					new CustomerEntity(null,
							"Lindsay",
							new AddressEntity(1, null), List.of()
					)
			);
			petEntityRepository.save(new PetEntity(null, "Fidji", new CustomerEntity(1, null, null, null)));
			petEntityRepository.save(new PetEntity(null, "Vickie", new CustomerEntity(1, null, null, null)));
			petEntityRepository.save(new PetEntity(null, "Vickie", new CustomerEntity(2, null, null, null)));
		};
	}
}
