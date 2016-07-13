package groupfive.asd.controller;

import java.util.Calendar;

import com.ecommerce.framework.cart.Order;
import com.ecommerce.framework.context.Ecommerce;
import com.ecommerce.framework.payment.CreditCard;
import com.ecommerce.framework.payment.DebitCard;
import com.ecommerce.framework.payment.PaymentContext;
import com.ecommerce.framework.shipment.IShipOrder;
import com.ecommerce.framework.shipment.IShippingFactory;
import com.ecommerce.framework.shipment.ShippingFactory;

import groupfive.asd.dataloader.DataLoader;
import groupfive.asd.presentation.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaymentController extends Ecommerce {
	public static ObservableList<String> result = FXCollections.observableArrayList();
	@FXML
	private TextField txtCardType;
	@FXML
	private TextField txtCardName;
	@FXML
	private TextField txtCardNumber;
	@FXML
	private TextField txtExpireDate;

	@FXML
	private ListView<String> productlist = new ListView<String>();
	@FXML
	public Button btnMakePayment;
	DataLoader loader = new DataLoader(repository);

	@FXML
	private void initialize() {
		Order order = UserDashboardController.shoppingCart.createOrder();
		UserDashboardController.getCartList().add("=================================");
		UserDashboardController.getCartList().add(order.toString());
		productlist.setItems(UserDashboardController.getCartList());

		btnMakePayment.setOnAction((event) -> {

			String cardtype = txtCardType.getText();
			String cardName = txtCardName.getText();
			String cardnumber = txtCardNumber.getText();
			String expiredate = txtExpireDate.getText();

			PaymentContext paymentContext = new PaymentContext();
			Calendar cal = Calendar.getInstance();
			cal.clear();
			cal.set(2015, Calendar.JANUARY, 21);
			switch (cardtype.toLowerCase()) {
			case "debit":
				paymentContext.setPaymentMethod(new DebitCard(name, cardnumber, cal.getTime()));
				break;
			case "credit":
				paymentContext.setPaymentMethod(new CreditCard(name, cardnumber, cal.getTime()));
				break;
			}

			result.add(paymentContext.makePayment(order.getTotalPrice()));
			result.add("************ ORDER DELIVERY THROUGH FEDEX ************");
			result.add("************ ThankYou ************");
			IShippingFactory shippingFactory = new ShippingFactory();
			IShipOrder shipOrder = shippingFactory.getShippingAddress("fedex");
			shipOrder.shipOrder(order);
			Main m = new Main();
			Stage stage = (Stage) btnMakePayment.getScene().getWindow();
			stage.close();
			m.showResult();

		});

	}

	@Override
	protected void start() {

	}

	public static ObservableList<String> getResult() {
		return result;
	}
}
