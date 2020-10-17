package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Cliente;
import demo.repository.ClienteRepository;

@RestController
@RequestMapping("cliente1")
public class ClienteController {
	 	@Qualifier("clienteRepository")
	    @Autowired
	    private final ClienteRepository repository;

		public ClienteController(@Qualifier("clienteRepository") ClienteRepository repository) {
			this.repository = repository;
		}
	 	
	    @GetMapping("/")
	    public Iterable<Cliente> getClientes() {
	        return repository.findAll();
	    }
	    
	    @PostMapping("/")
	    public Cliente newCliente(@RequestBody Cliente c) {
	        return repository.save(c);
	    }
}
