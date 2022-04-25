import java.util.Date;
public class AlfredQuotes {
    Date date = new Date();
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello," + name + ". Lovely to see you." ;
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        return conversation;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    public String guestGreeting(String name,String dayPeriod) {
        // YOUR CODE HERE
     
        return dayPeriod + name + ". Lovely to see you." ;
    }
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}