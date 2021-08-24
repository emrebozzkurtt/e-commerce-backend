package lastlife.ecommerce.business.abstracts;

import java.util.List;

import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.entities.concretes.SubCategory;

public interface SubCategoryService {
	
	Result addSubCategory(SubCategory subCategory);
	
	Result removeSubCategory(int subcategoryId);
	
	DataResult<List<SubCategory>> getAllSubCategories();
	
	DataResult<List<SubCategory>> getBySubcategoryNameContains(String subcategoryName);
	
	DataResult<List<SubCategory>> getByCategory_CategoryName(String categoryName);
}
