package demo.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Producto;
import demo.repository.ProductoRepository;

@RestController
@RequestMapping("producto")
public class ProductoController {
	@Qualifier("productoRepository")
	@Autowired
	private final ProductoRepository repository;

	public ProductoController(@Qualifier("productoRepository") ProductoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/getAll")
	public Iterable<Producto> getProductos() {
		return repository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Producto> getProducto(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@GetMapping("/masVendido")
	public Producto getProductoMasVendido() {
		int total = 0;
		int maxTotal = 0;
		Producto productoMasVendido = new Producto();
		List<Producto> productos = repository.productos();
		for(Producto p: productos) {
			for(Producto p1: productos) {
				if(p.equals(p1)) {
					total++;
				}
			}
			if(total > maxTotal) {
				maxTotal = total;
				productoMasVendido = p;
			}
			total =0;
		}
		return productoMasVendido;
	}
	
	 @PostMapping("/add") public Producto newProducto(@RequestBody Producto p) {
	 return repository.save(p);
	 }
	 
	 @PutMapping("/update/{id}") public Producto updateProducto(@RequestBody Producto p, @PathVariable Long id) {
	        return repository.findById(id)
	                .map(producto -> {
	                    producto.setNombre(p.getNombre());
	                    producto.setPrecio(p.getPrecio());
	                    return repository.save(producto);
	                })
	                .orElseGet(() -> {
	                    p.setId(id);
	                    return repository.save(p);
	                });
	 }
	 
	@DeleteMapping("/delete/{id}")
	 void deleteProducto(@PathVariable Long id) {
	        repository.borrarStockProducto(id);
	    }
	
	 
	 
}
