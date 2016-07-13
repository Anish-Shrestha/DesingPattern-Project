package groupfive.asd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.framework.cart.AShoppingCart;
import com.ecommerce.framework.cart.AddToCart;
import com.ecommerce.framework.cart.ICommand;
import com.ecommerce.framework.cart.ShoppingCart;
import com.ecommerce.framework.cart.ShoppingCartItem;
import com.ecommerce.framework.cart.ShoppingCartOperator;
import com.ecommerce.framework.context.Ecommerce;
import com.ecommerce.framework.product.Product;

import groupfive.asd.dataloader.DataLoader;
import groupfive.asd.presentation.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class UserDashboardController extends Ecommerce {
	ObservableList<String> productdata;
	@FXML
	private ListView<String> productlistdata = new ListView<String>();
	public static ObservableList<String> list = FXCollections.observableArrayList();
	@FXML
	private ListView<String> cartlist = new ListView<String>();
	@FXML
	private ListView<String> productdetaillist = new ListView<String>();
	@FXML
	public Button btnaddtocart;
	@FXML
	public Button btncheckout;

	Main main = new Main();
	DataLoader loader = new DataLoader(repository);
	public static ShoppingCart shoppingCart = new ShoppingCart(LoginController.getUser());

	public UserDashboardController() {
		productdata = loader.loadDefaultProducts();
	}

	@FXML
	private void initialize() {
		productdata = loader.loadDefaultProducts();
		productlistdata.setItems(productdata);

		productlistdata.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {

				productdetaillist.setItems(loader.loadSelectedProduct(newSelection));
			}
		});

		btnaddtocart.setOnAction((event) -> {
			System.out.println(productlistdata.getSelectionModel().getSelectedItems().get(0));

			product = loader.getProduct(productlistdata.getSelectionModel().getSelectedItems().get(0));

			ICommand command = new AddToCart(shoppingCart, product);

			ShoppingCartOperator operator = new ShoppingCartOperator(command);
			operator.addToCart();

			List<ShoppingCartItem> data = shoppingCart.getCart();
			ObservableList<String> vm = FXCollections.observableArrayList();
			list.clear();
			for (ShoppingCartItem sci : data) {
				list.add("Product: " + sci.getProduct().getName() + " Quantity: " + sci.getQuantity());
				vm.add("Product: " + sci.getProduct().getName() + " Quantity: " + sci.getQuantity());
			}
			cartlist.setItems(vm);

		});

		btncheckout.setOnAction((event) -> {
			Main m = new Main();
			Stage stage = (Stage) btncheckout.getScene().getWindow();

			stage.close();
			m.showPayment();

		});

	}

	public static ObservableList<String> getCartList() {
		return list;
	}

	@Override
	protected void start() {

	}

}
