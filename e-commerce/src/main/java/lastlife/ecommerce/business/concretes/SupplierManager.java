package lastlife.ecommerce.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lastlife.ecommerce.business.abstracts.SupplierService;
import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.core.utilities.results.SuccessResult;
import lastlife.ecommerce.dataAccess.abstracts.SupplierDao;
import lastlife.ecommerce.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService{
	
	private SupplierDao supplierDao;

	@Autowired
	public SupplierManager(SupplierDao supplierDao) {
		super();
		this.supplierDao = supplierDao;
	}

	@Override
	public Result add(Supplier supplier) {
		this.supplierDao.save(supplier);
		return new SuccessResult("Tedarikçi Eklendi");
	}
	
}
