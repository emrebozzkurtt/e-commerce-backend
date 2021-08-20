package lastlife.ecommerce.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lastlife.ecommerce.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	List<Product> getByProductNameContains(String productName);
	
}
