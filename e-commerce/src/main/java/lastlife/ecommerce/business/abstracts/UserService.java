package lastlife.ecommerce.business.abstracts;

import lastlife.ecommerce.core.entities.User;
import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	Result remove(String email);
	
	DataResult<User> findByEmail(String email);
}
