import java.util.HashMap;
import java.util.Set;
public class matique {
    public static void main(String[] args) {

        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("song1", "one");
        trackList.put("song2", "two");
        trackList.put("song3", "three");
        trackList.put("song4", "four");
        trackList.remove("song2");
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key +":"+ trackList.get(key));    
        }

    }
}
