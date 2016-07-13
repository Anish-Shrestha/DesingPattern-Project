package groupfive.asd.sample;

import com.ecommerce.framework.offer.SendOffer;
import com.ecommerce.framework.offer.SendOfferDetails;
import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.userconfig.IUser;

import groupfive.asd.iterator.Iterator;
import groupfive.asd.iterator.Aggregate;
import groupfive.asd.iterator.CustomerRepository;

public class AdminSection {

	Aggregate customerRepository;

	public AdminSection(IRepository repository) {

		customerRepository = new CustomerRepository(repository);
	}

	public void proceedForAdminOperation(User user, String message) {
		System.out.println("ADMIN SECTION");

		SendOffer details = new SendOfferDetails(message);

		for (Iterator iter = customerRepository.getIterator(); iter.hasNext();) {
			details.registerCustomer((IUser) iter.next());
		}

		details.notifyCustomers();
	}
}
