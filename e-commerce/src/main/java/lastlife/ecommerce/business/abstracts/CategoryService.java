package lastlife.ecommerce.business.abstracts;

import java.util.List;

import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.entities.concretes.Category;

public interface CategoryService {
	
	Result add(Category category);
	
	Result removeById(int categoryId);
	
	Result removeByCategoryName(String categoryName);
	
	DataResult<Category> findByCategoryName(String categoryName);
	
	DataResult<List<Category>> getByCategoryNameContains(String categoryName);
	
}
