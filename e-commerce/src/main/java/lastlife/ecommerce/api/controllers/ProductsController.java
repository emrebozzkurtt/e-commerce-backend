package lastlife.ecommerce.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lastlife.ecommerce.business.abstracts.ProductService;
import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.entities.concretes.Product;


@RestController
@RequestMapping(value="api/products")
public class ProductsController {
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getAllProducts")
	public DataResult<List<Product>> getAllProducts(){
		return this.productService.getAllProducts();
	}
	
	@PostMapping("/addProduct")
	public Result add(@RequestBody Product product) {
		return this.productService.addProduct(product);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}
}
