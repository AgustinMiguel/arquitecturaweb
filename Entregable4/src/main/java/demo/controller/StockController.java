package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Stock;
import demo.repository.StockRepository;


@RestController
@RequestMapping("stock1")
public class StockController  {
	@Qualifier("stockRepository")
    @Autowired
    private final StockRepository repository;
	
	public StockController(@Qualifier("stockRepository") StockRepository repository) {
		this.repository = repository;
	}
	
    @GetMapping("/")
    public Iterable<Stock> getStocks() {
        return repository.findAll();
    }
    
    @PostMapping("/")
    public Stock newStock(@RequestBody Stock s) {
        return repository.save(s);
    }
}
