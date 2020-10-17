package demo.utils;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.model.Compra;
import demo.model.Producto;
import demo.repository.ClienteRepository;
import demo.repository.CompraRepository;
import demo.repository.ProductoRepository;

@Configuration
@Slf4j
class LoadDatabase {
	 @Bean
    CommandLineRunner addProductos(@Qualifier("productoRepository") ProductoRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Producto((int) 1, "Cepita",(double) 75)));
            log.info("Preloading " + repository.save(new Producto((int) 2, "Fideos", (double) 76)));
            log.info("Preloading " + repository.save(new Producto((int) 3, "Arroz", (double) 15)));
            log.info("Preloading " + repository.save(new Producto((int) 4, "Cocacola", (double) 90)));
            log.info("Preloading " + repository.save(new Producto((int) 5, "Porongol", (double) 55)));
            log.info("Preloading " + repository.save(new Producto((int) 6, "Caramelo", (double) 2)));
        };
    }
	    CommandLineRunner addCompras(@Qualifier("compraRepository") CompraRepository repository) {
	        return args -> {
	            log.info("Preloading " + repository.save(new Compra((int) 1,(Date) 17-10-2020)));
	        };
	    }
	 
}