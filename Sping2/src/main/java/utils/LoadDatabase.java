package utils;



import model.Persona;
import repository.PersonaRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(@Qualifier("PersonaRepository") PersonaRepositorio repository) {
        return args -> {
			log.info("Preloading " + repository.save(new Persona((long) 1234,"Seba", "Perez")));
            log.info("Preloading " + repository.save(new Persona((long) 2345, "Juan", "Dominguez")));
        };
    }
}
