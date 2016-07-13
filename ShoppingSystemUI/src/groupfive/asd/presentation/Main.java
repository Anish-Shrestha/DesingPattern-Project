package groupfive.asd.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import groupfive.asd.controller.AdminController;
import groupfive.asd.controller.UserDashboardController;

public class Main extends Application {
	public Stage primaryStage;
	private Stage rootStage = new Stage();
	private BorderPane rootLayout;

	public void sendOffer() {
		try {
			this.rootStage.setTitle("Shopping System");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			rootStage.setScene(scene);
			rootStage.show();
			FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("SendNotification.fxml"));
			AnchorPane overviewPage = (AnchorPane) loader2.load();
			Scene scene2 = new Scene(overviewPage);
			rootStage.setMaximized(true);
			rootLayout.setCenter(overviewPage);

			AdminController controller = loader2.getController();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		this.primaryStage.setTitle("Shopping System");

		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("login.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void Dashboard() {
		try {

			this.rootStage.setTitle("Shopping System");
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			rootStage.setScene(scene);
			rootStage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}
		// showMessageWindow();
		showDashboard();
	}

	public void showDashboard() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("userDashboard.fxml"));
			AnchorPane overviewPage = (AnchorPane) loader.load();
			Scene scene = new Scene(overviewPage);
			rootStage.setMaximized(true);
			rootLayout.setCenter(overviewPage);

			UserDashboardController controller = loader.getController();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPayment() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("paymentform.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			// rootLayout.setCenter(page);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showResult() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("result.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			Stage ps = new Stage();
			ps.setScene(scene);
			ps.show();
			// rootLayout.setCenter(page);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}