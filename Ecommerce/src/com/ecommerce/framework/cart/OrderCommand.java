package com.ecommerce.framework.cart;


public class OrderCommand implements ICommand {

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public boolean undo() {
        return false;
    }
}
