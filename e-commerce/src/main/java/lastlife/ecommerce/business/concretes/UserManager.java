package lastlife.ecommerce.business.concretes;

import org.springframework.stereotype.Service;

import lastlife.ecommerce.business.abstracts.UserService;
import lastlife.ecommerce.core.dataAccess.UserDao;
import lastlife.ecommerce.core.entities.User;
import lastlife.ecommerce.core.utilities.results.DataResult;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.core.utilities.results.SuccessDataResult;
import lastlife.ecommerce.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklenildi.");
	}
	
	@Override
	public Result remove(String email) {
		this.userDao.deleteById(this.userDao.findByEmail(email).getId());
		return new SuccessResult("Kullanıcı Silindi.");
	}


	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Kullanıcı Bulundu.");
	}

	

}
