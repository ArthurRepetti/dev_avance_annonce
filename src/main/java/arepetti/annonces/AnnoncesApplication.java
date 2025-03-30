package arepetti.annonces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "arepetti.annonces.entities") // À adapter
@EnableJpaRepositories(basePackages = "arepetti.annonces.repositories") // À adapter
public class AnnoncesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnoncesApplication.class, args);
	}

}
