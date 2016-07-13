package groupfive.asd.controller;

import groupfive.asd.sample.CustomerSection;
import groupfive.asd.sample.LoginControllerProxy;
import groupfive.asd.sample.RoleType;
import groupfive.asd.sample.User;

import groupfive.asd.dataloader.DataLoader;
import com.ecommerce.framework.context.Ecommerce;
import com.ecommerce.framework.logger.AbstractLogger;
import com.ecommerce.framework.repository.IRepository;

import groupfive.asd.presentation.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController extends Ecommerce {
	@FXML
	private Text message;
	@FXML
	private TextField userId;
	@FXML
	private PasswordField password;
	@FXML
	public Button submit;
	public IRepository repo = repository;

	public IRepository getRepo() {
		return repo;
	}

	private static User user;

	@FXML
	public void Submit(ActionEvent event) {
		DataLoader loader = new DataLoader(repo);
		loader.saveDefaultUsers();

		String username = userId.getText();
		String userpassword = password.getText();

		user = new User(username, userpassword);
		logger.logMessage(AbstractLogger.INFO, "Authenticating User");
		LoginControllerProxy loginController = new LoginControllerProxy(loginService);
		try {
			String returnMessage = loginController.login(user);
			System.out.println(returnMessage);
			if (returnMessage.contains("success")) {

				User loadedUser = (User) repository.getUserFromUserName(user.getUsername());
				if (loadedUser.getRoleType().equals(RoleType.CUSTOMER)) {

					CustomerSection customerSection = new CustomerSection(repository);

					Main m = new Main();
					Stage stage = (Stage) submit.getScene().getWindow();
					stage.close();
					m.Dashboard();

				} else {

					Main m = new Main();
					Stage stage = (Stage) submit.getScene().getWindow();
					stage.close();
					m.sendOffer();
				}
			}

			else {
				message.setText(returnMessage);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public LoginController() {

	}

	public void initialize() {

	}

	@Override
	protected void start() {

	}

	public static User getUser() {
		return user;
	}
}
