package blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BlogApplication {

	public static void main(String[] args) {	
		SpringApplication.run(BlogApplication.class, args);	
	}
	
	
	  @Bean public ModelMapper getModelMapper() { return new ModelMapper(); }
	 
}
