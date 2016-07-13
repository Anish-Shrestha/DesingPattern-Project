package com.ecommerce.framework.cart;


public interface ICommand {

    boolean execute();
    boolean undo();

}
