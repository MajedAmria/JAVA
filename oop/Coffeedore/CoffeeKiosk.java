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
        item.setName("coffee");
        item.setPrice(5.5);
        this.menu.add(item);
    }
    
    public void displayMenu(){
        for(int i=0; i<menu.size();i++){

            System.out.println(menu.get(i).getName()+"-"+menu.get(i).getPrice());
       }
    }
}