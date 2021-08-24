package lastlife.ecommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lastlife.ecommerce.business.abstracts.SubCategoryService;
import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.entities.concretes.SubCategory;

@RestController
@RequestMapping(value="api/subcategories")
public class SubCategoriesController {

	private SubCategoryService subCategoryService;

	@Autowired
	public SubCategoriesController(SubCategoryService subCategoryService) {
		super();
		this.subCategoryService = subCategoryService;
	}
	
	@GetMapping("/getBySubcategoryNameContains")
	public DataResult<List<SubCategory>> getBySubcategoryNameContains(@RequestParam String subcategoryName){
		return this.subCategoryService.getBySubcategoryNameContains(subcategoryName);
	}
	
	@PostMapping(value="/addSubCategory")
	public Result addSubCategory(@RequestBody SubCategory subCategory) {
		return this.subCategoryService.addSubCategory(subCategory);
	}
	
	@GetMapping("/getAllSubCategories")
	public DataResult<List<SubCategory>> getAllSubCategories(){
		return this.subCategoryService.getAllSubCategories();
	}
	
	@GetMapping("/getByCategory_CategoryName")
	public DataResult<List<SubCategory>> getByCategory_CategoryName(@RequestParam String categoryName){
		return this.subCategoryService.getByCategory_CategoryName(categoryName);
	}
	
	@DeleteMapping(value="/removeSubCategory")
	public Result removeSubCategory(@RequestParam int subcategoryId) {
		return this.subCategoryService.removeSubCategory(subcategoryId);
	}
}
