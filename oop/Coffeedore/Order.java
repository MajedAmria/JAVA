package Coffeedore;
import java.util.ArrayList;

public class Order {
    private String name;
            double total;
    private boolean ready;
    private ArrayList<Item> items=new ArrayList<Item>();
    Item item = new Item();
    public Order() {
        this.name = "Guest";
    }

    public Order(String name) {
        this.name = name;
    }

    public void addItem(Item item ){

        this.items.add(item);
    }

    public void getStatusMessage(){
        if(this.ready==true){
            System.out.println("Your order is ready.");
        }
        else{
            System.out.println("Thank you for waiting. Your order will be ready soon.");
        }
    }
     
    public void display(){
        
        System.out.println("Customer Name: "+this.name);
        for(int i=0; i<items.size();i++){

             System.out.println(items.get(i).getName()+"-"+items.get(i).getPrice());
        }
        System.out.println("Total: "+getOrderTotal());

    }
    public double getOrderTotal(){
        double total= 0.0;
        total+=item.getPrice();
      
        return total;
    }
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;       
    }

    public boolean getReady() {
        return ready;
    }
    
   
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItem() {
        return items;
    }
    
   
    public void setItem(ArrayList<Item> items) {
        this.items = items;
    }
}