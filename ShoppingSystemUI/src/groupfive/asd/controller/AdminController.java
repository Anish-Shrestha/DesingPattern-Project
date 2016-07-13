package groupfive.asd.controller;

import com.ecommerce.framework.context.Ecommerce;

import groupfive.asd.iterator.Aggregate;
import groupfive.asd.iterator.CustomerRepository;
import groupfive.asd.sample.AdminSection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AdminController extends Ecommerce {
	@FXML
	public Button btnSend;
	@FXML
	private TextField txtmessage;

	@FXML
	private ListView<String> notifications = new ListView<String>();
	public static ObservableList<String> list = FXCollections.observableArrayList();
	@FXML
	private void initialize() {


		btnSend.setOnAction((event) -> {
	
			String offer = txtmessage.getText();
		
		    AdminSection adminSection = new AdminSection(repository);
	        adminSection.proceedForAdminOperation(LoginController.getUser(),offer);
	    	list.add(offer+ "Offer sent to all Customers");
			notifications.setItems(list);
		});
	}

	@Override
	protected void start() {
		// TODO Auto-generated method stub

	}

}
