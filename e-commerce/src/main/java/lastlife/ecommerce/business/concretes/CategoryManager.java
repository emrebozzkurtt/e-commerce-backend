package lastlife.ecommerce.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lastlife.ecommerce.business.abstracts.CategoryService;
import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.core.utilities.results.SuccessDataResult;
import lastlife.ecommerce.core.utilities.results.SuccessResult;
import lastlife.ecommerce.dataAccess.abstracts.CategoryDao;
import lastlife.ecommerce.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{
	private CategoryDao categoryDao;
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public Result add(Category category) {
		this.categoryDao.save(category);
		return new SuccessResult(category.getCategoryName()+" Başarıyla Eklendi");
	}

	@Override
	public Result removeById(int categoryId) {
		this.categoryDao.deleteById(categoryId);
		return new SuccessResult("Kategori Silindi");
	}

	@Override
	public Result removeByCategoryName(String categoryName) {
		this.categoryDao.deleteById(this.categoryDao.findByCategoryName(categoryName).getId());
		return new SuccessResult("Kategori Silindi");
	}

	@Override
	public DataResult<Category> findByCategoryName(String categoryName) {
		return new SuccessDataResult<Category>(this.categoryDao.findByCategoryName(categoryName), "Kategori Bulundu");
	}

	@Override
	public DataResult<List<Category>> getByCategoryNameContains(String categoryName) {
		return new SuccessDataResult<List<Category>>(this.categoryDao.getByCategoryNameContains(categoryName), "İlgili Ürünler Listelendi");
	}
	
	
}
