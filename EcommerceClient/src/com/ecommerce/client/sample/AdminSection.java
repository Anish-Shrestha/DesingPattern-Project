package com.ecommerce.client.sample;

import com.ecommerce.framework.offer.SendOffer;
import com.ecommerce.framework.offer.SendOfferDetails;
import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.userconfig.IUser;

import java.util.Scanner;
import com.ecommerce.client.iterator.Iterator;
import com.ecommerce.client.iterator.Aggregate;
import com.ecommerce.client.iterator.CustomerRepository;

public class AdminSection {
    
    Aggregate customerRepository;
    
    public AdminSection(IRepository repository){
        
         customerRepository = new CustomerRepository(repository);
    }

   

	public void proceedForAdminOperation(User user) {
        System.out.println("ADMIN SECTION");
        Scanner scanner = new Scanner(System.in);
        Utility.printLine();
        Utility.printInlineMessage("Please Enter Offer:");
        String message = scanner.nextLine();
        SendOffer details = new SendOfferDetails(message);
        
        for(Iterator iter = customerRepository.getIterator(); iter.hasNext();){
        	details.registerCustomer((IUser)iter.next());
           
         } 	

        details.notifyCustomers();
    }
}
