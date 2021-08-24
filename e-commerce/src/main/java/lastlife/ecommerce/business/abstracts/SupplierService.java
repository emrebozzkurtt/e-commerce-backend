package lastlife.ecommerce.business.abstracts;

import lastlife.ecommerce.core.utilities.results.Result;
import lastlife.ecommerce.entities.concretes.Supplier;

public interface SupplierService {
	Result add(Supplier supplier);
}
