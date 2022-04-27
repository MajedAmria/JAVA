import java.util.ArrayList;
public class test {
    public static void main(String[] args) {
    
        // Menu items
    item item1=new item("late",7.5);
    item item2=new item("coffe",3);
    item item3=new item();
    item item4=new item();

    // item1.name= " mocha";
    // item1.price=10;
    // item2.name= "latte";
    // item2.price=8.5;
    // item3.name="drip coffee";
    // item3.price=5;
    // item4.name="capuccino";
    // item4.price=6.5;
        
    order order1=new order();
    order order2=new order("majed");
    order order3=new order("maher");
    order order4=new order("reem");
    order1.addItem(item1);
    order1.setReady(false);
    order1.getStatusMessage();
    order1.display();
    order2.addItem(item2);
    order2.display();
    // order1.name="Cindhuri";
    // order1.ready=true;

    // order2.name="Jimmy";
    // order2.items.add(item1);
    // order2.total+=item1.price;
    // order2.ready=true;

    // order3.name="Noah";
    // order3.items.add(item4);
    // order3.total+=item4.price;

    // order4.name= "Sam";
    // order4.items.add(item2);
    // order4.items.add(item2);
    // order4.total+=item2.price;

    //     System.out.printf("Name: %s\n", order1.name);
    //     System.out.printf("Ready: %s\n", order1.ready);

    //     System.out.printf("Name: %s\n", order2.name);
    //     System.out.printf("Ready: %s\n", order2.ready);
    //     System.out.printf("Total: %s\n", order2.total);
        
    //     System.out.printf("Name: %s\n", order3.name);
    //     System.out.printf("Ready: %s\n", order3.ready);
    //     System.out.printf("Total: %s\n", order3.total);

    //     System.out.printf("Name: %s\n", order4.name);
    //     System.out.printf("Ready: %s\n", order4.ready);
        // System.out.printf("Total: %s\n", order4.total);
    }
}