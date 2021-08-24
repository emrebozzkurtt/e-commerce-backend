package lastlife.ecommerce.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lastlife.ecommerce.entities.concretes.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer>{
	
	List<SubCategory> getBySubcategoryNameContains(String subcategoryName);
	
	List<SubCategory> getByCategory_CategoryName(String categoryName);
	
}
