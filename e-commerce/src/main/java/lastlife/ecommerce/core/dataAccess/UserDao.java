package lastlife.ecommerce.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import lastlife.ecommerce.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
