package lastlife.ecommerce.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lastlife.ecommerce.business.abstracts.ProductService;
import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.core.utilities.results.SuccessDataResult;
import lastlife.ecommerce.core.utilities.results.SuccessResult;
import lastlife.ecommerce.dataAccess.abstracts.ProductDao;
import lastlife.ecommerce.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	@Override
	public DataResult<List<Product>> getAllProducts() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Ürünler Listelendi");
	}

	@Override
	public Result addProduct(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Başarıyla Eklendi");
	}
	

	@Override
	public Result removeProduct(int productId) {
		this.productDao.deleteById(productId);
		return new SuccessResult("Ürün Başarıyla Silindi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "İlgili Ürünler");
	}

	@Override
	public DataResult<List<Product>> getAllProductSortedASC() {
		Sort sort = Sort.by(Sort.Direction.ASC, "unitPrice");
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Ürünler Küçükten Büyüğe Listelendi");
	}
	
	@Override
	public DataResult<List<Product>> getAllProductSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC, "unitPrice");
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Ürünler Büyükten Küçüğe Listelendi");
	}
	
	public DataResult<List<Product>> getBySubCategory_SubcategoryName(String subcategoryName){
		return new SuccessDataResult<List<Product>>(this.productDao.getBySubCategory_SubcategoryName(subcategoryName), 
				subcategoryName+" Kategorisindeki Ürünler Listelendi");
	}

}
