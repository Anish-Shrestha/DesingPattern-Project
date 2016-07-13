package groupfive.asd.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ResultController {
	@FXML
	private ListView<String> finalresult = new ListView<String>();

	@FXML
	private void initialize() {
		System.out.println("test");
		ObservableList<String> list = PaymentController.getResult();
		finalresult.setItems(list);
	}
}
