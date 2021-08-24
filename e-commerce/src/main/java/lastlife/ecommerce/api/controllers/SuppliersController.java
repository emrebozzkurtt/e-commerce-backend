package lastlife.ecommerce.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lastlife.ecommerce.business.abstracts.SupplierService;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.entities.concretes.Supplier;

@RestController
@RequestMapping("api/suppliers")
public class SuppliersController {
	
	private SupplierService supplierService;
	
	@Autowired
	public SuppliersController(SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
	}
	
	@PostMapping("/addSupplier")
	public Result add(@RequestBody Supplier supplier) {
		return this.supplierService.add(supplier);
	}
}
