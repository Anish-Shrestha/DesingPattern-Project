package com.ecommerce.framework.mediator;

import java.util.List;

import com.ecommerce.framework.product.Product;
import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.userconfig.IUser;


public class Mediator implements IMediator {
	IRepository repository;

	public Mediator(IRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveProduct(Product product) {

		try {
			repository.saveProduct(product);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	@Override
	public void saveUser(IUser user) {

		try {
			repository.saveUser(user);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getListOfProduct() {
	
		return repository.getListOfProduct();
	}

}
