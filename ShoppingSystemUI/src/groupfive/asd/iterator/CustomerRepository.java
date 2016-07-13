package groupfive.asd.iterator;

import java.util.List;

import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.userconfig.IUser;

public class CustomerRepository implements Aggregate {
	private IRepository repository;

	public CustomerRepository(IRepository repository) {
		this.repository = repository;
	}

	@Override
	public Iterator getIterator() {

		return new CustomerIterator();
	}

	private class CustomerIterator implements Iterator {
		int index;
		List<IUser> lst = repository.getListOfUser();

		@Override
		public boolean hasNext() {

			if (index < lst.size())
				return false;
			return false;
		}

		@Override
		public Object next() {
			if (this.hasNext())
				return lst.get(index);
			return null;
		}

	}

}
