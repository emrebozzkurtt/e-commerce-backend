package lastlife.ecommerce.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import lastlife.ecommerce.business.abstracts.SubCategoryService;
import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.core.utilities.results.SuccessDataResult;
import lastlife.ecommerce.core.utilities.results.SuccessResult;
import lastlife.ecommerce.dataAccess.abstracts.SubCategoryDao;
import lastlife.ecommerce.entities.concretes.SubCategory;

@Service
public class SubCategoryManager implements SubCategoryService {

	private SubCategoryDao subCategoryDao;

	public SubCategoryManager(SubCategoryDao subCategoryDao) {
		super();
		this.subCategoryDao = subCategoryDao;
	}

	@Override
	public DataResult<List<SubCategory>> getBySubcategoryNameContains(String subcategoryName) {
		return new SuccessDataResult<List<SubCategory>>(this.subCategoryDao.getBySubcategoryNameContains(subcategoryName),"İlgili Ürünler Listelendi");
	}

	@Override
	public Result addSubCategory(SubCategory subCategory) {
		this.subCategoryDao.save(subCategory);
		return new SuccessResult("Alt Kategori Eklendi");
	}
	
	@Override
	public Result removeSubCategory(int subcategoryId) {
		this.subCategoryDao.deleteById(subcategoryId);
		return new SuccessResult("Alt Kategori Silindi");
	}
	
	@Override
	public DataResult<List<SubCategory>> getAllSubCategories() {
		return new SuccessDataResult<List<SubCategory>>(this.subCategoryDao.findAll(), "Alt Kategoriler Listelendi");
	}

	@Override
	public DataResult<List<SubCategory>> getByCategory_CategoryName(String categoryName) {
		return new SuccessDataResult<List<SubCategory>>(this.subCategoryDao.getByCategory_CategoryName(categoryName), 
				categoryName + " Kategorisinin Alt Kategorileri");
	}

}
