package lastlife.ecommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lastlife.ecommerce.business.abstracts.CategoryService;
import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.entities.concretes.Category;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {

	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@PostMapping("/addCategory")
	public Result add(Category category) {
		return this.categoryService.add(category);
	}
	
	@DeleteMapping("/removeCategoryById")
	public Result removeById(int categoryId) {
		return this.categoryService.removeById(categoryId);
	}
	
	@DeleteMapping("/removeCategoryByCategoryName")
	public Result removeByCategoryName(String categoryName) {
		return this.categoryService.removeByCategoryName(categoryName);
	}
	
	@GetMapping("/findByCategoryName")
	public DataResult<Category> findByCategoryName(String categoryName) {
		return this.categoryService.findByCategoryName(categoryName);
	}
	
	@GetMapping("/getByCategoryNameContains")
	public DataResult<List<Category>> getByCategoryNameContains(String categoryName) {
		return this.categoryService.getByCategoryNameContains(categoryName);
	}
}
