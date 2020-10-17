package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Producto;
import demo.repository.ProductoRepository;

@RestController
@RequestMapping("producto1")
public class ProductoController {
	@Qualifier("productoRepository")
    @Autowired
    private final ProductoRepository repository;

	public ProductoController(@Qualifier("productoRepository") ProductoRepository repository) {
		this.repository = repository;
	}
	
    @GetMapping("/")
    public Iterable<Producto> getProductos() {
        return repository.findAll();
    }
    
    @PostMapping("/")
    public Producto newProducto(@RequestBody Producto p) {
        return repository.save(p);
    }
}
