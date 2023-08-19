import java.util.HashMap;
import java.util.Set;

public class Hashmatique{
    public static void main(String[] args){
        HashMap<String,String> trackList = new HashMap<String,String>();
        trackList.put("Before I Forget", "Before I forget that!");
        trackList.put("Starway to Heaven", "Build a starway to heaven");
        trackList.put("I Miss You", "Don't waste your time, cuz' you're already the voice inside my head");
        trackList.put("Walk", "Walk!");

        Set<String> keys = trackList.keySet();
        for(String key : keys){
            System.out.println(key+': '+trackList.get(key));
        }
    }
}