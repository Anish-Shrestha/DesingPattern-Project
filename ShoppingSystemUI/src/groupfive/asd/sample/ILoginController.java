package groupfive.asd.sample;

import com.ecommerce.framework.logger.AbstractLogger;
import com.ecommerce.framework.logger.LoggerBuilder;
import com.ecommerce.framework.userconfig.IUser;

public interface ILoginController {
    static AbstractLogger logger =  LoggerBuilder.getLogger();
    public String login(IUser user) throws Exception;
}
