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
        if(conversation.indexOf("Alexis") > -1) {
            return "She's really of no help. What can I get for you?";
        }

        if (conversation.indexOf("Alfred") > -1) {
            return "At your service, naturally. How may I be of assistance?";
        }

        return "Right. And with that I shall retire.";
    
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