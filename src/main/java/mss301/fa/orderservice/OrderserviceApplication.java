package mss301.fa.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = {"mss301.fa.orderservice.service"})
@ComponentScan(basePackages = {"mss301.fa.orderservice.controller",
        "mss301.fa.orderservice.service"})
@EnableJpaRepositories(basePackages = {"mss301.fa.orderservice.repository"})
@EntityScan(basePackages = {"mss301.fa.orderservice.entity"})
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}

}
