import java.util.ArrayList;
public class MainClass{
    public static void main(String[] args){
        Puzzling pz = new Puzzling();
        ArrayList<Integer> res = pz.SumAndGreatherTen();
        System.out.println("Elementos mayores a 10: "+res);
        ArrayList<String> res2 = pz.ShuffleNames();
        System.out.println("Resultado de ShuffleNames: "+res2);
        pz.ShuffleChars();
        System.out.println("Arreglo con numeros aleatorios: " + pz.RandomInteger());
        ArrayList<Integer> rand = pz.SortedRandomInteger();
        System.out.println("Arreglo con numeros aleatorios ordenados: "+rand+"\n"+"Maximum: "+rand.get(rand.size()-1)+" Minimum: "+rand.get(0));

        pz.RandomString();

        System.out.println("Arreglo con strings aleatorios: "+pz.RandomStringArray());
    }
}