package groupfive.asd.sample;

import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.repository.Repository;
import com.ecommerce.framework.userconfig.ILoginService;
import com.ecommerce.framework.userconfig.IUser;

public class LoginControllerProxy implements ILoginController {
	private LoginController loginController;
	private IRepository repository;

	public LoginControllerProxy(ILoginService loginService) {
		loginController = new LoginController(loginService);
		repository = Repository.getInstance();
	}

	@Override
	public String login(IUser user) throws Exception {
		String isLoggedIn = loginController.login(user);

		return isLoggedIn;
	}

}
