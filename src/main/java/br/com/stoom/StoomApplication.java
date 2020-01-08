package br.com.stoom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.stoom.model.Location;
import br.com.stoom.repository.LocationRepository;

@SpringBootApplication
public class StoomApplication {
	
	private static Logger logger = LoggerFactory.getLogger(StoomApplication.class);
	
	@Value("${definition.application}")
	private String app ;
	
	public static void main(String[] args) {
		SpringApplication.run(StoomApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("---------------------- type da application: " + app + " -------------------------");
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("-------------------------------------------------------------------------------- ");
			logger.info("-------------------------------------------------------------------------------- ");
		};
	}	 

}
