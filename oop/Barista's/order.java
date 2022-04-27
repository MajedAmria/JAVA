import java.util.ArrayList;
public class order {
    private String name;
            double total;
    private boolean ready;
    private ArrayList<item> items=new ArrayList<item>();
    item item = new item();
    public order() {
        this.name = "Guest";
    }

    public order(String name) {
        this.name = name;
    }

    public void addItem(item item ){

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

    public ArrayList<item> getItem() {
        return items;
    }
    
   
    public void setItem(ArrayList<item> items) {
        this.items = items;
    }
}