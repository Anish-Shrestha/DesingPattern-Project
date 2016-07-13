package groupfive.asd.controller;

import java.net.URL;
import java.util.ResourceBundle;

import groupfive.asd.dataloader.DataLoader;
import groupfive.asd.presentation.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ListOfProductController implements Initializable {
	@FXML
	private ListView<String> listid = new ListView<String>();

	private ObservableList<String> items = FXCollections.observableArrayList();
	Main main = new Main();
	LoginController lc = new LoginController();
	DataLoader loader = new DataLoader(lc.repo);

	@FXML
	private void initialize() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		items = loader.loadDefaultProducts();

		listid.setItems(items);

	}
}
