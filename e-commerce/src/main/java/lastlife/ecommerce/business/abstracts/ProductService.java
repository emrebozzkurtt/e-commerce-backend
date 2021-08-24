package lastlife.ecommerce.business.abstracts;

import java.util.List;

import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.entities.concretes.Product;

public interface ProductService {
	
	Result addProduct(Product product);
	
	Result removeProduct(int productId);
	
	DataResult<List<Product>> getAllProducts();
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getAllProductSortedASC();	
	
	DataResult<List<Product>> getAllProductSortedDESC();
	
	DataResult<List<Product>> getBySubCategory_SubcategoryName(String subcategoryName);
}
