import java.util.Set;
import java.util.HashMap;
public class Test {
	public static void main(String[] args) {

		int[] populationTotals = new int[255];
			String[] fruits = {"banana", "pear", "papaya", "kiwi"};
			// To swap the value at index 0 and index 3
			String temp = fruits[0]; // assigns temp to "banana"
			fruits[0] = fruits[3]; // { "kiwi", "pear", "papaya", "kiwi"}
			fruits[3] = temp; // { "kiwi", "pear", "papaya", "banana"}

			System.out.println(fruits.length); // 4
			// Array is currently { "kiwi", "pear", "papaya", "banana" }
			System.out.println(fruits[fruits.length - 1]); // "banana"

			for (int i=0 ; i <fruits.length ; i++){
				System.out.print(fruits[i]+" ");
			}
			HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("nninja@codingdojo.com", "Nancy Ninja");
        userMap.put("ssamurai@codingdojo.com", "Sam Samurai");
        userMap.put("wwizard@codingdojo.com", "Walter Wizard");
		System.out.println(userMap);
        // get the keys by using the keySet method
        Set<String> keys = userMap.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(userMap.get(key));    
        }
	}
}