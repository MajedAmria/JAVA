package Coffeedore;

import java.util.ArrayList;

public class CoffeeKiosk {
    ArrayList<Item> menu = new ArrayList<>();
    ArrayList<Order> orders =new ArrayList<>();
    Item item = new Item();
    Order order = new Order();

    public CoffeeKiosk(){

    }

    public void addMenuItem(Item item ){
        this.menu.add(item);
    }
}