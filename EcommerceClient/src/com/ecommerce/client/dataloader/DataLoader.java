package com.ecommerce.client.dataloader;

import com.ecommerce.client.sample.Address;
import com.ecommerce.client.sample.RoleType;
import com.ecommerce.client.sample.User;
import com.ecommerce.framework.mediator.IMediator;
import com.ecommerce.framework.mediator.Mediator;
import com.ecommerce.framework.product.CatalogComponent;
import com.ecommerce.framework.product.Product;
import com.ecommerce.framework.product.ProductCatalog;
import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.userconfig.IAddress;
import com.ecommerce.framework.userconfig.IUser;

public class DataLoader {
	IMediator mediator;

	public DataLoader(IRepository repository) {
		mediator = new Mediator(repository);
	}

	public void saveDefaultUsers() {
		try {
			IAddress billingAddress = new Address("1000N 4TH Street", "Fairfield", "IA", "52557");
			IAddress shippingAddress = new Address("1000N 4TH Street MR 623", "Fairfield", "IA", "52557");
			IUser user1 = new User("jack", "password", "Jack", "jack7@gmail.com", billingAddress, shippingAddress,
					RoleType.CUSTOMER);

			IAddress shippingAddress2 = new Address("1000N 4TH Street MR 629", "Fairfield", "IA", "52557");
			IUser user2 = new User("john", "password", "john", "john@gmail.com", billingAddress, shippingAddress2,
					RoleType.CUSTOMER);

			IAddress shippingAddress3 = new Address("1000N 4TH Street MR 636", "Fairfield", "IA", "52557");
			IUser user3 = new User("admin", "admin", "Meweal", "meweal@gmail.com", billingAddress, shippingAddress,
					RoleType.ADMIN);

			mediator.saveUser(user1);
			mediator.saveUser(user2);
			mediator.saveUser(user3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void loadDefaultProducts() {
		try {
			/* Create primary products for male catalog */
			CatalogComponent electronic1 = new Product("PROD001", "Laptop", 765.00, 10, true);
			CatalogComponent electronic2 = new Product("PROD002", "Mobile", 165.00, 10, true);
			mediator.saveProduct(new Product("PROD001", "Laptop", 765.00, 10, true));
			mediator.saveProduct(new Product("PROD002", "Mobile", 165.00, 10, true));

			/* Create a composite product catalog and add Male products to it */
			CatalogComponent maleCatalog = new ProductCatalog("Male Products");
			CatalogComponent malesJeanProduct = new Product("PROD003", "M: Jeans 32", 65.00, 10, true);
			CatalogComponent malesTShirtProduct = new Product("PROD004", "M: T Shirt 38", 45.00, 10, true);
			maleCatalog.add(malesJeanProduct);
			maleCatalog.add(malesTShirtProduct);
			mediator.saveProduct(new Product("PROD003", "M: Jeans 32", 65.00, 10, true));
			mediator.saveProduct(new Product("PROD004", "M: T Shirt 38", 45.00, 10, true));

			/*
			 * Create a composite product catalog and add female products to it
			 */
			CatalogComponent femaleCatalog = new ProductCatalog("Female Products");
			CatalogComponent fJeans = new Product("PROD005", "F: Jeans 32", 65.00, 10, true);
			CatalogComponent fTShirts = new Product("PROD006", "F: T Shirt 38", 45.00, 10, true);
			femaleCatalog.add(fJeans);
			femaleCatalog.add(fTShirts);
			mediator.saveProduct(new Product("PROD005", "F: Jeans 32", 65.00, 10, true));
			mediator.saveProduct(new Product("PROD006", "F: T Shirt 38", 45.00, 10, true));

			/* Create a composite product catalog and add kid products to it */
			CatalogComponent kidCatalog = new ProductCatalog("Kids Products");
			CatalogComponent kidShorts = new Product("PROD007", "Return Gift", 23.00, 10, true);
			CatalogComponent kidPlayGears = new Product("PROD008", "Summer Play Gear", 65.00, 10, true);
			CatalogComponent kidPlayBalls = new Product("PROD009", "Balls", 20.00, 10, true);
			kidCatalog.add(kidShorts);
			kidCatalog.add(kidPlayGears);
			mediator.saveProduct(new Product("PROD007", "Return Gift", 23.00, 10, true));
			mediator.saveProduct(new Product("PROD008", "Summer Play Gear", 65.00, 10, true));
			mediator.saveProduct(new Product("PROD009", "Balls", 20.00, 10, true));

			/*
			 * Create primary catalog and add primary products and new catalogs
			 * to it
			 */
			CatalogComponent mainCatalog = new ProductCatalog("Primary Catalog");
			mainCatalog.add(electronic1);
			mainCatalog.add(electronic2);
			mainCatalog.add(maleCatalog);
			mainCatalog.add(femaleCatalog);
			mainCatalog.add(kidCatalog);

			/* Print out product/catalog information */
			// mainCatalog.print();
			for (CatalogComponent catalogComponent : mainCatalog.getChilds()) {
				if (catalogComponent.hasChildren()) {
					System.out.println("==========" + catalogComponent.getName() + "==========");
					for (CatalogComponent childComponent : catalogComponent.getChilds()) {
						if (!childComponent.hasChildren()) {
							System.out.println(childComponent);
						}
					}
				} else {
					System.out.println(catalogComponent);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
