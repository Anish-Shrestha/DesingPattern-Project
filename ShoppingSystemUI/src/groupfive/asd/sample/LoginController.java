package groupfive.asd.sample;

import com.ecommerce.framework.exception.AuthorizationException;
import com.ecommerce.framework.exception.UserNotFoundException;
import com.ecommerce.framework.userconfig.ILoginService;
import com.ecommerce.framework.userconfig.IUser;

public class LoginController implements ILoginController {
    private ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public String login(IUser user) {
        try {
            loginService.loginUser(user);
            return "success";
        } catch (UserNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (AuthorizationException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return "Unable to loggedIn";
    }
}
