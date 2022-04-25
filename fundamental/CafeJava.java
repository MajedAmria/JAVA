public class CafeJava {
    public static void main(String[] args) { 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
     
        double mochaPrice = 3.5;
        double dripcoffee = 4;
        double latte = 3;
        double cappuccino =4.5;
    
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3  = "Jimmy";
        String customer4 = "Noah";
    
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;


        System.out.println(generalGreeting + customer4); 
        
        if (isReadyOrder4==true){
            System.out.println(customer4 + readyMessage+displayTotalMessage+cappuccino);
        }
        else{
            System.out.println(customer4+pendingMessage);
        }
        System.out.println(generalGreeting + customer2); 
        if (isReadyOrder3==true){
            System.out.println(customer2 + readyMessage+displayTotalMessage+latte*2);
        }
        else{
            System.out.println(customer2+pendingMessage);
        }
    	
        System.out.println(generalGreeting + customer3); 
        if (isReadyOrder2==true && isReadyOrder3==true){
            System.out.println(customer3 + readyMessage+displayTotalMessage+(latte+dripcoffee));
        }
        else{
            System.out.println(customer3+pendingMessage);
        }
    	
    }
}