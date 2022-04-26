import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {


    public ArrayList<Integer> getTenRolls() {

        ArrayList<Integer> random = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 0; i <10; i++) {
            random.add(rand.nextInt(20));
        }

        return random;
    }
    public char getRandomLetter(){
        Random random = new Random();
      
        char[] arr={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        return arr[random.nextInt(26)];
    }

    public String generatePassword(){
        String str="";
        for (int i = 0; i <8; i++) {
          str=str + getRandomLetter();
        }
        return str;
    }
    public ArrayList<String> getNewPasswordSet(int length){

        ArrayList<String> passwords=new ArrayList<String>();
        for(int i=0;i<length;i++){
            passwords.add(generatePassword());
        }

     return passwords;
    }
}
