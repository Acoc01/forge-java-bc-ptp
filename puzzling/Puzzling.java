import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzling{
    public ArrayList<Integer> SumAndGreatherTen(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(13);
        arr.add(25);
        arr.add(32);

        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        System.out.println("Suma: "+sum);
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        for(int i = 0; i < 10; ++i){
            arr2.add(i);
        }
        arr.removeAll(arr2);
        // System.out.println(arr);
        return arr;
    }

    public ArrayList<String> ShuffleNames(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        Collections.shuffle(names);
        for(String i : names)
            System.out.println("Nombre: "+i);
        ArrayList<String> names2 = new ArrayList<String>(names.size());
        for(String i : names)
            names2.add(i);
        names2.removeIf(n -> (n.length() <= 5));
        return names2;
    }

    public void ShuffleChars(){
        ArrayList<Character> chars = new ArrayList<Character>();
        for(char i = 'a'; i <= 'z'; ++i)
            chars.add(i);
        
        Collections.shuffle(chars);
        System.out.println("Ultima letra: "+chars.get(chars.size()-1));
        System.out.println("Primera letra: "+chars.get(0));
        char f = chars.get(0);
        if(f == 'a' || f == 'e' || f == 'i' || f == 'o' || f == 'u'){
            System.out.println("La primera letra es vocal");
        }
    }

    public ArrayList<Integer> RandomInteger(){
        Random rand = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < 10; ++i){
            arr.add(rand.nextInt(100 - 55) + 55);
        }
        return arr;
    }
    public ArrayList<Integer> SortedRandomInteger(){
        Random rand = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < 10; ++i){
            arr.add(rand.nextInt(100 - 55) + 55);
        }
        Collections.sort(arr);
        return arr;
    }
    public void RandomString(){
        String str = "";
        Random rand = new Random();
        for(int i = 0; i < 5; ++i){
            str += (char)(rand.nextInt(26) + 'a');
        }
        System.out.println("Random string: "+str);
    }
    public ArrayList<String> RandomStringArray(){
        ArrayList<String> arr = new ArrayList<String>();
        for(int j = 0; j < 10; ++j){
            String str = "";
            Random rand = new Random();
            for(int i = 0; i < 5; ++i){
                str += (char)(rand.nextInt(26) + 'a');
            }
            arr.add(str);
        }
        return arr;
    }
}