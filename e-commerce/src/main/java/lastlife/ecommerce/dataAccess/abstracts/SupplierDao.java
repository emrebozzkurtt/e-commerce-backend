package lastlife.ecommerce.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import lastlife.ecommerce.entities.concretes.Supplier;

public interface SupplierDao extends JpaRepository<Supplier, Integer> {

}
