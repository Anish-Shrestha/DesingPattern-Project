package com.ecommerce.client.sample;

import com.ecommerce.framework.logger.AbstractLogger;
import com.ecommerce.framework.logger.LoggerBuilder;
import com.ecommerce.framework.userconfig.IUser;

public interface ILoginController {
    static AbstractLogger logger =  LoggerBuilder.getLogger();
    public boolean login(IUser user) throws Exception;
}
