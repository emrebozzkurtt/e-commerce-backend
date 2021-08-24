package lastlife.ecommerce.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lastlife.ecommerce.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	Category findByCategoryName(String categoryName);
	
	List<Category> getByCategoryNameContains(String categoryName);
	
}
