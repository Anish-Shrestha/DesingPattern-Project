package com.ecommerce.framework.mediator;

import java.util.List;

import com.ecommerce.framework.product.Product;
import com.ecommerce.framework.userconfig.IUser;


public interface IMediator {
	public void saveProduct(Product product);
	public void saveUser(IUser user);
	public List<Product> getListOfProduct();
	
}
