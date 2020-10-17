package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Compra;
import demo.repository.CompraRepository;

@RestController
@RequestMapping("compra1")
public class CompraController {
	@Qualifier("compraRepository")
    @Autowired
    private final CompraRepository repository;

	public CompraController(@Qualifier("compraRepository") CompraRepository repository) {
		this.repository = repository;
	}
	
    @GetMapping("/")
    public Iterable<Compra> getCompras() {
        return repository.findAll();
    }
    
    @PostMapping("/")
    public Compra newCompra(@RequestBody Compra c) {
        return repository.save(c);
    }
 }
