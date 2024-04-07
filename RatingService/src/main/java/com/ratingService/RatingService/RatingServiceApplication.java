package com.ratingService.RatingService;

import com.ratingService.RatingService.repositories.RatingRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = RatingRepo.class)
//@EnableJpaRepositories(excludeFilters =
//@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RatingRepo.class))
@SpringBootApplication()
@EnableDiscoveryClient
public class RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}

}
