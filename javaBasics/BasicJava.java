import java.util.ArrayList;

public class BasicJava{
    public void ImprimirLaSuma(){
        int i = 1;
        int sum = 0;
        while( i != 255){
            sum+=i++;
            System.out.println("Nuevo numero: "+i+" Suma: "+sum);
            // System.out.println(sum);
            // ++i;
        }
    }

    public void RecorrerArreglo(ArrayList<Object> arr){
        int i = 0; // iterador (i) = 0;
        int len = arr.size(); // Tamanio total del arreglo

        while( i != len ){ // Mientras i sea distinto del largo
            System.out.println(arr.get(i++)); // Imprimir arr[i]
        }
    }

    public int FindMaximum(int[] arr){
        System.out.println("\nBuscando el maximo...");
        if(arr.length > 0){
            int max = arr[0];
            for(int i : arr)
                if(i > max)
                    max = i;
            return max;
        }
        return -1;
    }

    public double FindAverage(int[] arr){
        System.out.println("\nCalculando Promedio...");
        if(arr.length > 0){
            int sum = 0;
            for(int i:arr)
                sum+=i;
            return sum/arr.length;
        }
        return -1;
    }

    public ArrayList<Integer> OddNumbers(){
        System.out.println("\nGenerando arreglo de impares...");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 1;
        for(i = 1; i <= 255; ++i){
            if(i%2 != 0)
                arr.add(i);
        }
        return arr;
    }

    public int GreaterThan(int[] arr, int y){
        System.out.println("\nBuscando elementos mayores que "+y+"...");
        int len = arr.length, cont = 0;
        for(int i = 0; i < len; ++i){
            if(arr[i] > y)
                cont++;
        }
        return cont;
    }
    public void SquareValues(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; ++i){
            arr[i] = arr[i]*arr[i];
        }
    }
    public void DeleteNegatives(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; ++i){
            if(arr[i] < 0)
                arr[i] = 0;
        }
    }
    public int[] MinMaxAvg(int[] arr){
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] > max)    max = arr[i];
            if(arr[i] < min)    min = arr[i];
            sum+=arr[i];
        }
        int[] res = new int[3];
        res[0] = max;
        res[1] = min;
        res[2] = sum/arr.length;
        return res;
    }

    public void SwapNext(int[] arr){
        for(int i = 1; i < arr.length; ++i){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = 0;
    }
    // public void RecorrerArregloConArreglo(int[] arr){
    //     int i = 0; // iterador (i) = 0;
    //     int len = arr.length; // Tamanio total del arreglo

    //     while( i != len ){ // Mientras i sea distinto del largo
    //         System.out.println(arr[i++]); // Imprimir arr[i]
    //     }
    // }

    // public void RecorrerArreglo(){
    //     int i = 0; // iterador (i) = 0;

    //     ArrayList<Object> arr = new ArrayList<Object>();

    //     arr.add(10);
    //     arr.add(1);
    //     arr.add(2);
    //     arr.add(3);
    //     arr.add(4);
    //     int len = arr.size(); // Tamanio total del arreglo

    //     while( i != len ){ // Mientras i sea distinto del largo
    //         System.out.println(arr.get(i++)); // Imprimir arr[i]
    //     }
    // }

    // public int[] Test(){
    //     int[] myArray;
    //     myArray = new int[5];
    //     myArray[0] = 1;
    //     myArray[1] = 1;
    //     myArray[2] = 1;
    //     myArray[3] = 1;
    //     myArray[4] = 1;
    //     return myArray;
    // }
    public void PrintArray(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; ++i){
            System.out.println(arr[i]);
        }
    }
}